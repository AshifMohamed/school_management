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
import net.proteanit.sql.DbUtils;
import school_management.DBConn;

/**
 *
 * @author wickr
 */
public class Event {
    
    public Event(){
    
    }
    
    public Event(String cdate, String cdateadd){
    
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
    
//    public boolean validate() {
//        if (this.getAprice().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Some fields are empty");
//            return false;
//        }
//        return true;
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
    
}
