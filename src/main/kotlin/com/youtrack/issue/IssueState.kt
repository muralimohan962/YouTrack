package com.youtrack.issue

import java.io.Serializable

enum class IssueState(var renderText: String) : Serializable {
    RESOLVED("Resolved"), IN_PROGRESS("In Progress"), NOT_YET_RESOLVED("Not yet resolved");

    companion object {
        fun fromText(text: String): IssueState {
            return when (text) {
                "Resolved" -> RESOLVED
                "In Progress" -> IN_PROGRESS
                "Not yet resolved" -> NOT_YET_RESOLVED
                else -> throw Exception("Could not find the state for the text: $text")
            }
        }
    }
}