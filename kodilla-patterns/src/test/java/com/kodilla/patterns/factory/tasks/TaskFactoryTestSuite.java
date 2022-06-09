package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    @Test
    void factoryTest(){

        //When
        Task shoppingTask = TaskFactory.taskFactory(TaskTypes.SHOPPING);
        Task paintingTask = TaskFactory.taskFactory(TaskTypes.PAINTING);
        Task drivingTask = TaskFactory.taskFactory(TaskTypes.DRIVING);

        //Then

        Assertions.assertEquals("Shopping task", shoppingTask.getTaskName());
        Assertions.assertEquals("Painting task", paintingTask.getTaskName());
        Assertions.assertEquals("Driving task", drivingTask.getTaskName());

    }


}
