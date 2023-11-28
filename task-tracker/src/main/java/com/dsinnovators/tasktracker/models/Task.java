package com.dsinnovators.tasktracker.models;

import java.util.Date;

public class Task {

    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Status getStatusId() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
