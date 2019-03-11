package com.youtrack.issue

import java.io.Serializable

enum class IssuePriority(var renderText: String) : Serializable {
    NORMAL("Normal"), LOW("Low"), HIGH("High");

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