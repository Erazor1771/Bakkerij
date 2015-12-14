/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lars
 */
public class CategoriesTest {
    
    public CategoriesTest() {
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
     * Test of makeCategory method, of class Categories.
     */
    @Test
    public void testMakeCategory() {
        
        System.out.println("makeCategory");
        String name = "Test";
        Categories instance = new Categories();
        boolean expResult = true;
        boolean result = instance.makeCategory(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteCategory method, of class Categories.
     */
    @Test
    public void testDeleteCategory() {
        System.out.println("deleteCategory");
        Category cat = new Category("Broodjes");
        String validation = "Broodjes";
        Categories instance = new Categories();
        instance.makeCategory(validation);
        boolean expResult = true;
        boolean result = instance.deleteCategory(cat, validation);
        assertEquals(expResult, result);
    }
    
}
