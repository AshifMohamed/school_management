/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author wickr
 */
public class Login {
    private String username;
    private String psword;
    private String role;
    
    public Login(){}

    public Login(String uname, String pword, String crole) {
        this.username = uname;
        this.psword = pword;
        this.role = crole;
    }
    
    public boolean checkAvailability() {
        if (this.getUsername().length() == 0 || this.getPsword().length() == 0 || this.getRole().length() == 0) {
            JOptionPane.showMessageDialog(null, "Empty Fields Detected ");
        } else {
            try {
                Connection c = DBConn.myConn();
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM users WHERE username = '" + getUsername() + "' AND psword = '" + getPsword() + "' AND role = '" + getRole() + "'");

                if (rs.absolute(1)) {
                    c.close();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return false;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the psword
     */
    public String getPsword() {
        return psword;
    }

    /**
     * @param psword the psword to set
     */
    public void setPsword(String psword) {
        this.psword = psword;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}
