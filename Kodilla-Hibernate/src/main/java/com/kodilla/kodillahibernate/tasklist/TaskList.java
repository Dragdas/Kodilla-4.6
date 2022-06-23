package com.kodilla.kodillahibernate.tasklist;


import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique=true)
    private int id;
    private String listName;
    private String description;

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "LISTNAME")
    @NonNull
    public String getListName() {
        return listName;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
