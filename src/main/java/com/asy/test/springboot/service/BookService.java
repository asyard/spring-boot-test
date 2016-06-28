package com.asy.test.springboot.service;

import java.util.List;

import com.asy.test.springboot.bean.Book;

/**
 * Created by asy
 */
public interface BookService {

    Book save(Book book);

    List<Book> getList();

    Book get(String id);

}
