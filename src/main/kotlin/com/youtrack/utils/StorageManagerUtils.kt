package com.youtrack.utils

import com.youtrack.persistence.StorageManager
import com.youtrack.user.User

fun StorageManager.contains(user: User) = getUsers().any {
    it.name.equals(user.name, ignoreCase = false)
            && it.credentials.email.equals(
        user.credentials.email,
        ignoreCase = false
    ) && it.credentials.password.equals(user.credentials.password) && it.isAdmin == user.isAdmin
}

fun StorageManager.contains(email: String): Boolean =
    getUsers().any { it.credentials.email.equals(email, ignoreCase = false) }