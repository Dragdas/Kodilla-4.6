package com.kodilla.patterns2.adapter.company.bookclasifier;

import com.kodilla.patterns2.adapter.company.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.company.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.BookSignature;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Book> bookMap = new HashMap<>();
        bookSet.forEach(book -> {
            BookSignature signature = new BookSignature(book.getSignature());
            com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Book bookToBeAdded = new com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Book(
                    book.getAuthor(),
                    book.getTitle(),
                    book.getPublicationYear()
            );
            bookMap.put(signature,bookToBeAdded);
        });

        return medianPublicationYear(bookMap);
    }

}
