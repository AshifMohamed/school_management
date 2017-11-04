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
 * @author AIA Insurance
 */
public class staffModelTest {
    
    public staffModelTest() {
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
     * Test of getStaffId method, of class staffModel.
     */
    @Test
    public void testGetStaffId() {
        System.out.println("getStaffId");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getStaffId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNIC method, of class staffModel.
     */
    @Test
    public void testGetNIC() {
        System.out.println("getNIC");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getNIC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNIC method, of class staffModel.
     */
    @Test
    public void testSetNIC() {
        System.out.println("setNIC");
        String NIC = "";
        staffModel instance = new staffModel();
        instance.setNIC(NIC);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaffId method, of class staffModel.
     */
    @Test
    public void testSetStaffId() {
        System.out.println("setStaffId");
        String staffId = "";
        staffModel instance = new staffModel();
        instance.setStaffId(staffId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class staffModel.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class staffModel.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        staffModel instance = new staffModel();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class staffModel.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class staffModel.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        staffModel instance = new staffModel();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class staffModel.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGender method, of class staffModel.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "";
        staffModel instance = new staffModel();
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfBirth method, of class staffModel.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
        staffModel instance = new staffModel();
        Date expResult = null;
        Date result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfBirth method, of class staffModel.
     */
    @Test
    public void testSetDateOfBirth() {
        System.out.println("setDateOfBirth");
        Date dateOfBirth = null;
        staffModel instance = new staffModel();
        instance.setDateOfBirth(dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReligion method, of class staffModel.
     */
    @Test
    public void testGetReligion() {
        System.out.println("getReligion");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getReligion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReligion method, of class staffModel.
     */
    @Test
    public void testSetReligion() {
        System.out.println("setReligion");
        String religion = "";
        staffModel instance = new staffModel();
        instance.setReligion(religion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMartialStatus method, of class staffModel.
     */
    @Test
    public void testGetMartialStatus() {
        System.out.println("getMartialStatus");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getMartialStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMartialStatus method, of class staffModel.
     */
    @Test
    public void testSetMartialStatus() {
        System.out.println("setMartialStatus");
        String martialStatus = "";
        staffModel instance = new staffModel();
        instance.setMartialStatus(martialStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class staffModel.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class staffModel.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        staffModel instance = new staffModel();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMobile method, of class staffModel.
     */
    @Test
    public void testGetMobile() {
        System.out.println("getMobile");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getMobile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMobile method, of class staffModel.
     */
    @Test
    public void testSetMobile() {
        System.out.println("setMobile");
        String mobile = "";
        staffModel instance = new staffModel();
        instance.setMobile(mobile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class staffModel.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class staffModel.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        staffModel instance = new staffModel();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentAddress method, of class staffModel.
     */
    @Test
    public void testGetCurrentAddress() {
        System.out.println("getCurrentAddress");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getCurrentAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentAddress method, of class staffModel.
     */
    @Test
    public void testSetCurrentAddress() {
        System.out.println("setCurrentAddress");
        String currentAddress = "";
        staffModel instance = new staffModel();
        instance.setCurrentAddress(currentAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPermanantAddress method, of class staffModel.
     */
    @Test
    public void testGetPermanantAddress() {
        System.out.println("getPermanantAddress");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getPermanantAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPermanantAddress method, of class staffModel.
     */
    @Test
    public void testSetPermanantAddress() {
        System.out.println("setPermanantAddress");
        String permanantAddress = "";
        staffModel instance = new staffModel();
        instance.setPermanantAddress(permanantAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEducationalQual method, of class staffModel.
     */
    @Test
    public void testGetEducationalQual() {
        System.out.println("getEducationalQual");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getEducationalQual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEducationalQual method, of class staffModel.
     */
    @Test
    public void testSetEducationalQual() {
        System.out.println("setEducationalQual");
        String educationalQual = "";
        staffModel instance = new staffModel();
        instance.setEducationalQual(educationalQual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfessionalQual method, of class staffModel.
     */
    @Test
    public void testGetProfessionalQual() {
        System.out.println("getProfessionalQual");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getProfessionalQual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfessionalQual method, of class staffModel.
     */
    @Test
    public void testSetProfessionalQual() {
        System.out.println("setProfessionalQual");
        String professionalQual = "";
        staffModel instance = new staffModel();
        instance.setProfessionalQual(professionalQual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJoinedDate method, of class staffModel.
     */
    @Test
    public void testGetJoinedDate() {
        System.out.println("getJoinedDate");
        staffModel instance = new staffModel();
        Date expResult = null;
        Date result = instance.getJoinedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJoinedDate method, of class staffModel.
     */
    @Test
    public void testSetJoinedDate() {
        System.out.println("setJoinedDate");
        Date joinedDate = null;
        staffModel instance = new staffModel();
        instance.setJoinedDate(joinedDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class staffModel.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        staffModel instance = new staffModel();
        double expResult = 0.0;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class staffModel.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 0.0;
        staffModel instance = new staffModel();
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBank method, of class staffModel.
     */
    @Test
    public void testGetBank() {
        System.out.println("getBank");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getBank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBank method, of class staffModel.
     */
    @Test
    public void testSetBank() {
        System.out.println("setBank");
        String bank = "";
        staffModel instance = new staffModel();
        instance.setBank(bank);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccntNo method, of class staffModel.
     */
    @Test
    public void testGetAccntNo() {
        System.out.println("getAccntNo");
        staffModel instance = new staffModel();
        String expResult = "";
        String result = instance.getAccntNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccntNo method, of class staffModel.
     */
    @Test
    public void testSetAccntNo() {
        System.out.println("setAccntNo");
        String accntNo = "";
        staffModel instance = new staffModel();
        instance.setAccntNo(accntNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStaff method, of class staffModel.
     */
    @Test
    public void testAddStaff() {
        System.out.println("addStaff");
        staffModel instance = new staffModel();
        boolean expResult = false;
        boolean result = instance.addStaff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStaff method, of class staffModel.
     */
    @Test
    public void testUpdateStaff() {
        System.out.println("updateStaff");
        staffModel instance = new staffModel();
        boolean expResult = false;
        boolean result = instance.updateStaff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStaff method, of class staffModel.
     */
    @Test
    public void testDeleteStaff() {
        System.out.println("deleteStaff");
        staffModel instance = new staffModel();
        boolean expResult = false;
        boolean result = instance.deleteStaff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchStaffById method, of class staffModel.
     */
    @Test
    public void testSearchStaffById() {
        System.out.println("searchStaffById");
        int staffId = 0;
        staffModel instance = new staffModel();
        ResultSet expResult = null;
        ResultSet result = instance.searchStaffById(staffId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchStaffByFname method, of class staffModel.
     */
    @Test
    public void testSearchStaffByFname() {
        System.out.println("searchStaffByFname");
        String staffName = "";
        staffModel instance = new staffModel();
        ResultSet expResult = null;
        ResultSet result = instance.searchStaffByFname(staffName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectStaff method, of class staffModel.
     */
    @Test
    public void testSelectStaff() {
        System.out.println("selectStaff");
        int staffId = 0;
        staffModel instance = new staffModel();
        ResultSet expResult = null;
        ResultSet result = instance.selectStaff(staffId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
