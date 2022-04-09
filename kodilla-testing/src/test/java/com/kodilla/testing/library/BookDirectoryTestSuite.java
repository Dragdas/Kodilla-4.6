package com.kodilla.testing.library;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Mock
    private LibraryUser libraryUserMock;


    @Nested
    @DisplayName("testing: ListOfBooksWithCondition")
    class testGettingListOfBooksWithCondition{
        @Test
        void testListBooksWithConditionsReturnList() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {

            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            List<Book> emptyBooksList = new ArrayList<>();
            List<Book> bookList15 = generateListOfNBooks(15);
            List<Book> bookList50 = generateListOfNBooks(50);

            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(bookList15);
            when(libraryDatabaseMock.listBooksWithCondition("empty")).thenReturn(emptyBooksList);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(bookList50);

            //When
            List<Book> resultCaseEmpty = bookLibrary.listBooksWithCondition("empty");
            List<Book> resultCase15 =  bookLibrary.listBooksWithCondition("any ");
            List<Book> resultCase50 = bookLibrary.listBooksWithCondition("FortyBooks");

            //Then
            assertEquals(0, resultCaseEmpty.size());
            assertEquals(15, resultCase15.size());
            assertEquals(0, resultCase50.size());

        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }

    }

    @Nested
    class testGettingListBooksInHandsOf{

        @Test
        void testListBooksInHandsOf0Books(){
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUserMock)).thenReturn(new ArrayList<>());

            //When
            List<Book> result = bookLibrary.listBooksInHandsOf(libraryUserMock);

            //Then
            assertEquals(0,result.size());
        }

        @Test
        void testListBooksInHandsOf1Book(){
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> books = generateListOfNBooks(1);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUserMock)).thenReturn(books);

            //When
            List<Book> result = bookLibrary.listBooksInHandsOf(libraryUserMock);

            //Then
            assertEquals(1,result.size());

        }

        @Test
        void testListBooksInHandsOf5Books(){
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> books = generateListOfNBooks(5);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUserMock)).thenReturn(books);

            //When
            List<Book> result = bookLibrary.listBooksInHandsOf(libraryUserMock);

            //Then
            assertEquals(5,result.size());
        }

    }





    private List<Book> generateListOfNBooks(int quantity){
        List<Book> books = new ArrayList<>();
        for (int i = quantity ; i > 0 ; i--){
            Book b = new Book("Title " + i, "Author " + i, 1970+i);
            books.add(b);
        }
        return books;
    }

}
