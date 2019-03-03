package com.youtrack.issue

import com.youtrack.user.User
import java.io.Serializable

interface Issue : Serializable {
    val title: String
    val description: String
    var priority: IssuePriority
    val projectName: String
    var state: IssueState
    var subSystem: String
    var assignee: User
    var fixVersion: String
    val filedBy: User
    val comments: MyHashMap<String, User>
}

class MyHashMap<K, V> : HashMap<K, V>(), Serializable