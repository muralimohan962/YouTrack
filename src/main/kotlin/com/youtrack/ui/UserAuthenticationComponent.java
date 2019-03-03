package com.youtrack.ui;

import javax.swing.*;

public class UserAuthenticationComponent {
    private JPanel rootPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JCheckBox getShowPasswordCheckBox() {
        return showPasswordCheckBox;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    private JButton logInButton;

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
