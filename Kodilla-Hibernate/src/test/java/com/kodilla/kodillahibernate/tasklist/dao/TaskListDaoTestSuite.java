package com.kodilla.kodillahibernate.tasklist.dao;

import com.kodilla.kodillahibernate.tasklist.TaskList;
import com.kodilla.kodillahibernate.tasklist.TaskListDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;


    @Test
    void testFindByListName(){


        //Given
        String taskListName = "Test task list";
        TaskList taskList = new TaskList( taskListName, "Test");
        taskListDao.save(taskList);

        //When
        List<TaskList> taskLists = taskListDao.findByListName(taskListName);
        int listSize = taskLists.size();

        //Then
        Assertions.assertEquals(1,listSize);

        //Cleanup
        taskListDao.delete(taskList);

    }


}
