/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.library_management;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Umani Welisara
 */
public class BookModelTest {
    
    public BookModelTest() {
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
     * Test of insertBook method, of class BookModel.
     */
   
    /**
     * Test of deleteBook method, of class BookModel.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        BookModel instance = new BookModel("26");
        boolean expResult = false;
        boolean result = instance.deleteBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of updateBook method, of class BookModel.
     */
   
}
