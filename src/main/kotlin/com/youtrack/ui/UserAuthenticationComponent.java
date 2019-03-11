package com.youtrack.ui;

import javax.swing.*;

public class UserAuthenticationComponent {
    private JPanel rootPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JButton logInButton;
    private JPanel containerPanel;


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

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
