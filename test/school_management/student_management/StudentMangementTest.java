package school_management.student_management;


/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neruppuda
 */
public class StudentMangementTest {
    
    StudentManagementDBUtils studentManagementDBUtils = new StudentManagementDBUtils();
    StudentManagementValidation studentManagementValidation = new StudentManagementValidation();
    public StudentMangementTest() {
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

    @Test
    public void checkPaymentObjectEqual(){
        float value=15000f;
        float valueQuery=studentManagementDBUtils.getAmountForTerm("ST_00001");
        System.out.println(valueQuery);
        assertEquals(value , valueQuery,0.0002);
        
    }
   
    @Test
    public void checkIsNumericValue(){
        String testValue="1000000";
        assertTrue(studentManagementValidation.isNumeric(testValue));
    }
    
    @Test
    public void checkValidationStudentId(){
        boolean result = true;
        assertTrue(studentManagementValidation.validateStudentId("ST_00001"));
    }
    
    public void checkValidatioContactNumber(){
        boolean result = true;
        assertTrue(studentManagementValidation.validateContactNumber("0778236146"));
    }
    
    
}
