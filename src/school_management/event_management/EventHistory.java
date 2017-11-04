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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import school_management.DBConn;

/**
 *
 * @author wickr
 */
public class EventHistory {
    
    
    public EventHistory(){}
    
    public void autoHistory() throws ParseException{
        updateHisory();
    }
    
    public void updateHisory() throws ParseException {
        SimpleDateFormat pDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDay = new Date();
        Date endDate, versionDate;
        String pname, pdescription, pvenue, porganizer, pstartDate, pstartTime, pendDate, pendTime, ptableVersion;

        ResultSet rs1 = tableLoadAll();
        ResultSet rs2 = tableHistoryLoad();
        try {
            while (rs2.next()) {
                versionDate = rs2.getDate("table_version");
                if (versionDate.before(toDay)) {
                    try {
                        while (rs1.next()) {
                            endDate = rs1.getDate("end_date");
                            if (endDate.before(toDay)){
                                pname = rs1.getString("event_name");
                                pdescription = rs1.getString("event_description");
                                pvenue = rs1.getString("event_venue");
                                porganizer = rs1.getString("event_organizer");
                                pstartDate = rs1.getString("start_date");
                                pstartTime = rs1.getString("start_time");
                                pendDate = rs1.getString("end_date");
                                pendTime = rs1.getString("end_time");
                                ptableVersion = pDateFormat.format(toDay);
                                
                                InsertThis(pname, pdescription, pvenue, porganizer, pstartDate, pstartTime, pendDate, pendTime, ptableVersion);
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(EventAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public boolean InsertThis(String pname, String pdescription, String pvenue, String porganizer, String pstartDate, String pstartTime, String pendDate, String pendTime, String ptableVersion) {
            try {
                boolean result = false;
                Connection c = DBConn.myConn();
                String query;
                query = "insert into event_details_history (event_name, event_description, event_venue, event_organizer, start_date, start_time, end_date, end_time, table_version) "
                        + "values (?,?,?,?,?,?,?,?,?)";

                PreparedStatement statement = c.prepareStatement(query);
                statement.setString(1, pname);
                statement.setString(2,pdescription );
                statement.setString(3, pvenue);
                statement.setString(4, porganizer);
                statement.setString(5, pstartDate);
                statement.setString(6, pstartTime);
                statement.setString(7, pendDate);
                statement.setString(8, pendTime);
                statement.setString(9, ptableVersion);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                   return true;
                }
            } catch (SQLException | HeadlessException e) {
            }
            return false;
    }

    public ResultSet tableLoadAll() {
        try {
            String sql = "select * from event_details";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet tableHistoryLoad() {
        try {
            //String sql = "select table_version from event_details_history";
            String sql = "SELECT table_version FROM event_details_history ORDER BY event_id DESC LIMIT 1;";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
}
