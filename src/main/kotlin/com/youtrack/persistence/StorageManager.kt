package com.youtrack.persistence

import com.youtrack.issue.Issue
import com.youtrack.user.User

interface StorageManager {
    fun store(user: User)
    fun remove(user: User)
    fun store(issue: Issue)
    fun remove(issue: Issue)
    fun getUsers(): List<User>
    fun getIssues(): List<Issue>
    fun clearIssues()
    fun clearUsers()
}
