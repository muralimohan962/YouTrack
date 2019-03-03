package com.youtrack.issue

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "issue_type")
enum class IssueType : Serializable{
    BUG, FEATURE, ARCHITECTURAL;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0

    constructor()
}