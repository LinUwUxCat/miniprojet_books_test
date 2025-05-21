package org.example;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Library {
    public final ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        if (book == null) throw new IllegalArgumentException();
        books.add(book);
    }

    public void removeBook(String bookName){
        if (!books.removeIf((book -> book.titre.equals(bookName)))){
            throw new NoSuchElementException();
        }
    }

    public Book searchBook(String bookName){
        for (Book b : books){
            if (b.titre.equals(bookName)) return b;
        }

        throw new NoSuchElementException();
    }

    public void showBooks(){
        for (Book book : books) {
            System.out.println(book.titre + " by " + book.auteur + " (" + book.anneePublication + ")");
        }
    }
}
