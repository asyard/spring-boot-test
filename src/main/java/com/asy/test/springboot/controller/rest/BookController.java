package com.asy.test.springboot.controller.rest;

import com.asy.test.springboot.bean.Book;
import com.asy.test.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by asy
 */
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> listBooks() {
        List<Book> books = bookService.getList();
        return books;
    }
    @RequestMapping(value="/addbook",method = {RequestMethod.GET, RequestMethod.POST} )
    public void addBook(
    		@RequestParam(value = "id", required = false) String bookId,
            @RequestParam(value = "name", required = true) String bookName,
    		@RequestParam(value = "author", required = true) String bookAuthor,
    		@RequestParam(value = "year", required = true) int bookYear){
        Book book = new Book(bookId, bookName, bookAuthor, bookYear);
        bookService.save(book);
    }

    @RequestMapping("/book")
    public ResponseEntity<?>  bookByParam(@RequestParam(value = "bookId", required = true) String bookId) {
        return findEntityById(bookId);
    }


  /*  @RequestMapping(value = "/book/{bookId}", produces = "application/json")
    @ResponseBody
    public Book book(@PathVariable String bookId) {
        Book book = bookService.get(bookId);
        return book;
    }   */

    @RequestMapping(value = "/book/{bookId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> book(@PathVariable String bookId) {
        return findEntityById(bookId);
    }

    @RequestMapping(value = "/bookbyname", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<?> bookbyname(@RequestParam(value = "bookName") String bookName) {
        return findEntityByName(bookName);
    }

    private ResponseEntity<?> findEntityById(String id) {
        Book book = bookService.get(id);
        if (book == null) {
            return new ResponseEntity("Book (" + id + ") not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(book, HttpStatus.OK);
    }

    private ResponseEntity<?> findEntityByName(String name) {
        List<Book> byName = bookService.getByName(name);
        if (byName == null || byName.isEmpty()) {
            return new ResponseEntity("Book (name:"  + name + ") not found", HttpStatus.NOT_FOUND);
        }
       //return new ResponseEntity(book, HttpStatus.OK);
        return new ResponseEntity<Object>(byName, HttpStatus.OK);
    }

}
