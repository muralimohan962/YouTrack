package com.youtrack.ui;

import javax.swing.*;

public class ControlUIComponent {
    private JComboBox priorityCB;
    private JComboBox stateCB;
    private JTextField fixVersionField;
    private JButton saveButton;
    private JPanel rootPanel;

    public JComboBox getPriorityCB() {
        return priorityCB;
    }

    public JComboBox getStateCB() {
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
