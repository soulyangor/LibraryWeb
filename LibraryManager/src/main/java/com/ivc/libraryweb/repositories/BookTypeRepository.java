/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repositories;

import com.ivc.libraryweb.entities.BookType;
import java.util.List;

/**
 *
 * @author Sokolov@ivc.org
 */
public interface BookTypeRepository {

    List<BookType> findAll();

    BookType find(BookType bookType);

    BookType findWithDetail(BookType bookType);

    BookType create(BookType bookType);

    BookType update(BookType bookType);

    void delete(BookType bookType);

}
