package com.kodilla.kodillahibernate.tasklist;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskListDao extends CrudRepository<TaskList, Integer> {

    List<TaskList> findByListName(String listName);
}
