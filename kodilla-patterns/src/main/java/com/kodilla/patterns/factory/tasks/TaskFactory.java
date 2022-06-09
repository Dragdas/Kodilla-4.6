package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.TaskTypes.*;

public class TaskFactory {


    public static Task taskFactory(TaskTypes type){
        if(type == SHOPPING)
            return new ShoppingTask("Shopping task", "Milk", 1);
        if(type == PAINTING)
            return new PaintingTask("Painting task", "Black", "Wall");
        if(type == DRIVING)
            return new DrivingTask("Driving task", "Tam", "126p");

        return null;
    }

}
