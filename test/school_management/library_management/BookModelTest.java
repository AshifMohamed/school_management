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
 * @author wickr
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
//    @Test
//    public void testInsertBook() {
//        System.out.println("insertBook");
//        BookModel instance = null;
//        boolean expResult = false;
//        boolean result = instance.insertBook();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteBook method, of class BookModel.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        BookModel instance = new BookModel("7");
        boolean expResult = true;
        boolean result = instance.deleteBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateBook method, of class BookModel.
     */
    @Test
    public void testUpdateBook() {
        System.out.println("updateBook");
       String bid="5"; 
        String bname = "heart";
        String bauther = "Alina don";
        String bcategory = "Science";
        String bqty = "3";
        BookModel instance = new BookModel(bid,bname, bauther, bcategory, bqty);
        boolean expResult = true;
        boolean result = instance.updateBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertBook method, of class BookModel.
     */
   
  
}
