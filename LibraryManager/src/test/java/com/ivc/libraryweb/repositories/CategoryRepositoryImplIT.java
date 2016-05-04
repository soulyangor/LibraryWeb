/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repositories;

import com.ivc.libraryweb.entities.Book;
import com.ivc.libraryweb.entities.Category;
import com.ivc.libraryweb.integration.config.DataSets;
import com.ivc.libraryweb.integration.config.TestConfig;
import com.ivc.libraryweb.integration.config.RepositoryTestExecutionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.assertj.core.api.AssertionsForClassTypes.extractProperty;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
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
@ContextConfiguration(classes = {TestConfig.class})
@TestExecutionListeners({RepositoryTestExecutionListener.class})
@WebAppConfiguration
public class CategoryRepositoryImplIT extends AbstractTransactionalJUnit4SpringContextTests {
    
    private static final String[] CATEGORY_NAME = new String[]{"8A82KM","14A14","11A11"};
    private static final String[] ALL_CATEGORY_NAME = new String[]{"8A82KM","14A14"};
    private static final String[] BOOK_LIST = new String[]{"myBook1","myBook2"};
    
   @Autowired
   CategoryRepository  categoryRepository;
   
    @PersistenceContext
    private EntityManager em;
   
  
    private Category validCategory ;
    private Category deleteCategory;
    private Category newCategory =new Category("11A11");
    private String bookName = "myBook";
    private Book newBook = new Book("newBook", "1", "1", "1", "", "1s");
    
    @Before
    public void before() {
        List<Category> l = em.createNamedQuery("Category.findAll", Category.class).getResultList();
        deleteCategory = l.get(0);
        validCategory = l.get(1);
    }
    
    @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testCreateCategory(){
         categoryRepository.create(newCategory);
         List<Category> l = em.createNamedQuery("Category.findAll",Category.class).getResultList();
           assertThat(extractProperty(Category.NAME_PROPERTY).from(l))
                .hasSize(CATEGORY_NAME.length)
                .containsOnly((Object[]) CATEGORY_NAME);
    }
    
    
   @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testDelete(){
       categoryRepository.delete(deleteCategory);
        List<Category> l = em.createNamedQuery("Category.findAll",Category.class).getResultList();
        assertTrue((l.size()==1)&&l.get(0).equals(validCategory));
    }
    
    
    @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testFindALL(){
        List<Category> findList = categoryRepository.findAll();
        assertThat(extractProperty(Category.NAME_PROPERTY).from(findList))
                .hasSize(ALL_CATEGORY_NAME.length)
                .containsOnly((Object[]) ALL_CATEGORY_NAME);
    }
    
    
    @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testFind(){
        Category category = categoryRepository.find(validCategory);
        assertEquals(validCategory,category);
    }
    
    @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testFindWithDetail(){
        Category category = categoryRepository.findWithDetail(validCategory);
        assertEquals(validCategory,category);
        assertThat(extractProperty(Book.NAME_PROPERTY).from(category.getBooks()))
                .hasSize(BOOK_LIST.length)
                .containsOnly((Object[]) BOOK_LIST);
    }
    
    @DataSets(setUpDataSet= "data-category.sql")
    @Test
    public void testUpdate(){
        validCategory.setName("newName");
        newBook.setCategory(validCategory);
        em.persist(newBook);
        Set<Book> s = new HashSet<Book>();
        s.add(newBook);
        validCategory.getBooks().clear();
        validCategory.setBooks(s);
        categoryRepository.update(validCategory);
        Category c = em.createNamedQuery("Category.findWithDetail",Category.class).setParameter("id", validCategory.getId()).getSingleResult();
        assertEquals(validCategory,c);
        assertTrue(c.getBooks().size()==1&&c.getBooks().contains(newBook));
    }
    
}
