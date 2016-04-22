/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repositories;

import com.ivc.libraryweb.entities.Page;
import java.util.List;

/**
 *
 * @author Sokolov@ivc.org
 */
public interface PageRepository {

    List<Page> findAll();

    Page find(Page page);

    Page findWithDetail(Page page);

    Page create(Page page);

    Page update(Page page);

    void delete(Page page);

}
