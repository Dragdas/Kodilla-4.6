package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersCount = 1;
    private int postsCount = 1;
    private int commentsCount = 1;
    private double avrCountOfPostsPerUser = 1;
    private double avrCountOfCommentsPerUser = 1;
    private double avrCountOfCommentsPerPost = 1;

    public void calculateAdvStatistics(Statistics statistics){
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        avrCountOfPostsPerUser    = usersCount == 0 ? 0 : (double)postsCount / usersCount;
        avrCountOfCommentsPerUser = usersCount == 0 ? 0 : (double)commentsCount / usersCount;
        avrCountOfCommentsPerPost = postsCount == 0 ? 0 : (double)commentsCount / postsCount;

    }

    public void showStatistics(){
        System.out.println(toString());
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvrCountOfPostsPerUser() {
        return avrCountOfPostsPerUser;
    }

    public double getAvrCountOfCommentsPerUser() {
        return avrCountOfCommentsPerUser;
    }

    public double getAvrCountOfCommentsPerPost() {
        return avrCountOfCommentsPerPost;
    }

    @Override
    public String toString() {
        return "StatisticsCalculator{" +
                "usersCount=" + usersCount +
                ", postsCount=" + postsCount +
                ", commentsCount=" + commentsCount +
                ", avrCountOfPostsPerUser=" + avrCountOfPostsPerUser +
                ", getAvrCountOfCommentsPerUser=" + avrCountOfCommentsPerUser +
                ", getAvrCountOfCommentsPerPost=" + avrCountOfCommentsPerPost +
                '}';
    }
}
