package com.youtrack.login

import com.youtrack.user.User

object LoginSession {
    private var currentUser: User? = null

    fun setCurrentUser(user: User) {
        currentUser = user
    }

    fun getCurrentUser(): User? = currentUser
}