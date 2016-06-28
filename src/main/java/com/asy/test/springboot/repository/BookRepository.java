package com.asy.test.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asy.test.springboot.bean.Book;

/**
 * Created by asy
 */
public interface BookRepository extends JpaRepository<Book, String> {
}
