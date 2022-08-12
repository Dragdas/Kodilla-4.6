package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.company.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.company.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest(){
        //Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("a","b",2000,"c"));
        books.add(new Book("a","b",2001,"c"));
        books.add(new Book("a","b",1999,"c"));

        //When
        MedianAdapter adapter = new MedianAdapter();
        int median = adapter.publicationYearMedian(books);

        //then
        Assertions.assertEquals(2000,median);

    }
}
