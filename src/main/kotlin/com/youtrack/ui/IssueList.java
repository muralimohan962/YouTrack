package com.youtrack.ui;

import com.youtrack.issue.Issue;

import javax.swing.*;

public class IssueList extends JList<Issue> {

    public IssueList(DefaultListModel<Issue> model) {
        super(model);
        setCellRenderer(new MyListCellRenderer());
    }

    public IssueList() {
        setCellRenderer(new MyListCellRenderer());
    }
}