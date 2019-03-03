package com.youtrack.ui

import com.youtrack.issue.Issue
import java.awt.Component
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.ListCellRenderer

class MyListCellRenderer : ListCellRenderer<Issue> {
    override fun getListCellRendererComponent(
        list: JList<out Issue>?,
        value: Issue?,
        index: Int,
        isSelected: Boolean,
        cellHasFocus: Boolean
    ): Component = JPanel()
}