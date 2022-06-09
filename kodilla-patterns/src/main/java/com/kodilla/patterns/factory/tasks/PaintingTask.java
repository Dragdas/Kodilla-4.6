package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{

    private String name;
    private String color;
    private String whatToPaint;
    private boolean isTaskExecuted = false;

    public PaintingTask(String name, String color, String whatToPaint) {
        this.name = name;
        this.color = color;
        this.whatToPaint = whatToPaint;
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
