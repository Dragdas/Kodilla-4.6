package com.kodilla.kodillaspring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task){
        tasks.add(task);
    }

    public String getTask(int index){
        return index < tasks.size() && index >= 0 ? tasks.get(index) : "Index out of bounds";
    }

    public int getListSize(){
        return tasks.size();
    }
}
