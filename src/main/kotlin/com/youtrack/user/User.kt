package com.youtrack.user

/**
 * Represents a user.
 *
 * @author Murali
 * @author Sree hari
 * @author Sony
 * @author Sushma
 */
data class User(val name: String, val credentials: UserCredentials, val isAdmin: Boolean = false) {

    override fun toString(): String {
        return "Name: $name"
    }
}

