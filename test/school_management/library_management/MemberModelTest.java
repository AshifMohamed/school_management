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
public class MemberModelTest {
    
    public MemberModelTest() {
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
     * Test of updateMember method, of class MemberModel.
     */
    @Test
    public void testUpdateMember() {
        System.out.println("updateMember");
        String mregID="3";
        String mname="dinuli";
        String mgrade="8";
        String memail="dinuli@gmail.com";
        String mcontactnum="0987776665";
        String mstatus="Enable";       
        MemberModel instance = new MemberModel(mregID,mname, mgrade, memail, mcontactnum, mstatus);
        boolean expResult = true;
        boolean result = instance.updateMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMregID method, of class MemberModel.
     */
   
    

    
}
