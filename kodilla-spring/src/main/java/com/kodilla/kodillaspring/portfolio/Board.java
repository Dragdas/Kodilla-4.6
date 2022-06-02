package com.kodilla.kodillaspring.portfolio;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    private Map<Lists, TaskList> listMap = new HashMap<>();


    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;

        listMap.put(Lists.TODO, this.toDoList);
        listMap.put(Lists.INPROGRESS, this.inProgressList);
        listMap.put(Lists.DONE, this.doneList);

    }

    public void addTask(Lists list, String task){
        TaskList listToBeExtended = listMap.get(list);

        listToBeExtended.addTask(task);

    }

    public String getTaskByIndex(Lists list, int index){
        TaskList listToRetrieve = listMap.get(list);

        return listToRetrieve.getTask(index);
    }

    public int getListSize(Lists list){
        TaskList listToRetrieve = listMap.get(list);

        return listToRetrieve.getListSize();
    }

}
