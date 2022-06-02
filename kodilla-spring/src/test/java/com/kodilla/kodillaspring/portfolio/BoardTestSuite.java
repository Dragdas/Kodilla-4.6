package com.kodilla.kodillaspring.portfolio;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardTestSuite {

    //given
    @Autowired
    Board board;

    @Test
    @Order(1)
    void testBoard(){

        //when
        int toDoListSize = board.getListSize(Lists.TODO);
        int inProgressListSize = board.getListSize(Lists.INPROGRESS);
        int doneListSize = board.getListSize(Lists.DONE);

        //then
        Assertions.assertEquals(0,toDoListSize);
        Assertions.assertEquals(0,inProgressListSize);
        Assertions.assertEquals(0,doneListSize);

    }


    @Test
    @Order(2)
    void testAddingTask(){

        //when
        board.addTask(Lists.TODO,"to do ...");
        board.addTask(Lists.INPROGRESS, "Doing ...");
        board.addTask(Lists.DONE, "done");


        int toDoListSize = board.getListSize(Lists.TODO);
        int inProgressListSize = board.getListSize(Lists.INPROGRESS);
        int doneListSize = board.getListSize(Lists.DONE);

        //then
        Assertions.assertEquals(1,toDoListSize);
        Assertions.assertEquals(1,inProgressListSize);
        Assertions.assertEquals(1,doneListSize);
    }

    @Test
    @Order(3)
    void testRetrievingTask(){

        //When
        String toDo = board.getTaskByIndex(Lists.TODO, 0);
        String inprogress = board.getTaskByIndex(Lists.INPROGRESS, 0);
        String done = board.getTaskByIndex(Lists.DONE, 0);
        String outOfBound = board.getTaskByIndex(Lists.TODO, 15);

        //then
        Assertions.assertEquals("to do ...", toDo);
        Assertions.assertEquals("Doing ...", inprogress);
        Assertions.assertEquals("done", done);
        Assertions.assertEquals("Index out of bounds", outOfBound);
    }


}
