package com.youtrack.ui;

import javax.swing.*;

public class UserSignupComponent {
    private JPanel rootPanel;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    private JCheckBox adminCheckBox;
    private JButton signUpButton;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JTextField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public JCheckBox getAdminCheckBox() {
        return adminCheckBox;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

}
