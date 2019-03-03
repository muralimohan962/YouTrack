package com.youtrack.issue

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "priority")
enum class IssuePriority(@Column(name = "render")@JvmField var renderText: String) : Serializable {
    NORMAL("Normal"), LOW("Low"), HIGH("High");
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0

    constructor()

    companion object {
        fun fromText(text: String): IssuePriority {
            return when(text) {
                "Normal" -> NORMAL
                "Low" -> LOW
                "High" -> HIGH
                else -> throw Exception("Could not find the priority for the text: $text")
            }
        }
    }
}