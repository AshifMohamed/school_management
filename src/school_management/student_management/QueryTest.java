/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management.student_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import school_management.DBConn;

/**
 *
 * @author Neruppuda
 */
public class QueryTest {

    public static void main(String[] args) {
      // getAllUser();
        
    }

    public static void getAllUser() {

        try (Connection dbConnection = DBConn.myConn()) {
            ResultSet rs = dbConnection.createStatement().executeQuery("select * from student");

            while (rs.next()) {
                System.out.println(rs.getString("idstudent"));
                System.out.println(rs.getString("firstname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addUser(int id, String name, int age) {

        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().executeUpdate("insert into testtable values('" + id + "','" + name + "','" + age + "')");
            System.out.println("Record Added Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static void updateUser(int id, int age) {

        try (Connection dbConnection = DBConn.myConn()) {
            dbConnection.createStatement().execute("update testtable set age ='" + age + "' where id = '" + id + "'");
            System.out.println("Record updated Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
