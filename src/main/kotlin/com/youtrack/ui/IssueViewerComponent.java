package com.youtrack.ui;

import javax.swing.*;

public class IssueViewerComponent {
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JList commentsList;
    private JTextArea commentField;
    private JButton addButton;
    private JButton editButton;

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public JList getCommentsList() {
        return commentsList;
    }

    public JTextArea getCommentField() {
        return commentField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }
}
