package com.bookstore.entities;

import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class OwnedBook {

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

    @Column(name = "avaliability")
    private int avaliability;

    @Column(name = "pages")
    private int pages;

    @Column(name = "publication_date")
    private int publication_date;

    @Column(name = "cover")
    private String cover;

    public OwnedBook() {}

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

    public int getAvaliability() {
        return avaliability;
    }

    public void setAvaliability(int avaliability) {
        this.avaliability = avaliability;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "OwnedBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", avaliability=" + avaliability +
                ", pages=" + pages +
                ", publication_date=" + publication_date +
                ", cover='" + cover + '\'' +
                '}';
    }
}
