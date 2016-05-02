/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repositories;

import com.ivc.libraryweb.entities.Category;
import com.ivc.libraryweb.integration.config.DataSets;
import com.ivc.libraryweb.integration.config.ServiceTestConfig;
import com.ivc.libraryweb.integration.config.ServiceTestExecutionListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author VitaliyDenisov@ivc.org
 */
@Configuration
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
@WebAppConfiguration
public class CategoryRepositoryImplIT extends AbstractTransactionalJUnit4SpringContextTests {
    
   @Autowired
   CategoryRepository  categoryRepository;
   
    @PersistenceContext
    private EntityManager em;
   
   private Category  validCategory = new Category("11A11");
   
    @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testCreateCategory(){
       List<Category> l = em.createNamedQuery("Category.findAll",Category.class).getResultList();
         categoryRepository.create(validCategory);
    }
    
    
   @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testCreateDelete(){
       List<Category> l = em.createNamedQuery("Category.findAll",Category.class).getResultList();
     //    categoryRepository.delete(validCategory);
    }
    
    
    
    
}
