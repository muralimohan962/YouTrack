package com.youtrack.ui

import com.youtrack.issue.Issue
import com.youtrack.issue.IssueBuilder
import com.youtrack.login.LoginSession
import com.youtrack.user.User
import com.youtrack.user.UserCredentials
import com.youtrack.utils.StorageUtils
import java.awt.CardLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.*

class MyPanel : JPanel(CardLayout()), ActionListener {
    private val listModel = DefaultListModel<Issue>()
    private val issuesComponent = IssuesComponent()
    private val authenticationComponent = UserAuthenticationComponent()
    private val signUpComponent = UserSignupComponent()
    private val loginOrSignUpComponent = LoginOrSignUpComponent()
    private val storageManager = StorageUtils.storageManager

    init {
        initUI()
        issuesComponent.issueList.model = listModel
        storageManager.getIssues().forEach { listModel.addElement(it) }

        add(issuesComponent.rootPanel, ISSUES_LIST)
        add(authenticationComponent.rootPanel, USER_AUTHENTICATION)
        add(signUpComponent.rootPanel, USER_REGISTRATION)

        issuesComponent.createButton.addActionListener {
            val frame = JFrame()
            val dialog = CreateIssueDialog()
            dialog.createButton.addActionListener {
                createIssue(dialog.titleField.text, dialog.descriptionField.text, LoginSession.getCurrentUser()!!)
            }

            frame.run {
                setSize(500, 500)
                add(dialog.rootPanel)
                pack()
                defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
                isVisible = true
            }
        }

        authenticationComponent.logInButton.addActionListener {
            if (authenticate(authenticationComponent.emailField.text, authenticationComponent.passwordField.getText()))
                (layout as CardLayout).show(this, ISSUES_LIST)
        }

        authenticationComponent.showPasswordCheckBox.addItemListener {
            if (authenticationComponent.showPasswordCheckBox.isSelected)
                authenticationComponent.passwordField.showPassword()
            else
                authenticationComponent.passwordField.hidePassword()
        }

        signUpComponent.signUpButton.addActionListener {
            if (registerUser(
                    signUpComponent.nameField.text,
                    signUpComponent.emailField.text,
                    signUpComponent.passwordField.text,
                    signUpComponent.confirmPasswordField.text,
                    signUpComponent.adminCheckBox.isSelected
                )
            ) (layout as CardLayout).show(this, USER_AUTHENTICATION)
        }

        add(loginOrSignUpComponent.rootPanel, INITIAL_COMPONENT)

        (layout as CardLayout).show(this, INITIAL_COMPONENT)

        loginOrSignUpComponent.logInButton.addActionListener {
            (layout as CardLayout).show(this, USER_AUTHENTICATION)
        }

        loginOrSignUpComponent.signUpButton.addActionListener {
            (layout as CardLayout).show(this, USER_REGISTRATION)
        }

    }

    override fun actionPerformed(e: ActionEvent?) {

    }

    private fun createIssue(title: String, description: String, user: User) {
        val issue = IssueBuilder(title, description, user).build()
        StorageUtils.storageManager.store(issue)
        listModel.addElement(issue)
    }

    private fun authenticate(email: String, password: String): Boolean {
        val user = StorageUtils.storageManager.getUsers().firstOrNull {
            it.credentials.email.equals(email, false) && it.credentials.password.equals(
                password,
                false
            )
        }

        if (user == null) {
            JOptionPane.showMessageDialog(this, "No such user found!", "Cannot login", JOptionPane.ERROR_MESSAGE)
            return false
        }

        LoginSession.setCurrentUser(user)
        return true
    }

    private fun registerUser(
        name: String,
        email: String,
        password: String,
        confirmPassword: String,
        isAdmin: Boolean
    ): Boolean {
        if (!password.equals(confirmPassword, ignoreCase = false)) {
            JOptionPane.showMessageDialog(this, "Password mismatch!", "Error sign up", JOptionPane.ERROR_MESSAGE)
            return false
        }

        StorageUtils.storageManager.store(User(name, UserCredentials(email, password), isAdmin))
        println("User stored!")
        return true
    }

    private fun initUI() {
        issuesComponent.searchField.addKeyListener(object : KeyAdapter() {
            override fun keyTyped(e: KeyEvent?) {
                val keyChar = e?.keyChar!!
                if (keyChar in 'a'..'z' || keyChar in 'A'..'Z')
                    processQuery("${issuesComponent.searchField.text}$keyChar")
            }
        })
    }

    private fun processQuery(query: String) {
        val searchField = issuesComponent.searchField
        val result = StorageUtils.storageManager.getIssues().filter {
            it.title.startsWith(query, ignoreCase = true) || (it.title.contains(
                query,
                ignoreCase = true
            ) && query.length >= 12)
        }
        searchField.componentPopupMenu = JPopupMenu("Suggestions")
        result.forEach { searchField.componentPopupMenu.add(it.title) }
        searchField.componentPopupMenu.show(this, searchField.x, searchField.y + searchField.height)
        searchField.requestFocus()
    }

    companion object {
        private const val INITIAL_COMPONENT = "initial.component"
        private const val USER_AUTHENTICATION = "user.authentication"
        private const val USER_REGISTRATION = "user.registration"
        private const val ISSUES_LIST = "issues.list"
        private const val LIST_EDITING_COMPONENT = "list.editing"
    }
}

private fun JPasswordField.showPassword() {
    echoChar = 0.toChar()
}

private fun JPasswordField.hidePassword() {
    echoChar = '*'
}

private fun JPasswordField.getText(): String {
    val builder = StringBuilder()
    password.forEach { builder.append(it) }
    return builder.toString()
}