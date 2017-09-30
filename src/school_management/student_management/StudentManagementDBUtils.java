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
import java.text.SimpleDateFormat;
import java.util.Date;
import school_management.DBConn;

/**
 *
 * @author Neruppuda
 */
public class StudentManagementDBUtils {
    
    public static void main(String[] args) throws SQLException {
       
    }

    DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void saveStudent(String firstName, String lastName, String middleName, String dateOfBirth, String address, String nationality, String admissionGrade, String gender, String eMail, String contactNumber) {
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().executeUpdate("insert into student values('" + getStudentId() + "','" + oDateFormat.format(new Date()) + "','" + firstName + "','" + middleName + "','" + lastName + "','" + dateOfBirth + "','" + address + "','" + gender + "','" + nationality + "','" + contactNumber + "','" + eMail + "','" + admissionGrade + "','eligible')");
            System.out.println("Record Added Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

    public void updateStudent(String id, String firstName, String middleName , String lastName , String contactNumber , String nationality, String email ,String status , String address ){
        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().execute("update student set firstname ='" + firstName + "' ,lastname ='" + lastName + "' ,middlename ='" + middleName + "' ,address ='" + address + "' ,nationality ='" + nationality + "' ,contactNo ='" + contactNumber + "' ,mailid ='" + email + "' ,status ='" + status + "' where idstudent = '" + id + "'");
            System.out.println("Record updated Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
