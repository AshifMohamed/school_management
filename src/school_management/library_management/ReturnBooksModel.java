/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management.library_management;

import java.awt.Label;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.proteanit.sql.DbUtils;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import school_management.DBConn;

/**
 *
 * @author Umani Welisara
 */
public class ReturnBooksModel {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private String book1;
    private String book2;
    //private String memid;
    private Date cdate;
    private String rdate;
    private String fineday;
    private String totfine;
    private String today;
    private String rmemid;
  

    public ReturnBooksModel() {
    }

    ReturnBooksModel(String memid, String book1, String book2, String dayfine, String totfine) {

        this.rmemid = memid;
        this.book1 = book1;
        this.book2 = book2;
        this.fineday = dayfine;
        this.totfine = totfine;
    }

    public boolean insertReturnBook() {
        try {
            
            String rbook = "UPDATE issuebooks SET returnStatus = 'returned' WHERE memid = ? AND book1 = ? AND book2 = ?;";
            PreparedStatement pst = DBConn.myConn().prepareStatement(rbook);
            pst.setString(1, this.rmemid);
            pst.setString(2, this.book1);
            pst.setString(3, this.book2);


            pst.execute();//

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            
            return false;
        }

    }

    public String showBooks1() throws SQLException {

        try {
            String q = "select book1 from issuebooks where memid=?";
            pst = DBConn.myConn().prepareStatement(q);
            pst.setString(1, this.rmemid);
            rs = pst.executeQuery();

            if (rs.next()) {
                String b1 = rs.getString("book1");
                
                return b1;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public String showBooks2() throws SQLException {

        try {
            String q = "select book2 from issuebooks where memid=?";
            pst = DBConn.myConn().prepareStatement(q);
            pst.setString(1, this.rmemid);
            rs = pst.executeQuery();

            if (rs.next()) {

                String b2 = rs.getString("book2");
                
                return b2;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public float countdays() throws SQLException {
       
        
        //take cdate from the database 
        String issuedDatae = "";
        try {
            String q = "select cdate from issuebooks where memid=?";
            pst = DBConn.myConn().prepareStatement(q);
            pst.setString(1, this.rmemid);
            rs = pst.executeQuery();

            if (rs.next()) {
                issuedDatae = rs.getString("cdate");
                // rbid1.setText(b1);
                //rbid1=(b1);
            }

        

        SimpleDateFormat formatter1=new SimpleDateFormat("yyy-MM-dd");  

        Date dbDate = formatter1.parse(issuedDatae);  //get date from string format
        
        

        //today
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(currentDate));

        //count seconds between dates
        long diffDay = currentDate.getTime() - dbDate.getTime();
        TimeUnit.DAYS.convert(diffDay, TimeUnit.MILLISECONDS);

        float totdays = (float) (diffDay / (1000 * 60 * 60 * 24));
//...................
        // lrtotfine.(count);

        return totdays;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }
   

    public String getBook1() {
        return book1;
    }

    public void setBook1(String book1) {
        this.book1 = book1;
    }

    public String getBook2() {
        return book2;
    }

    public void setBook2(String book2) {
        this.book2 = book2;
    }

    public String getMemid() {
        return rmemid;
    }

    public void setMemid(String rmemid) {
        this.rmemid = rmemid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getFineday() {
        return fineday;
    }

    public void setFineday(String fineday) {
        this.fineday = fineday;
    }

    public String getTotfine() {
        return totfine;
    }

    public void setTotfine(String totfine) {
        this.totfine = totfine;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

}
