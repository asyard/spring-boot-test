package com.asy.test.springboot.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by asy
 */
@Entity
public class Book {

    @Id
    @NotNull
    @Size(max = 20)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @NotNull
    @Size(max = 500)
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotNull
    @Size(max = 300)
    @Column(name = "author", nullable = false)
    private String author;

    @NotNull
    @Column(name = "year", nullable = false)
    private Integer year;

    Book() {
    }

    public Book(final String id, final String name, final String author, final Integer year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer().append("id : ").append(id)
                .append(" name : " + name).append(" author : " + author)
                .append(" year : " + year);
        return sb.toString();
    }
}
