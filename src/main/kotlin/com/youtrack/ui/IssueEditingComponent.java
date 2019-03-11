package com.youtrack.ui;

import com.youtrack.issue.Issue;
import com.youtrack.issue.IssuePriority;
import com.youtrack.issue.IssueState;
import com.youtrack.issue.Subsystem;
import com.youtrack.user.User;
import com.youtrack.user.UserUtilsKt;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class IssueEditingComponent {
    private JComboBox<String> priorityCB;
    private JComboBox<String> stateCB;
    private JTextField fixVersionField;
    private JButton saveButton;
    private JPanel rootPanel;
    private JComboBox<String> subsystemCB;
    private JTextField assigneeField;

    public IssueEditingComponent() {
        priorityCB.setModel(new DefaultComboBoxModel<>(new String[]{
                IssuePriority.HIGH.getRenderText(), IssuePriority.LOW.getRenderText(), IssuePriority.NORMAL.getRenderText()
        }));
        stateCB.setModel(new DefaultComboBoxModel<>(new String[] {
                IssueState.IN_PROGRESS.getRenderText(), IssueState.NOT_YET_RESOLVED.getRenderText(), IssueState.RESOLVED.getRenderText()
        }));

        subsystemCB.setModel(new DefaultComboBoxModel<>(Subsystem.INSTANCE.getSubsystems().toArray(new String[] {})));

        priorityCB.setSelectedItem(IssuePriority.NORMAL.getRenderText());
        stateCB.setSelectedItem(IssueState.NOT_YET_RESOLVED.getRenderText());
        subsystemCB.setSelectedItem(Subsystem.NOT_YET_DETERMINED);
    }

    public void setProperties(Issue issue) {
        List<User> users = UserUtilsKt.findUser(assigneeField.getText().trim());
        if (!users.isEmpty() && users.size() == 1)
            issue.setAssignee(users.get(0));
        issue.setFixVersion(fixVersionField.getText().trim());
        issue.setState(IssueState.valueOf(Objects.requireNonNull(stateCB.getSelectedItem()).toString()));
        issue.setPriority(IssuePriority.valueOf(Objects.requireNonNull(priorityCB.getSelectedItem()).toString()));
        issue.setSubSystem(Objects.requireNonNull(subsystemCB.getSelectedItem()).toString());
    }

    public void setState(Issue issue) {
        priorityCB.setSelectedItem(issue.getPriority().getRenderText());
        stateCB.setSelectedItem(issue.getState().getRenderText());
        fixVersionField.setText(issue.getFixVersion().trim());
        subsystemCB.setSelectedItem(issue.getSubSystem());
        assigneeField.setText(issue.getAssignee() == null ? "Not yet assigned!" : issue.getAssignee().getName());
    }

    public JComboBox<String> getPriorityCB() {
        return priorityCB;
    }

    public JComboBox<String> getStateCB() {
        return stateCB;
    }

    public JTextField getFixVersionField() {
        return fixVersionField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
