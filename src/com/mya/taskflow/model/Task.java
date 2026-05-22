package com.mya.taskflow.model;

import java.time.LocalDate;

public class Task {
    private String title;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    // Constructor
    public Task(String title, Priority priority, LocalDate dueDate){
        this.title = title;
        this.status = Status.TODO;
        this.priority = priority;
        this.dueDate = dueDate;
    }
    public void moveTo(Status newStatus){
        this.status = newStatus;

    }
    public void changePriority(Priority newPriority){
        this.priority = newPriority;

    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
