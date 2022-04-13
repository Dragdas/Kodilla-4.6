package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public final class ForumUser {

    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dob;
    private int postCount = 0;

    public ForumUser(int userID, String userName, char sex, LocalDate dob, int postCount) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dob = dob;
        this.postCount = postCount;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getAge(){
        return Period.between(dob,LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;
        ForumUser forumUser = (ForumUser) o;
        return getUserID() == forumUser.getUserID() && getSex() == forumUser.getSex() && getPostCount() == forumUser.getPostCount() && Objects.equals(getUserName(), forumUser.getUserName()) && Objects.equals(getDob(), forumUser.getDob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getUserName(), getSex(), getDob(), getPostCount());
    }


    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dob=" + dob +
                ", postCount=" + postCount +
                '}';
    }
}
