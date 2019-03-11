package com.youtrack.issue

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

enum class IssueType : Serializable{
    BUG, FEATURE, ARCHITECTURAL;
}