package org.example.tests;

import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryFunctionalTest {
    @Test
    void functionalTest(){
        Library l = new Library();
        l.addBook(new Book("1984", "George Orwell", 1949));
        assertEquals(1, l.books.size());
        l.addBook(new Book("Dune", "Frank Herbert", 1965));
        assertEquals(2, l.books.size());
        l.removeBook("1984");
        assertEquals(1, l.books.size());
        l.showBooks();
    }
}
