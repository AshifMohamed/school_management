/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.event_management;

import java.sql.ResultSet;
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
public class EventTest {
    
    public EventTest() {
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

//    /**
//     * Test of tableloadUpcoming method, of class Event.
//     */
//    @Test
//    public void testTableloadUpcoming() {
//        System.out.println("tableloadUpcoming");
//        Event instance = new Event();
//        ResultSet expResult = null;
//        ResultSet result = instance.tableloadUpcoming();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of tableloadAll method, of class Event.
//     */
//    @Test
//    public void testTableloadAll() {
//        System.out.println("tableloadAll");
//        Event instance = new Event();
//        ResultSet expResult = null;
//        ResultSet result = instance.tableloadAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validate method, of class Event.
//     */
//    @Test
//    public void testValidate() {
//        System.out.println("validate");
//        Event instance = new Event();
//        boolean expResult = false;
//        boolean result = instance.validate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchByID method, of class Event.
//     */
//    @Test
//    public void testSearchByID() {
//        System.out.println("searchByID");
//        String pID = "";
//        Event instance = new Event();
//        ResultSet expResult = null;
//        ResultSet result = instance.searchByID(pID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchByName method, of class Event.
//     */
//    @Test
//    public void testSearchByName() {
//        System.out.println("searchByName");
//        String pName = "";
//        Event instance = new Event();
//        ResultSet expResult = null;
//        ResultSet result = instance.searchByName(pName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchByDate method, of class Event.
//     */
//    @Test
//    public void testSearchByDate() {
//        System.out.println("searchByDate");
//        String pDate = "";
//        Event instance = new Event();
//        ResultSet expResult = null;
//        ResultSet result = instance.searchByDate(pDate);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchThis method, of class Event.
//     */
//    @Test
//    public void testSearchThis() {
//        System.out.println("searchThis");
//        String pstartDate = "";
//        String pStartTime = "";
//        String pVenue = "";
//        Event instance = new Event();
//        ResultSet expResult = null;
//        ResultSet result = instance.searchThis(pstartDate, pStartTime, pVenue);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of InsertThis method, of class Event.
//     */
//    @Test
//    public void testInsertThis() {
//        System.out.println("InsertThis");
//        Event instance = new Event();
//        boolean expResult = false;
//        boolean result = instance.InsertThis();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of updateSpecific method, of class Event.
     */
    @Test
    public void testUpdateSpecific() {
        System.out.println("updateSpecific");
        String pname = "sfsf";
        String pdescription = "Updated";
        String pvenue = "updated"; 
        String porganizer = "updated";
        String pstartDate = "2017-12-12";
        String pstartTime = "18:00";
        String pendDate = "2017-12-12";
        String pendTime = "22:00";
        Event instance = new Event(pname, pdescription, pvenue, porganizer, pstartDate, pstartTime, pendDate, pendTime);
        boolean expResult = true;
        boolean result = instance.updateSpecific(pname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of getName method, of class Event.
//     */
//    @Test
//    public void testGetName() {
//        System.out.println("getName");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setName method, of class Event.
//     */
//    @Test
//    public void testSetName() {
//        System.out.println("setName");
//        String name = "";
//        Event instance = new Event();
//        instance.setName(name);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDescription method, of class Event.
//     */
//    @Test
//    public void testGetDescription() {
//        System.out.println("getDescription");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getDescription();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDescription method, of class Event.
//     */
//    @Test
//    public void testSetDescription() {
//        System.out.println("setDescription");
//        String description = "";
//        Event instance = new Event();
//        instance.setDescription(description);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getVenue method, of class Event.
//     */
//    @Test
//    public void testGetVenue() {
//        System.out.println("getVenue");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getVenue();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setVenue method, of class Event.
//     */
//    @Test
//    public void testSetVenue() {
//        System.out.println("setVenue");
//        String venue = "";
//        Event instance = new Event();
//        instance.setVenue(venue);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOrganizer method, of class Event.
//     */
//    @Test
//    public void testGetOrganizer() {
//        System.out.println("getOrganizer");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getOrganizer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setOrganizer method, of class Event.
//     */
//    @Test
//    public void testSetOrganizer() {
//        System.out.println("setOrganizer");
//        String organizer = "";
//        Event instance = new Event();
//        instance.setOrganizer(organizer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getStartDate method, of class Event.
//     */
//    @Test
//    public void testGetStartDate() {
//        System.out.println("getStartDate");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getStartDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStartDate method, of class Event.
//     */
//    @Test
//    public void testSetStartDate() {
//        System.out.println("setStartDate");
//        String startDate = "";
//        Event instance = new Event();
//        instance.setStartDate(startDate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getStartTime method, of class Event.
//     */
//    @Test
//    public void testGetStartTime() {
//        System.out.println("getStartTime");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getStartTime();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStartTime method, of class Event.
//     */
//    @Test
//    public void testSetStartTime() {
//        System.out.println("setStartTime");
//        String startTime = "";
//        Event instance = new Event();
//        instance.setStartTime(startTime);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEndDate method, of class Event.
//     */
//    @Test
//    public void testGetEndDate() {
//        System.out.println("getEndDate");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getEndDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEndDate method, of class Event.
//     */
//    @Test
//    public void testSetEndDate() {
//        System.out.println("setEndDate");
//        String endDate = "";
//        Event instance = new Event();
//        instance.setEndDate(endDate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEndTime method, of class Event.
//     */
//    @Test
//    public void testGetEndTime() {
//        System.out.println("getEndTime");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getEndTime();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEndTime method, of class Event.
//     */
//    @Test
//    public void testSetEndTime() {
//        System.out.println("setEndTime");
//        String endTime = "";
//        Event instance = new Event();
//        instance.setEndTime(endTime);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEventID method, of class Event.
//     */
//    @Test
//    public void testGetEventID() {
//        System.out.println("getEventID");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getEventID();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEventID method, of class Event.
//     */
//    @Test
//    public void testSetEventID() {
//        System.out.println("setEventID");
//        String eventID = "";
//        Event instance = new Event();
//        instance.setEventID(eventID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
