package com.bookstore.entities;


import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Title field cannot be null!")
    @NotEmpty(message = "Title field cannot be blank!")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Author field cannot be null!")
    @NotEmpty(message = "Author field cannot be blank!")
    @Column(name = "author")
    private String author;

    @NotNull(message = "Price field cannot be null!")
    @Min(1)
    @Column(name = "price")
    private float price;

    @NotNull(message = "Pages field cannot be null!")
    @Min(10)
    @Column(name = "pages")
    private int pages;

    @NotNull(message = "Publication date cannot be null!")
    @Min(1)
    @Max(2019)
    @Column(name = "publication_date")
    private int publication_date;

    @NotNull(message = "Cover URL cannot be null!")
    @NotEmpty(message = "Cover URL cannot be blank!")
    @URL(message = "Wrong URL format")
    @Column(name = "cover")
    private String cover;

    @NotNull(message = "Status cannot be null!")
    @NotEmpty(message = "Status cannot be blank!")
    @Pattern(regexp = "owned|to-buy", message = "Two values are acceptable \'owned\' or \'to-buy\'")
    @Column(name = "status")
    private String status;

    public Book() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return addTitleQuotes(this.title);
    }

    public String addTitleQuotes(String currentTitle){
        return ("\"" + currentTitle + "\"");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(int publication_date) {
        this.publication_date = publication_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", publication_date=" + publication_date +
                ", cover='" + cover + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
