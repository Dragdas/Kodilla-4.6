package com.kodilla.kodillahibernate.task;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique=true)
    private int id;
    private String description;
    private Date created;
    private int duration;

    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }



    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name="CREATED")
    @NonNull
    public Date getCreated() {
        return created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getId() == task.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}