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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import school_management.DBConn;

/**
 *
 * @author wickr
 */
public class Event {

    private String eventID;
    private String name;
    private String description;
    private String venue;
    private String organizer;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;

    public Event() {

    }

    public Event(String pname, String pdescription, String pvenue, String porganizer, String pstartDate, String pstartTime, String pendDate, String pendTime) {
        this.name = pname;
        this.description = pdescription;
        this.venue = pvenue;
        this.organizer = porganizer;
        this.startDate = pstartDate;
        this.startTime = pstartTime;
        this.endDate = pendDate;
        this.endTime = pendTime;
    }

    public ResultSet tableloadUpcoming() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String cdate = dateFormat.format(date);
            Calendar c = Calendar.getInstance();
            c.setTime(new Date()); // Now use today date.
            c.add(Calendar.DATE, 5); // Adding 5 days
            String cdateadd = dateFormat.format(c.getTime());
            String sql = "select event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', start_time as 'Starting on', end_time as 'Ending on' from event_details where start_date between '" + cdate + "' and '" + cdateadd + "'";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet tableloadCustom() {
        try {
            String sql = "select event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', start_time as 'Starting on', end_time as 'Ending on' from event_details";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet tableloadAll() {
        try {
            String sql = "select event_id as 'ID', event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', end_date as 'Till', start_time as 'Starting on', end_time as 'Ending on' from event_details";
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

    public ResultSet searchByID(String pID) {
        this.setEventID(pID);
        try {
            String sql = "select event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', start_time as 'Starting on', end_time as 'Ending on' from event_details where event_id like '%" + this.getEventID() + "%'";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet searchByName(String pName) {
        this.setName(pName);
        try {
            String sql = "select event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', start_time as 'Starting on', end_time as 'Ending on' from event_details where event_name like '%" + this.getName() + "%'";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet searchByDate(String pDate) {
        this.setStartDate(pDate);
        try {
            String sql = "select event_name as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date 'Date', start_time as 'Starting on', end_time as 'Ending on' from event_details where start_date like '%" + this.getStartDate() + "%'";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet searchThis(String pstartDate, String pStartTime, String pVenue) {

        try {
            String sql = "select event_name, event_venue from event_details where start_date = \"" + pstartDate + "\" and start_time = \"" + pStartTime + "\" and event_venue = \"" + pVenue + "\"";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
        } else {
            return result;
        }
        return result;
    }

    public boolean updateSpecific(String pid) {
        boolean result = false;
        if (this.validate()) {
            try {
                Connection c = DBConn.myConn();
                String query;
                query = "update event_details set event_name = ? ,event_description = ? ,event_venue = ? ,event_organizer = ? ,start_date = ? ,start_time = ? ,end_date = ? ,end_time = ? where event_id = " + pid;

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
        } else {
            return result;
        }
        return result;
    }

    public void removeEvent(String pid) {
        try {
            Connection c = DBConn.myConn();
            String query;
            query = "delete from event_details where event_id = " + pid;
            PreparedStatement statement = c.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException | HeadlessException e) {
        }
    }

    public ResultSet getHistory() {
        try {
            String sql = "select DISTINCT(event_name) as 'Name', event_description as 'Description', event_venue as 'Venue', event_organizer as 'Organizer', start_date as 'Started on', end_date as 'Ended on', start_time as 'Started at', end_time as 'Ended at' from event_details_history";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

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

    /**
     * @return the eventID
     */
    public String getEventID() {
        return eventID;
    }

    /**
     * @param eventID the eventID to set
     */
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

}
