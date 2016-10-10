package com.asy.test.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asy.test.springboot.bean.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by asy
 */
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("select b from Book b where b.name = ?1")
    List<Book> listByName(String name);
}
