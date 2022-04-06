package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");


        // 6.2 Test 1
        String name = "Chris";
        SimpleUser user = new SimpleUser(name);
        String resultTest1 = user.getUserName();
        String out = name.equals(resultTest1) ? "Test1 ok" : "Test1 failed";
        System.out.println(out);

        // 6.2 Test 2 add
        int[] inputsTest2 = {5,8};
        int expectedResultTest2 = inputsTest2[0] + inputsTest2[1];
        int addResultTest2 = Calculator.add(inputsTest2[0], inputsTest2[1]);
        String outTest2 = expectedResultTest2 == addResultTest2 ? "Test 2 add - OK" : "Test 2 add - failed";
        System.out.println(outTest2);

        // 6.2 Test 3 sub
        int[] inputsTest3 = {15,12};
        int expectedResultTest3 = inputsTest3[0] - inputsTest3[1];
        int subResultTest3 = Calculator.subtract(inputsTest3[0], inputsTest3[1]);
        String outTest3 = expectedResultTest3 == subResultTest3 ? "Test 3 subtract - OK" : "Test 3 subtract  - failed";
        System.out.println(outTest3);


    }
}
