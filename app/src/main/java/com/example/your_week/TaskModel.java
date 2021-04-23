package com.example.your_week;

public class TaskModel {

    Integer id;
    String taskName;
    String taskDate;
    String taskTime;

    //constructor
    public TaskModel(String taskName, String taskDate, String taskTime) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
    }

    public TaskModel(int id, String taskName, String taskDate, String taskTime) {
        this.id = id;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
    }


    //Getterit ja setterit
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }
}