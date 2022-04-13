package com.kodilla.stream.immutable;

public class ForumUser {

    private final String userNamm;
    private final String realName;

    public ForumUser(final String userNamm, final String realName) {
        this.userNamm = userNamm;
        this.realName = realName;
    }

    public String getUserNamm() {
        return userNamm;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userNamm='" + userNamm + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
