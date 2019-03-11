package com.youtrack.ui;

import javax.swing.*;

public class IssuesComponent {
    private JTextField searchField;
    private JButton createButton;
    private JPanel listContainer;
    private JPanel rootPanel;
    private JScrollPane scrollPane;
    private IssueList issueList;


    public IssuesComponent() {
        searchField.setBorder(BorderFactory.createTitledBorder("Search"));
//        issueList.setBackground(Color.BLACK);
    }

    public JTextField getSearchField() {
        return searchField;
    }


    public JButton getCreateButton() {
        return createButton;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public IssueList getIssueList() {
        return issueList;
    }

    private void createUIComponents() {
        issueList = new IssueList(new DefaultListModel<>());
        scrollPane = new JScrollPane(issueList);
    }
}
