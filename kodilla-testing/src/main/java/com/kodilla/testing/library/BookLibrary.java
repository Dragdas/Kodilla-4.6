package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {

    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment){

        List<Book> books = new ArrayList<>();
        if(titleFragment.length()<3)
            return books;

        books = libraryDatabase.listBooksWithCondition(titleFragment);

        if(books.size() > 20)
            return new ArrayList<>();

        return books;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser){

        return libraryDatabase.listBooksInHandsOf(libraryUser);

    }


}
