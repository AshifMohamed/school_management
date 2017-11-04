/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.staff_management;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author AIA Insurance
 */
public class ValidateStaffTest {
    
    public ValidateStaffTest() {
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
     * Test of checkPhoneLength method, of class ValidateStaff.
     */
    @Test
    public void testCheckPhoneLength() {
        System.out.println("checkPhoneLength");
        String phone = "0778582995";
        ValidateStaff instance = new ValidateStaff();
        boolean expResult = true;
        boolean result = instance.checkPhoneLength(phone);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkNICLength method, of class ValidateStaff.
     */
    @Test
    public void testCheckNICLength() {
        System.out.println("CheckNICLength");
        String nic = "952170279V";
        ValidateStaff instance = new ValidateStaff();
        boolean expResult = true;
        boolean result = instance.checkNICLength(nic);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkNICCharacter method, of class ValidateStaff.
     */
    @Test
    public void testCheckNICCharacter() {
        System.out.println("checkNICCharacter");
        String nic = "952170279V";
        ValidateStaff instance = new ValidateStaff();
        boolean expResult = true;
        boolean result = instance.checkNICCharacter(nic);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validateMail method, of class ValidateStaff.
     */
    @Test
    public void testValidateMail() {
        System.out.println("validateMail");
        String mail = "ashifm";
        ValidateStaff instance = new ValidateStaff();
        boolean expResult = false;
        boolean result = instance.validateMail(mail);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validateDob method, of class ValidateStaff.
     */
    @Ignore
    public void testValidateDob() {
        System.out.println("validateDob");
        Date dob = null;
        ValidateStaff instance = new ValidateStaff();
        boolean expResult = false;
        boolean result = instance.validateDob(dob);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidleaveStartDate method, of class ValidateStaff.
     */
    @Ignore
    public void testIsValidleaveStartDate() {
        System.out.println("isValidleaveStartDate");
        Date leaveStartDate = null;
        ValidateStaff instance = new ValidateStaff();
        boolean expResult = false;
        boolean result = instance.isValidleaveStartDate(leaveStartDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidleaveEndDate method, of class ValidateStaff.
     */
    @Ignore
    public void testIsValidleaveEndDate() {
        System.out.println("isValidleaveEndDate");
        Date leaveStartDate = null;
        Date leaveEndDate = null;
        ValidateStaff instance = new ValidateStaff();
        boolean expResult = false;
        boolean result = instance.isValidleaveEndDate(leaveStartDate, leaveEndDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
