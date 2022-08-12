package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    void testUpdate(){
        //given
        Student mark = new Student("Mark");
        Student zofia = new Student("Zofia");
        Student mandy = new Student("Mandy");

        Mentor adrian = new Mentor("Adrian");
        Mentor zbyszek = new Mentor("Zbych");

        //when
        mark.registerObserver(adrian);
        zofia.registerObserver(zbyszek);
        mandy.registerObserver(zbyszek);

        mark.submitHomework("code");
        mark.submitHomework("code 2");
        mandy.submitHomework("super code");
        zofia.submitHomework("code");

        int adrianNotificationCont = adrian.getCounter();
        int zbyszekNotificationCount= zbyszek.getCounter();

        //then
        assertEquals(2,zbyszekNotificationCount);
        assertEquals(2,adrianNotificationCont);
    }


}
