package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handleException(double x, double y){

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String s = secondChallenge.probablyIWillThrowException(x, y);
            System.out.println(s);
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }finally {
            System.out.println("End of second challenge ");
        }



    }

}
