package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class LibraryTestSuite {

    private static Library library;

    @BeforeEach
    public void setLibrary(){
        //Given
        library = new Library("BUW");
        Book book1 = new Book("Title 1", "Author 1", LocalDate.now());
        Book book2 = new Book("Title 2", "Author 1", LocalDate.now());
        Book book3 = new Book("Title 3", "Author 2", LocalDate.now());
        Book book4 = new Book("Title 4", "Author 3", LocalDate.now());

        library.getBooks().addAll(List.of(book1,book2,book3,book4));
    }


    @Test
    void testGetBooks(){

        //Then
        Assertions.assertEquals(4, library.getBooks().size());

    }

    @Test
    void testShallowClone(){
        Library clonedLibrary = null;
        //when
        try {
            clonedLibrary = library.shallowCopy();
        }catch (Exception e){
            System.out.println(e);
        }

        clonedLibrary.getBooks().clear();

        //then
        Assertions.assertEquals(library.getBooks().size(), 0);

    }

    @Test
    void testDeepClone(){

        Library clonedLibrary = null;
        //when
        try {
            clonedLibrary = library.deepCopy();
        }catch (Exception e){
            System.out.println(e);
        }

        clonedLibrary.getBooks().clear();

        //Then
        Assertions.assertEquals(4, library.getBooks().size());
        Assertions.assertEquals(0, clonedLibrary.getBooks().size());

    }

}
