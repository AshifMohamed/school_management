/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.staff_management;

import java.sql.ResultSet;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ApplyLeaveModelTest {
    
    public ApplyLeaveModelTest() {
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
     * Test of getNamefromStaffId method, of class ApplyLeaveModel.
     */
    @Test
    public void testGetNamefromStaffId() {
        System.out.println("getNamefromStaffId");
        ApplyLeaveModel instance = new ApplyLeaveModel();
        String expResult = "Kumar";
        String result = instance.getNamefromStaffId(5);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
