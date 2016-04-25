/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.controllers;

import static com.ivc.libraryweb.controllers.BookTypeRestController.BOOK_TYPES_PATH;
import com.ivc.libraryweb.entities.BookType;
import com.ivc.libraryweb.repositories.BookTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sokolov@ivc.org
 */
@RestController
@RequestMapping(path = BOOK_TYPES_PATH,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class BookTypeRestController {
    //-------------------Logger---------------------------------------------------

    //-------------------Constants------------------------------------------------
    public static final String BOOK_TYPES_PATH = "/book_types";
    public static final String ITEM_PATH = "/item";

    //-------------------Fields---------------------------------------------------
    private BookTypeRepository bookTypeRepository;

    //-------------------Constructors---------------------------------------------
    //-------------------Getters and setters--------------------------------------
    @Autowired(required = false)
    public void setBookTypeRepository(BookTypeRepository bookTypeRepository) {
        this.bookTypeRepository = bookTypeRepository;
    }

    //-------------------Methods--------------------------------------------------
    @RequestMapping(method = RequestMethod.GET)
    public List<BookType> getBookTypeList() {
        return bookTypeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookType createBookType(@RequestBody BookType bookType) {
        return bookTypeRepository.create(bookType);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookType updateBookType(@RequestBody BookType bookType) {
        return bookTypeRepository.update(bookType);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBookType(@RequestBody BookType bookType) {
        bookTypeRepository.delete(bookType);
    }

}
