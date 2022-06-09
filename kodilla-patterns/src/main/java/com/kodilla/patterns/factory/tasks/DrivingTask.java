package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{

    private String name;
    private String where;
    private String using;
    private boolean isTaskExecuted = false;

    public DrivingTask(String name, String where, String using) {
        this.name = name;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task");
        isTaskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
