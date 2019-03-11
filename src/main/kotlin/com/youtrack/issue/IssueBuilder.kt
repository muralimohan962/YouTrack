package com.youtrack.issue

import com.youtrack.issue.impl.IssueImpl
import com.youtrack.user.User

class IssueBuilder(private val title: String, private val description: String, val filedBy: User) {
    private  var priority: IssuePriority? = null
    private  var state: IssueState? = null
    private  var subSystem: String? = null
    private  var projectName: String? = null

    fun build(): Issue {
        if (priority == null)
            priority = IssuePriority.NORMAL
        if (state == null)
            state = IssueState.NOT_YET_RESOLVED
        if (subSystem == null)
            subSystem = "No determined"
        if (projectName == null)
            projectName = "No determined"

        return IssueImpl(title, description, priority!!, state!!, subSystem!!, projectName!!, null, filedBy, "Not determined")
    }

    fun projectName(name: String): IssueBuilder {
        projectName = name
        return this
    }

    fun state(state: IssueState): IssueBuilder {
        this.state = state
        return this
    }

    fun subSystem(subSystem: String): IssueBuilder {
        this.subSystem = subSystem
        return this
    }

    fun priority(priority: IssuePriority): IssueBuilder {
        this.priority = priority
        return this
    }
}