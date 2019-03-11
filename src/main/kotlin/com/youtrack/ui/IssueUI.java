package com.youtrack.ui;

import com.youtrack.issue.Issue;

import javax.swing.*;
import java.awt.*;

public class IssueUI {
    private JPanel rootPanel;
    private JLabel issueTitle;
    private JLabel priorityLabel;
    private JLabel stateLabel;
    private JLabel subSystemLabel;
    private JLabel projectNameLabel;
    private JLabel assigneeLabel;
    private JLabel fixVersionLabel;

    public IssueUI(Issue issue) {
        issueTitle.setText(issue.getTitle());
        priorityLabel.setText(issue.getPriority().getRenderText());
        stateLabel.setText(issue.getState().getRenderText());
        subSystemLabel.setText(issue.getSubSystem());
        projectNameLabel.setText(issue.getProjectName());

        if (issue.getAssignee() != null) {
            assigneeLabel.setText(issue.getAssignee().getName());
        }
        else {
            assigneeLabel.setText("Not yet assigned");
        }

        fixVersionLabel.setText(issue.getFixVersion());


        rootPanel.setBackground(Color.gray);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JLabel getIssueTitle() {
        return issueTitle;
    }

    public JLabel getPriorityLabel() {
        return priorityLabel;
    }

    public JLabel getStateLabel() {
        return stateLabel;
    }

    public JLabel getSubSystemLabel() {
        return subSystemLabel;
    }

    public JLabel getProjectNameLabel() {
        return projectNameLabel;
    }

    public JLabel getAssigneeLabel() {
        return assigneeLabel;
    }

    public JLabel getFixVersionLabel() {
        return fixVersionLabel;
    }
}
