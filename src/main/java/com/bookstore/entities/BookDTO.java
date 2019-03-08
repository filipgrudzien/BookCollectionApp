package com.bookstore.entities;

// to show limited data in books views

public class BookDTO {

    private String title;

    private String author;

    private float price;

    private int avaliability;

    public BookDTO() {}

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

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", avaliability=" + avaliability +
                '}';
    }
}
