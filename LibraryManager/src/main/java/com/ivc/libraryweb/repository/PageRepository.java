/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repository;

import com.ivc.libraryweb.model.Page;
import java.util.List;

/**
 *
 * @author Администратор
 */
public interface PageRepository {
   Page save(Page page);
   Page delete(Page page);
   Page update(Page page);
   List<Page> find(Page page);
   List<Page> findAll();
}
