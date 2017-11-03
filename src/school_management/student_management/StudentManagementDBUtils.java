/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.student_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import school_management.DBConn;

/**
 *
 * @author Neruppuda
 */
public class StudentManagementDBUtils {
    
    public static void main(String[] args) throws SQLException {     
        System.out.println(getApplicantId());
    }

    DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public boolean saveStudent(String firstName, String lastName, String middleName, Date dateOfBirth, String address, String nationality, String gender, String eMail, String contactNumber ,String applicantId,int currentGrade) {
         boolean saved=false;
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().executeUpdate("insert into student values('" + getStudentId() + "','" + oDateFormat.format(new Date()) + "','" + firstName + "','" + middleName + "','" + lastName + "','" +oDateFormat.format(dateOfBirth)  + "','" + address + "','" + gender + "','" + nationality + "','" + contactNumber + "','" + eMail + "','active','" + applicantId + "','" + currentGrade + "')");
             saved=true;
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
        return saved;
    }
    
     public boolean saveApplicant(String applicantName, Date date, String contactNo, String grade,int marks,String hallName,String time ,String status) throws ParseException {
         boolean saved=false;
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().executeUpdate("insert into applicant values('" + getApplicantId()+  "','" + marks + "','" + hallName + "','" + grade + "','" + time + "','" + status + "','" + applicantName + "','" + contactNo + "','"+oDateFormat.format(date)+"')");
            saved=true;
        } catch (SQLException e) {
            saved=false;
        }
        return saved;
    }

     public boolean addparentDetail(String studentId, String guradianName, String address, String contactNumber,String occupation,String email) {
         boolean saved=false;
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().executeUpdate("insert into  parent values('" +studentId+ "','" + guradianName + "','" + occupation + "','" + address + "','" + contactNumber + "','" + email + "')");
            saved=true;
        } catch (SQLException e) {
            saved=false;
        }
        return saved;
    }
     
     public boolean addDisciplinarydetail(String studentId, String text) {
         boolean saved=false;
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().executeUpdate("insert into  disciplinarydetail values('" +studentId+ "','" + text + "')");
            saved=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return saved;
    }
     
     public boolean updateDisciplinarydetail(String studentId , String text){
       
        boolean saved=false;
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().execute("update disciplinarydetail set description ='" + text + "'  where studentId='"+studentId+"'");
            saved=true;
        } catch (SQLException e) {
           saved=false;
        }
        return saved; 
    }
    public static String getStudentId() {
        String studentId = null;
        String id = null;
        try (Connection dbConnection = DBConn.myConn()) {
            ResultSet rs = dbConnection.createStatement().executeQuery("SELECT idstudent FROM student ORDER BY idstudent DESC LIMIT 1");
            while (rs.next()) {
                id = rs.getString("idstudent");
            }
            studentId = "ST_" + String.format("%05d", Integer.parseInt(id.split("_")[1]) + 1);
            return studentId;
        } catch (SQLException e) {

        }
        return studentId;
    }
    
    
    
    public static String getApplicantId() {
        String studentId = null;
        String id = null;
        try (Connection dbConnection = DBConn.myConn()) {
            ResultSet rs = dbConnection.createStatement().executeQuery("SELECT applicantId FROM applicant ORDER BY applicantId DESC LIMIT 1");
            while (rs.next()) {
                id = rs.getString("applicantId");
            }
            studentId = "AP_" + String.format("%05d", Integer.parseInt(id.split("_")[1]) + 1);
            return studentId;
        } catch (SQLException e) {

        }
        return studentId;
    }
    
    
        public static String getpaymentId() {
        String studentId = null;
        String id = null;
        try (Connection dbConnection = DBConn.myConn()) {
            ResultSet rs = dbConnection.createStatement().executeQuery("SELECT idpayment FROM payment ORDER BY idpayment DESC LIMIT 1");
            while (rs.next()) {
                id = rs.getString("idpayment");
            }
            studentId = "PT_" + (Integer.parseInt(id.split("_")[1]) + 1);
            return studentId;
        } catch (SQLException e) {

        }
        return studentId;
    }
        
   public static float getAmountForTerm(String studentId){
       float amount = 0;
        
        try (Connection dbConnection = DBConn.myConn()) {
            ResultSet rs = dbConnection.createStatement().executeQuery("select f.amountPerTerm from  student s , fees2017 f where s.currentGrade = f.grade and s.idstudent='"+studentId+"'");
            while (rs.next()) {
                amount = Float.parseFloat(rs.getString("f.amountPerTerm"));
            }
            
            return amount;
        } catch (SQLException e) {

        }
        return amount;
   }
        
    public boolean addIntialPayment(String studentid, String paidAmount,String term){
        String status=null;
        float remainingAmount = getAmountForTerm(studentid)-Float.parseFloat(paidAmount);
        if(getAmountForTerm(studentid)-Float.parseFloat(paidAmount)>0){
            status="Pending";
        }
        else{
            status="completed";
        }
        boolean saved=false;
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().executeUpdate("insert into payment values('" + getpaymentId()+  "','"+oDateFormat.format(new Date())+"','" + paidAmount + "','" + remainingAmount + "','" + studentid + "',2017,'" + term + "','" + status + "')");
            saved=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return saved; 
    }    
    
    public static float getPaidAmount(String paymenId){
        float amount = 0;
        
        try (Connection dbConnection = DBConn.myConn()) {
            ResultSet rs = dbConnection.createStatement().executeQuery("select paidAmount from  payment  where idpayment='"+paymenId+"'");
            while (rs.next()) {
                amount = Float.parseFloat(rs.getString("paidAmount"));
            }
            
            return amount;
        } catch (SQLException e) {

        }
        return amount;
    }
    
    public static float getRemainingAmount(String paymenId){
        float amount = 0;
        
        try (Connection dbConnection = DBConn.myConn()) {
            ResultSet rs = dbConnection.createStatement().executeQuery("select remainingAmount from  payment  where idpayment='"+paymenId+"'");
            while (rs.next()) {
                amount = Float.parseFloat(rs.getString("remainingAmount"));
            }
            
            return amount;
        } catch (SQLException e) {

        }
        return amount;
    }
    
    public boolean updatePayment(String paymentId , float amount,String studentId){
        String status=null;
        float remainingAmount = (getAmountForTerm(studentId)-getPaidAmount(paymentId))-amount;
        if(remainingAmount>0){
            status="Pending";
        }
        else{
            status="completed";
        }
        boolean saved=false;
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().execute("update payment set paidAmount ='" + (getPaidAmount(paymentId)+amount) + "' ,remainingAmount ='" + remainingAmount + "' ,paymentStatus ='" + status + "' where idpayment='"+paymentId+"'");
            saved=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return saved; 
    }

    public void updateStudent(String id, String firstName, String middleName , String lastName , String contactNumber , String nationality, String email ,String status , String address ){
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().execute("update student set firstname ='" + firstName + "' ,lastname ='" + lastName + "' ,middlename ='" + middleName + "' ,address ='" + address + "' ,nationality ='" + nationality + "' ,contactNo ='" + contactNumber + "' ,mailid ='" + email + "' ,status ='" + status + "' where idstudent = '" + id + "'");
            System.out.println("Record updated Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
