package com.asy.test.springboot.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.asy.test.springboot.bean.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.asy.test.springboot.repository.BookRepository;

/**
 * Created by asy
 */
@Service
@Validated
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(final BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Book save(@NotNull @Valid final Book book) {
        logger.debug("Creating {}", book);
        return repository.save(book);
    }

  
    @Transactional(readOnly = true)
    public List<Book> getList() {
        logger.debug("Retrieving all books");
        return repository.findAll();
    }

    @Override
    public Book get(String id) {
        logger.debug("Retrieving book : " + id);
        Book book = repository.findOne(id);
        return book;
    }

    @Override
    public List<Book> getByName(String name) {
        logger.debug("Searching book with name : " + name);
        List<Book> books = repository.listByName(name);
        return books;
    }

}
