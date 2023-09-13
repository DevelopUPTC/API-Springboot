package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private String id;

    @Column(name = "title_book")
    private String titleBook;

    @Column(name = "release_book")
    private LocalDate releaseBook;

    @Column
    private int pages;

    @ManyToOne
    @JoinColumn(name = "ref_author", nullable = false)
    private Author author;

    public Book() {
    }

    public Book(String id, String titleBook,  LocalDate releaseBook, int pages) {
        this.id = id;
        this.titleBook = titleBook;
        this.releaseBook = releaseBook;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }


    public LocalDate getReleaseBook() {
        return releaseBook;
    }

    public void setReleaseBook(LocalDate releaseBook) {
        this.releaseBook = releaseBook;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", titleBook='" + titleBook + '\'' +
                ", releaseBook=" + releaseBook +
                ", pages=" + pages +
                '}';
    }
}
