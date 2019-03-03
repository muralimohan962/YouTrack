package com.youtrack.ui

import com.youtrack.issue.Issue
import com.youtrack.issue.IssuePriority
import com.youtrack.issue.IssueState
import com.youtrack.user.User
import com.youtrack.user.UserCredentials
import com.youtrack.utils.StorageUtils
import com.youtrack.utils.contains
import com.youtrack.utils.isFilled
import java.awt.CardLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class MyPanel : JPanel(CardLayout()), ActionListener {
    private val userAuthenticationComponent = UserAuthenticationComponent()
    private val userRegistrationComponent = UserSignupComponent()
    private val model = DefaultListModel<Issue>()
    private val issuesList = IssueList(model)
    private val storageManager = StorageUtils.storageManager
    private val loginButton = JButton("Log In")
    private val signUpButton = JButton("Sign Up")
    private var previous = ""
    private val component = ControlUIComponent()


    init {
        storageManager.getIssues().forEach { model.addElement(it) }
        add(issuesList, ISSUES_LIST)
        add(userAuthenticationComponent.rootPanel, USER_AUTHENTICATION)
        add(userRegistrationComponent.rootPanel, USER_REGISTRATION)
        val panel = JPanel()
        panel.add(loginButton)
        panel.add(signUpButton)

        loginButton.isFocusPainted = false
        signUpButton.isFocusPainted = false

        loginButton.addActionListener(this)
        signUpButton.addActionListener(this)

        userAuthenticationComponent.logInButton.addActionListener(this)
        userRegistrationComponent.signUpButton.addActionListener(this)

        add(panel, INITIAL_COMPONENT)

        add(component.rootPanel, LIST_EDITING_COMPONENT)

        (layout as CardLayout).show(this, INITIAL_COMPONENT)
        previous = INITIAL_COMPONENT

        component.priorityCB.model = DefaultComboBoxModel(
            arrayOf(
                IssuePriority.HIGH.renderText,
                IssuePriority.LOW.renderText,
                IssuePriority.NORMAL.renderText
            )
        )
        component.stateCB.model = DefaultComboBoxModel(
            arrayOf(
                IssueState.NOT_YET_RESOLVED.renderText,
                IssueState.RESOLVED.renderText,
                IssueState.IN_PROGRESS.renderText
            )
        )

        issuesList.addListSelectionListener {
            if (it.valueIsAdjusting) return@addListSelectionListener
            (layout as CardLayout).show(this, LIST_EDITING_COMPONENT)
        }
    }

    private fun authenticate(email: String, password: String) {
        if (storageManager.getUsers().any {
                it.credentials.email.equals(
                    email,
                    ignoreCase = false
                ) && it.credentials.password.equals(password, ignoreCase = false)
            }) {
            (layout as CardLayout).show(this, ISSUES_LIST)
            println("Implement the authentication!")
        } else {
            JOptionPane.showMessageDialog(
                userAuthenticationComponent.rootPanel,
                "No such user found! Please sign up!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            )
            (layout as CardLayout).show(this, USER_REGISTRATION)
        }
    }

    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            loginButton -> (layout as CardLayout).show(this, USER_AUTHENTICATION)
            signUpButton -> (layout as CardLayout).show(this, USER_REGISTRATION)
            userAuthenticationComponent.logInButton -> authenticate(userAuthenticationComponent.emailField.text, userAuthenticationComponent.passwordField.text)
            userRegistrationComponent.signUpButton -> {
                signUp(
                    userRegistrationComponent.nameField.text,
                    userRegistrationComponent.emailField.text,
                    userRegistrationComponent.passwordField.text,
                    userRegistrationComponent.confirmPasswordField.text,
                    userRegistrationComponent.adminCheckBox.isSelected
                )
            }
        }
    }

    private fun signUp(name: String, email: String, password: String, confirmPassword: String, isAdmin: Boolean) {
        var message = ""
        when {
            !name.isFilled() -> message = "Please enter the name."
            !email.isFilled() -> message = "Please enter the email."
            !password.isFilled() || !password.equals(confirmPassword, ignoreCase = false) -> message =
                "Password must be 8 chars long."
        }

        if (message != "") {
            JOptionPane.showMessageDialog(
                userRegistrationComponent.rootPanel,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
            )
            return
        }

        if (!storageManager.contains(email)) {
            storageManager.store(User(name, UserCredentials(email, password), isAdmin))
            JOptionPane.showMessageDialog(
                userRegistrationComponent.rootPanel,
                "Sign Up successful!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            )
        }
    }

    companion object {
        private const val INITIAL_COMPONENT = "initial.component"
        private const val USER_AUTHENTICATION = "user.authentication"
        private const val USER_REGISTRATION = "user.registration"
        private const val ISSUES_LIST = "issues.list"
        private const val LIST_EDITING_COMPONENT = "list.editing"
    }
}