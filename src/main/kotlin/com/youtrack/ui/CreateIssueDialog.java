package com.youtrack.ui;

import javax.swing.*;

public class CreateIssueDialog {
    private JPanel rootPanel;
    private JTextArea titleField;
    private JTextArea descriptionField;
    private JButton createButton;

    public JButton getCreateButton() {
        return createButton;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextArea getDescriptionField() {
        return descriptionField;
    }

    public JTextArea getTitleField() {
        return titleField;
    }
}
