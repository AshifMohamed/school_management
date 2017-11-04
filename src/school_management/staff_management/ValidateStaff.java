/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.staff_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author AIA Insurance
 */
public class ValidateStaff {
    
    public boolean checkPhoneLength(String phone){
        
        if(phone.length()==10){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Incorrect Phone Number please Check and Retry");
            return false;
        }
    }
    
    public boolean checkNICLength(String nic){
        
        if((nic.length()==10)||(nic.length()==12)){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Incorrect NIC Number please Check and Retry");
            return false;
        }
    }
    public boolean checkNICCharacter(String nic){
        
        
        if((nic.charAt(nic.length()-1)=='V')||(nic.charAt(nic.length()-1)=='v')){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Incorrect NIC Number please Check and Retry");
            return false;
        }
    }
    
    public boolean validateMail(String mail){
    
    Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(mail);
        if(matcher.find()){
            
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Email");
            return false;
        }
                
    }
    
    public boolean validateDob(Date dob){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today=null;
        Date dateOfBirth=null;
        try {
             dateOfBirth=sdf.parse(sdf.format(dob));
             today=sdf.parse(sdf.format(new Date()));
        } catch (ParseException ex) {
            Logger.getLogger(ValidateStaff.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Invalid Date of Birth Entered");
            return false;
        }
        
        if(dateOfBirth.compareTo(today)>=0){
            JOptionPane.showMessageDialog(null, "Invalid Date of Birth Entered");
            return false;
        }else{
            
            return true;
        }   
    }
    public boolean isValidleaveStartDate(Date leaveStartDate){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today=null;
        Date leaveDate=null;
        try {
             leaveDate=sdf.parse(sdf.format(leaveStartDate));
             today=sdf.parse(sdf.format(new Date()));
        } catch (ParseException ex) {
            Logger.getLogger(ValidateStaff.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Invalid Date of Birth Entered");
            return false;
        }
        
        if(leaveDate.compareTo(today)<=0){
            JOptionPane.showMessageDialog(null, "Invalid Leave Start Date , It should a future Date");
            return false;
        }else{
            
            return true;
        }
        
    }
    public boolean isValidleaveEndDate(Date leaveStartDate,Date leaveEndDate){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date leaveDate=null;
        Date endDate=null;
        try {
             leaveDate=sdf.parse(sdf.format(leaveStartDate));
             endDate=sdf.parse(sdf.format(leaveEndDate));
        } catch (ParseException ex) {
            Logger.getLogger(ValidateStaff.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Invalid Date of Birth Entered");
            return false;
        }
        
        if(endDate.compareTo(leaveDate)<0){
            JOptionPane.showMessageDialog(null, "Invalid Leave End Date , Please Check and Retry");
            return false;
        }else{
            
            return true;
        }
        
    }
    
    
}
