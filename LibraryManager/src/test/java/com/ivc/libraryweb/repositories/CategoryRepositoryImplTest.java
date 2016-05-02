/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repositories;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vita
 */
public class CategoryRepositoryImplTest {
    
    public CategoryRepositoryImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class CategoryRepositoryImpl.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        com.ivc.libraryweb.entities.Category category = null;
        CategoryRepositoryImpl instance = new CategoryRepositoryImpl();
        com.ivc.libraryweb.entities.Category expResult = null;
        com.ivc.libraryweb.entities.Category result = instance.create(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CategoryRepositoryImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        com.ivc.libraryweb.entities.Category category = null;
        CategoryRepositoryImpl instance = new CategoryRepositoryImpl();
        instance.delete(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CategoryRepositoryImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        com.ivc.libraryweb.entities.Category category = null;
        CategoryRepositoryImpl instance = new CategoryRepositoryImpl();
        com.ivc.libraryweb.entities.Category expResult = null;
        com.ivc.libraryweb.entities.Category result = instance.update(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class CategoryRepositoryImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CategoryRepositoryImpl instance = new CategoryRepositoryImpl();
        List<com.ivc.libraryweb.entities.Category> expResult = null;
        List<com.ivc.libraryweb.entities.Category> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class CategoryRepositoryImpl.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        com.ivc.libraryweb.entities.Category category = null;
        CategoryRepositoryImpl instance = new CategoryRepositoryImpl();
        com.ivc.libraryweb.entities.Category expResult = null;
        com.ivc.libraryweb.entities.Category result = instance.find(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findWithDetail method, of class CategoryRepositoryImpl.
     */
    @Test
    public void testFindWithDetail() {
        System.out.println("findWithDetail");
        com.ivc.libraryweb.entities.Category category = null;
        CategoryRepositoryImpl instance = new CategoryRepositoryImpl();
        com.ivc.libraryweb.entities.Category expResult = null;
        com.ivc.libraryweb.entities.Category result = instance.findWithDetail(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
