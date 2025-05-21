package org.example.tests;

import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library l;

    @BeforeEach
    void before(){
        l = new Library();
    }

    @Test
    void addBook() {
        l.addBook(new Book("Book_Test1", "Auteur_Test1", 2000));
        assertEquals(1, l.books.size());
        l.addBook(new Book("Book_Test2", "Auteur_Test2", 2000));
        assertEquals(2, l.books.size());
    }

    @Test
    void addBookBounds(){
        assertThrows(IllegalArgumentException.class, () -> l.addBook(null));
    }

    @Test
    void removeBook() {
        l.addBook(new Book("Book_Test1", "Auteur_Test1", 2000));
        assertEquals(1, l.books.size());
        l.removeBook("Book_Test1");
        assertEquals(0, l.books.size());
    }

    @Test
    void removeBookBounds(){
        assertThrows(NoSuchElementException.class, () -> l.removeBook("Test"));
    }

    @Test
    void searchBook() {
        l.addBook(new Book("Book_Test1", "Auteur_Test1", 2000));
        assertEquals("Book_Test1", l.searchBook("Book_Test1").titre);
    }

    @Test
    void searchBookBounds() {
        assertThrows(NoSuchElementException.class, () -> l.searchBook("Book_Test1"));
    }
}