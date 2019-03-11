package com.youtrack.ui

import com.youtrack.issue.Issue
import javax.swing.DefaultListModel
import javax.swing.JList

class IssueList(model: DefaultListModel<Issue>) : JList<Issue>(model) {

    init {
        cellRenderer = MyListCellRenderer()
    }

    constructor() : this(DefaultListModel())
}