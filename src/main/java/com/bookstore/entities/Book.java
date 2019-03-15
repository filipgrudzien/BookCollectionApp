package com.bookstore.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private float price;

    @Column(name = "pages")
    private int pages;

    @Column(name = "publication_date")
    private int publication_date;

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
        return title;
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
