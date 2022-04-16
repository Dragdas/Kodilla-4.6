package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    @Test
    void testAddTaskList(){
        //Given
        Board board = prepareTestData();


        //when
        int result = board.getTaskLists().size();

        //Then
        assertEquals(3, result);

    }

    @Test
    void testAddTaskListFindUsersTasks(){
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");
        List<Task> result = project.getTaskLists().stream()
                            .flatMap(taskList -> taskList.getTasks().stream())
                            .filter(task -> task.getAssignedUser().equals(user))
                            .collect(Collectors.toList());

        //Then
        assertEquals(2, result.size());                        // [6]
        assertEquals(user, result.get(0).getAssignedUser());   // [7]
        assertEquals(user, result.get(1).getAssignedUser());

    }

    @Test
    void testAddTaskListFindOutdatedTasks(){
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));

        List<Task> tasks = project.getTaskLists().stream()
                .filter(taskList -> undoneTasks.contains(taskList))
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getDeadline().compareTo(LocalDate.now()) < 0 )
                .collect(Collectors.toList());

        //Then
        assertEquals(1, tasks.size());
        assertEquals("HQLs for analysis", tasks.get(0).getTitle());


    }

    @Test
    void testAddTaskListFindLongTasks(){
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                        .filter(taskList -> inProgressTasks.contains(taskList))
                        .flatMap(taskList -> taskList.getTasks().stream())
                        .map(Task::getCreated)
                        .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                        .count();



        //Then
        assertEquals(2, longTasks);

    }

    @Test
    void testAddTaskListAverageWorkingOnTask(){
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("In progress"));
        double result =project.getTaskLists().stream()
                        .filter(taskList -> undoneTasks.contains(taskList) )
                        .flatMap(taskList -> taskList.getTasks().stream())
                        .map(task -> {
                            Period duration = Period.between(LocalDate.now(), task.getCreated());
                            return Math.abs(duration.getDays());
                        })
                        .mapToDouble(Integer::doubleValue)
                        .average()
                        .getAsDouble();

        //Then
        assertEquals(10, result);

    }




    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

}
