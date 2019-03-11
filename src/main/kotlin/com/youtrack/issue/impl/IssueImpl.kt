package com.youtrack.issue.impl

import com.youtrack.issue.Issue
import com.youtrack.issue.IssuePriority
import com.youtrack.issue.IssueState
import com.youtrack.user.User

class IssueImpl(
    override val title: String,
    override val description: String,
    override var priority: IssuePriority = IssuePriority.NORMAL,
    override var state: IssueState = IssueState.NOT_YET_RESOLVED,
    override var subSystem: String = "Not determined",
    override val projectName: String,
    override var assignee: User? = null,
    override val filedBy: User,
    override var fixVersion: String = "Not determined"
) : Issue  {
    override val comments: HashMap<String, User> = HashMap()
}