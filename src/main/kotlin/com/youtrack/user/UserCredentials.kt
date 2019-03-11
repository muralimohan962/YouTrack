package com.youtrack.user

import java.io.Serializable

data class UserCredentials(val email: String, val password: String) : Serializable