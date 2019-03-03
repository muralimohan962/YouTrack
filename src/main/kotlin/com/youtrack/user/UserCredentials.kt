package com.youtrack.user

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "credential")
data class UserCredentials(
    @Column(name = "email") val email: String,
    @Column(name = "password") val password: String
) : Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0
}