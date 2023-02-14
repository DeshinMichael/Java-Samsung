package com.example.listadapter;

public class Book {
    String author = "";
    String title = "";
    int numPages = 0;

    public Book(String author, String title, int numPages) {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    //TODO comparator


    @Override
    public String toString() {
        return author + "\n" + title + "\n" + numPages;
    }
}
