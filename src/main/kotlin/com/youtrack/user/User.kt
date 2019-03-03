package com.youtrack.user

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Column(name = "name")
    val name: String,
    @Column(name = "credentials")
    val credentials: UserCredentials,
    @Column(name = "admin")
    val isAdmin: Boolean = false
) {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0

    override fun toString(): String {
        return "Name: $name"
    }
}

