package com.example.listadapter;

public class Book {
    String author = "";
    String title = "";
    int numPages = 0;
    int cover = 0;

    public Book(String author, String title, int numPages, int cover) {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
        this.cover = cover;
    }

    //TODO comparator


    @Override
    public String toString() {
        return author + "\n" + title + "\n" + numPages;
    }
}
