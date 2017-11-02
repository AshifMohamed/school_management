/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.event_management;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import school_management.DBConn;

/**
 *
 * @author wickr
 */
public class Event {
    
    private String name;
    private String description;
    private String venue;
    private String organizer;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    
    
    public Event(){
    
    }
    
    public Event(String pname, String pdescription, String pvenue, String porganizer, String pstartDate, String pstartTime, String pendDate, String pendTime){
        this.name = pname;
        this.description = pdescription;
        this.venue = pvenue;
        this.organizer = porganizer;
        this.startDate = pstartDate;
        this.startTime = pstartTime;
        this.endDate = pendDate;
        this.endTime = pendTime;
    }
    
    
    public static ResultSet tableload_upcoming() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String cdate = dateFormat.format(date);
            Calendar c = Calendar.getInstance();
            c.setTime(new Date()); // Now use today date.
            c.add(Calendar.DATE, 5); // Adding 5 days
            String cdateadd = dateFormat.format(c.getTime());
            String sql = "select event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', start_time as 'Starting on', end_time as 'Ending on' from event_details where start_date between '" + cdate + "' and '"+cdateadd+"'";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static ResultSet tableload_all(){
        try {
            String sql = "select event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', start_time as 'Starting on', end_time as 'Ending on' from event_details";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean validate() {
        if (this.getName().isEmpty() || this.getDescription().isEmpty() || this.getVenue().isEmpty() || this.getOrganizer().isEmpty() || this.getStartDate().isEmpty()
                || this.getStartTime().isEmpty() || this.getEndDate().isEmpty() || this.getEndTime().isEmpty()) {
            return false;
        }
        return true;
    }
    
    public boolean InsertThis() {
        boolean result = false;
        if (this.validate()) {
            try {
                Connection c = DBConn.myConn();
                String query;
                query = "insert into event_details (event_name, event_description, event_venue, event_organizer, start_date, start_time, end_date, end_time) "
                        + "values (?,?,?,?,?,?,?,?)";

                PreparedStatement statement = c.prepareStatement(query);
                statement.setString(1, this.getName());
                statement.setString(2, this.getDescription());
                statement.setString(3, this.getVenue());
                statement.setString(4, this.getOrganizer());
                statement.setString(5, this.getStartDate());
                statement.setString(6, this.getStartTime());
                statement.setString(7, this.getEndDate());
                statement.setString(8, this.getEndTime());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    //JOptionPane.showMessageDialog(null, "Event Scheduled");
                    result = true;
                }
            } catch (SQLException | HeadlessException e) {
                //JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else 
            return result;
        return result;
    }
    
//    public static ResultSet searchThis(){
//    
//    }
//    
//    public void InsertThis() {
//        if (this.validate()) {
//            try {
//                Connection c = DB.mycon();
//                String query;
//                query = "insert into movies (DISK_ID, TITLE, COMPOSER, DIRECTOR, CATEGORY, DURATION, NEW_RELEASE, DESCRIPTION, PRICE) values (?,?,?,?,?,?,?,?,?)";
//
//                PreparedStatement statement = c.prepareStatement(query);
//                statement.setString(1, this.getAdid());
//                statement.setString(2, this.getAtitle());
//                statement.setString(3, this.getAcomposer());
//                statement.setString(4, this.getAdirector());
//                statement.setString(5, this.getAcategory());
//                statement.setString(6, this.getAduration());
//                statement.setString(7, this.getAnewRelease());
//                statement.setString(8, this.getAdescription());
//                statement.setString(9, this.getAprice());
//
//                int rowsInserted = statement.executeUpdate();
//                if (rowsInserted > 0) {
//                    JOptionPane.showMessageDialog(null, "New movie added to the database");
//                }
//            } catch (SQLException | HeadlessException e) {
//                JOptionPane.showMessageDialog(null, e.getMessage());
//            }
//        }
//    }
    
//    public static ResultSet searchThis(){
//    
//    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * @return the organizer
     */
    public String getOrganizer() {
        return organizer;
    }

    /**
     * @param organizer the organizer to set
     */
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
}
