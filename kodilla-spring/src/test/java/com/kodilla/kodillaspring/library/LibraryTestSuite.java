package com.kodilla.kodillaspring.library;

import com.kodilla.kodillaspring.KodillaSpringApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(KodillaSpringApplication.class);

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }


    @Test
    void testLoadFromDb() {

        //When
        library.loadFromDb();

        //Then
        //do nothing
    }

    @Test
    void testSaveToDb() {
        //Given

        //When
        library.saveToDb();

        //Then
        //do nothing
    }


}
