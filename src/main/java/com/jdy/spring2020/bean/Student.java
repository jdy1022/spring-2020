package com.jdy.spring2020.bean;

import java.util.List;
import java.util.Map;

public class Student {

    private String studentId;

    private String name;

    private String age;

    private Book book;

    private List<String> phoneNos;

    private List<Book> books;

    private Map<String,Object> bookMaps;

    private Map<String,Object> remarks;

    public Student(String studentId, String name, String age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public List<String> getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(List<String> phoneNos) {
        this.phoneNos = phoneNos;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Student() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Map<String, Object> getBookMaps() {
        return bookMaps;
    }

    public void setBookMaps(Map<String, Object> bookMaps) {
        this.bookMaps = bookMaps;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Map<String, Object> getRemarks() {
        return remarks;
    }

    public void setRemarks(Map<String, Object> remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("studentId='").append(studentId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append(", book=").append(book);
        sb.append(", phoneNos=").append(phoneNos);
        sb.append(", books=").append(books);
        sb.append(", bookMaps=").append(bookMaps);
        sb.append(", remarks=").append(remarks);
        sb.append('}');
        return sb.toString();
    }
}
