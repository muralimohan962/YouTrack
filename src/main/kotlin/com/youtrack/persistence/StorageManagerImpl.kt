package com.youtrack.persistence

import com.youtrack.issue.Issue
import com.youtrack.issue.impl.IssueImpl
import com.youtrack.user.User
import java.io.Serializable

class StorageManagerImpl : StorageManager, Serializable {
    private val issues = mutableListOf<IssueImpl>()
    private val users = mutableListOf<User>()

    override fun store(user: User) {
        if (!users.containsAsPerValue(user))
            users.add(user)
    }

    override fun remove(user: User) {
        users.remove(user)
    }

    override fun store(issue: Issue) {
        if (!issues.containsAsPerValue(issue))
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


}

private fun <T> Collection<T>.containsAsPerValue(ele: T): Boolean = any { it == ele }