package com.youtrack.persistence

import com.youtrack.issue.Issue
import com.youtrack.issue.impl.IssueImpl
import com.youtrack.user.User
import java.io.Serializable

class StorageManagerImpl : StorageManager, Serializable {
    private val issues = MyMutableList<IssueImpl>()
    private val users = MyMutableList<User>()

    override fun store(user: User) {
        if (!users.contains(user))
            users.add(user)
    }

    override fun remove(user: User) {
        users.remove(user)
    }

    override fun store(issue: Issue) {
        issues.add(issue as IssueImpl)
    }

    override fun remove(issue: Issue) {
        issues.remove(issue)
    }

    override fun getUsers(): List<User> {
        return users
    }

    override fun getIssues(): List<Issue> {
        return issues
    }

    override fun clearIssues() {
        issues.clear()
    }

    override fun clearUsers() {
        users.clear()
    }

    private class MyMutableList<E> : ArrayList<E>(), Serializable
}