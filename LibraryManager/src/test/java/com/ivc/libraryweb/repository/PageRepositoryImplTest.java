/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repository;

import com.ivc.libraryweb.config.JPAConfig;
import com.ivc.libraryweb.entities.Document;
import com.ivc.libraryweb.entities.Page;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Администратор
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PageRepositoryImplTest {
    
    @Configuration
    @Import({JPAConfig.class,PageRepositoryImpl.class})
    public static class PageRepositoryTestConfig{
    }
    
    private static final String VALID_NAME="name";
    private static final Document DOCUMNT_ID = new Document() ;
    Page validPage = new Page();
    
    @Autowired
    PageRepository pageRepository;
            
    public PageRepositoryImplTest() {
    }
    
 
    @Before
    public void setUp() {
        validPage.setName(VALID_NAME);
        validPage.setDocument(DOCUMNT_ID);
    }
    
    /**
     * Test of save method, of class PageRepositoryImpl.
     */
    @Ignore
    @Test
    public void testSavePage() {
        pageRepository.save(validPage);
    }
    @Ignore
    @Test
    public void testFindAllPage(){
       List<Page> l = pageRepository.findAll();
       assertTrue(l.size()>0);
    }
    
    @Ignore
    @Test
    public void testFindPage(){
        List<Page> l = pageRepository.find(validPage);
        assertTrue(l.size()>0);
    }
}
