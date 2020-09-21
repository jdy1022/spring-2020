package com.jdy.spring2020.bean;

public class Book {

    private String isbn;
    private String book_name;

    private Integer price;

    public Book(String isbn, String book_name, Integer price) {
        this.isbn = isbn;
        this.book_name = book_name;
        this.price = price;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("isbn='").append(isbn).append('\'');
        sb.append(", book_name='").append(book_name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
