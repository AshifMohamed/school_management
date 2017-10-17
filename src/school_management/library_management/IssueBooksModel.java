/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management.library_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import school_management.DBConn;
/**
 *
 * @author Umani Welisara
 */
public class IssueBooksModel {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private String book1;
    private String book2;
	private String memid;
	private String cdate;
	private String rdate;
 int passDate = 0;
    public IssueBooksModel() {
	}

    IssueBooksModel(String memid, String book1, String book2, String cdate, String rdate) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   this.memid=memid;
    this.book1=book1;
    this.book2=book2;
    this.cdate=cdate;
    this.rdate=rdate;
    
    
    
    }

//    public IssueBooksModel(String memid, String book1, String book2, String cdate, String rdate) {
//        this.memberID=memid;
//        this.bookID1=book1;
//        this.bookID2=book2;
//        this.dayOfBorrowed=cdate;
//        this.dayOfReturn=rdate;
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    IssueBooksModel(String memid, String book1, String book2, String cdate, String cdate0, String rdate) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
     public boolean insertIssueBook(){
         try {
             String ibook = "insert into issuebooks(memid,book1,book2,cdate,rdate) values (?,?,?,?,?)";
            PreparedStatement pst = DBConn.myConn().prepareStatement(ibook);
            pst.setString(1, this.memid);
            pst.setString(2, this.book1);
            pst.setString(3, this.book2);
//            pst.setString(4, this.cdate.toString());
//            pst.setString(5, this.rdate.toString());
            pst.setString(4, this.cdate);
          pst.setString(5, this.rdate);
            
               pst.execute();
             
             return true;
         } catch (Exception e) {
              return false;
         }
    
    }

    public String getBookID1() {
        return book1;
    }

    public void setBookID1(String bookID1) {
        this.book1 = bookID1;
    }

    public String getBookID2() {
        return book2;
    }

    public void setBookID2(String bookID2) {
        this.book2 = bookID2;
    }

  

    public String getMemberID() {
        return memid;
    }

    public void setMemberID(String memberID) {
        this.memid = memberID;
    }

    public String getDayOfBorrowed() {
        return cdate;
    }

    public void setDayOfBorrowed(String dayOfBorrowed) {
        this.cdate = dayOfBorrowed;
    }

    public String getDayOfReturn() {
        return rdate;
    }

    public void setDayOfReturn(String dayOfReturn) {
        this.rdate = dayOfReturn;
    }
        
        
   
    
    
}
