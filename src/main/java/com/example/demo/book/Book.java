package com.example.demo.book;

public class Book {

    private long id;
    private String title;
    private Integer price;

    public Book(long id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Book(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
