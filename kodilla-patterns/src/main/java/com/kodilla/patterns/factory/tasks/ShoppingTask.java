package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{

    private String name;
    private String whatToBuy;
    private double quantity;
    private boolean isTaskExecuted = false;

    ShoppingTask(String taskName, String whatToBuy, double quantity){
        this.name = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;

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
