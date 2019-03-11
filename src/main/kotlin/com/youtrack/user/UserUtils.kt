package com.youtrack.user

import com.youtrack.utils.StorageUtils

fun findUser(name: String): List<User> =
    StorageUtils.storageManager.getUsers().filter { it.name.contains(name, ignoreCase = true) }

fun findUserBy(email: String): User? =
    StorageUtils.storageManager.getUsers().firstOrNull { it.credentials.email.equals(email, ignoreCase = false) }