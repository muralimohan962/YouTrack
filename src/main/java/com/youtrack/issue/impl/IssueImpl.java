package com.youtrack.issue.impl;

import com.youtrack.issue.Issue;
import com.youtrack.issue.IssuePriority;
import com.youtrack.issue.IssueState;
import com.youtrack.issue.MyHashMap;
import com.youtrack.user.User;
import org.jetbrains.annotations.NotNull;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Entity
@Table(name = "issue")
public class IssueImpl implements Issue {
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    private IssuePriority priority;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "state")
    private IssueState state;
    @Column(name = "subsystem")
    private String subsystem;
    @Column(name = "assignee")
    private User assignee;
    @Column(name = "filed_by")
    private User filedBy;
    @Column(name = "fix_version")
    private String fixversion;
    @Column(name = "comments")
    private MyHashMap<String, User> comments;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public IssueImpl() {
    }

    public IssueImpl(String title, String description, IssuePriority priority, IssueState state, String subsystem, String projectName, User assignee, User filedBy, String fixversion) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.state = state;
        this.subsystem = subsystem;
        this.projectName = projectName;
        this.assignee = assignee;
        this.filedBy = filedBy;
        this.fixversion = fixversion;
    }

    public IssueImpl(String title, String description, IssuePriority priority, IssueState state, String subsystem, String projectName, User assignee, User filedBy, String fixversion, MyHashMap<String, User> comments) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.state = state;
        this.subsystem = subsystem;
        this.projectName = projectName;
        this.assignee = assignee;
        this.filedBy = filedBy;
        this.fixversion = fixversion;
        this.comments = comments;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @NotNull
    @Override
    public String getTitle() {
        return title;
    }

    @NotNull
    @Override
    public String getDescription() {
        return description;
    }

    @NotNull
    @Override
    public IssuePriority getPriority() {
        return priority;
    }

    @Override
    public void setPriority(@NotNull IssuePriority issuePriority) {
        this.priority = issuePriority;
    }

    @NotNull
    @Override
    public String getProjectName() {
        return projectName;
    }

    @NotNull
    @Override
    public IssueState getState() {
        return state;
    }

    @Override
    public void setState(@NotNull IssueState issueState) {
        state = issueState;
    }

    @NotNull
    @Override
    public String getSubSystem() {
        return subsystem;
    }

    @Override
    public void setSubSystem(@NotNull String s) {
        subsystem = s;
    }

    @NotNull
    @Override
    public User getAssignee() {
        return assignee;
    }

    @Override
    public void setAssignee(@NotNull User user) {
        assignee = user;
    }

    @NotNull
    @Override
    public String getFixVersion() {
        return fixversion;
    }

    @Override
    public void setFixVersion(@NotNull String s) {
        fixversion = s;
    }

    @NotNull
    @Override
    public User getFiledBy() {
        return filedBy;
    }

    @NotNull
    @Override
    public MyHashMap<String, User> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nPriority: " + priority.renderText + "\nState: " + state.getRenderText();
    }
}