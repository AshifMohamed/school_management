/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.staff_management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import school_management.DBConn;

/**
 *
 * @author User
 */
public class staffModel {

    private String staffId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date   dateOfBirth ;
    private String religion;
    private String NIC;
    private String martialStatus;
    private String phone;
    private String mobile;
    private String email;
    private String currentAddress;
    private String permanantAddress;
    private String educationalQual;
    private String professionalQual;
    private Date   joinedDate ;
    private double salary;
    private String bank;
    private String accntNo;
    
    public staffModel(){
        
    }
    public staffModel(String fname,String lname,String gender,Date dob,String religion,String nic,String maritial,String phone,String mobile,String mail,String currentAdd,String perAdd,String eduQual,String profQual,Date joined,double sal,String bank,String accntNo){
        
        this.firstName=fname;
        this.lastName=lname;
        this.gender=gender;
        this.dateOfBirth=dob;
        this.religion=religion;
        this.NIC=nic;
        this.martialStatus=maritial;
        this.phone=phone;
        this.mobile=mobile;
        this.email=mail;
        this.currentAddress=currentAdd;
        this.permanantAddress=perAdd;
        this.educationalQual=eduQual;
        this.professionalQual=profQual;
        this.joinedDate=joined;
        this.salary=sal;
        this.bank=bank;
        this.accntNo=accntNo;
        
        
    }

    public String getStaffId() {
        return staffId;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanantAddress() {
        return permanantAddress;
    }

    public void setPermanantAddress(String permanantAddress) {
        this.permanantAddress = permanantAddress;
    }

    public String getEducationalQual() {
        return educationalQual;
    }

    public void setEducationalQual(String educationalQual) {
        this.educationalQual = educationalQual;
    }

    public String getProfessionalQual() {
        return professionalQual;
    }

    public void setProfessionalQual(String professionalQual) {
        this.professionalQual = professionalQual;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccntNo() {
        return accntNo;
    }

    public void setAccntNo(String accntNo) {
        this.accntNo = accntNo;
    }
    
    public boolean addStaff(){
             
             


             int executeUpdate;
             String columnNames="firstName,lastName,gender,dateOfBirth,religion,NIC,MaritialStatus,phone,mobile,email,currentAdd,permanantAdd,educationQual,proffQual,joinedDate,salary,bank,accntNo";
             String insertStaff = "insert into staff_table("+columnNames+") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try {
           
            PreparedStatement pst = DBConn.myConn().prepareStatement(insertStaff,Statement.RETURN_GENERATED_KEYS);
           
            java.sql.Date dob = new java.sql.Date(this.dateOfBirth.getTime());
            java.sql.Date join = new java.sql.Date(this.joinedDate.getTime());
            
            pst.setString(1, this.firstName);
            pst.setString(2, this.lastName);
            pst.setString(3, this.gender);
            pst.setDate(4, (java.sql.Date) dob);
            pst.setString(5, this.religion);
            pst.setString(6, this.NIC);
            pst.setString(7, this.martialStatus);
            pst.setString(8, this.phone);
            pst.setString(9, this.mobile);
            pst.setString(10, this.email);
            pst.setString(11, this.currentAddress);
            pst.setString(12, this.permanantAddress);
            pst.setString(13, this.educationalQual);
            pst.setString(14, this.professionalQual);
            pst.setDate(15, (java.sql.Date) join);
            pst.setDouble(16, this.salary);
            pst.setString(17, this.bank);
            pst.setString(18, this.accntNo);
            
            executeUpdate = pst.executeUpdate();
            
        ResultSet rs=pst.getGeneratedKeys();
            int newId=0;
            if (rs.next()) {
                    newId = rs.getInt(1);
                    System.out.println(newId);
                    createStaffLogin(newId);
                    updateLeaveCount(newId);
                   // oid.setId(newId);
                    
                }
                    
             System.out.println(executeUpdate);
            JOptionPane.showMessageDialog(null, "Successfully Added");
            return true;
            
        }catch (SQLIntegrityConstraintViolationException e) {
            
            JOptionPane.showMessageDialog(null, "Error in Adding Staff , NIC number already Exists");
             return false;
        } 
         catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error in Adding Staff");
             System.out.println(ex);
            
            return false;
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Error in Adding Staff");
             System.out.println(ex);
             
            return false;
        }
    }
    
    private void createStaffLogin(int staffId){
        
        System.out.println("came");
        String createLogin="insert into users(username,psword,role) values (?,?,?)";
        String username=Integer.toString(staffId);
        try {
           
            PreparedStatement pst = DBConn.myConn().prepareStatement(createLogin);
           
            java.sql.Date dob = new java.sql.Date(this.dateOfBirth.getTime());
            java.sql.Date join = new java.sql.Date(this.joinedDate.getTime());
            
            pst.setString(1,username );
            pst.setString(2,username);
            pst.setString(3,"Staff");
            pst.executeUpdate();
        }
        catch(SQLException ex){
                
            System.out.println(ex);
                }
        catch (Exception ex) {
           
             System.out.println(ex);
             
        }
    }   
   
    private void updateLeaveCount(int newId){
        
         System.out.println("came");
        String createLeave="insert into EmpLeave values (?,?)";
        
        try {
           
            PreparedStatement pst = DBConn.myConn().prepareStatement(createLeave);
                       
            pst.setInt(1,newId);
            pst.setInt(2,30);
            pst.executeUpdate();
            
        }
        catch(SQLException ex){
                
                System.out.println(ex);
                }
        catch (Exception ex) {
           
             System.out.println(ex);
             
        }
    }   
   
    
    public boolean updateStaff(){
             
             
             DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
          //   String columnNames="firstName,lastName,gender,dateOfBirth,religion,NIC,MaritialStatus,phone,mobile,email,currentAdd,permanantAdd,educationQual,proffQual,joinedDate,salary,bank,accntNo";
             String updateStaff = "update staff_table set firstName=?,lastName=?,gender=?,dateOfBirth=?,religion=?,NIC=?,MaritialStatus=?,phone=?,mobile=?,email=?,currentAdd=?,permanantAdd=?,educationQual=?,proffQual=?,joinedDate=?,salary=?,bank=?,accntNo=? where staff_Id= ?";
         try {
           
            PreparedStatement pst = DBConn.myConn().prepareStatement(updateStaff);
            java.sql.Date dob = new java.sql.Date(this.dateOfBirth.getTime());
            java.sql.Date join = new java.sql.Date(this.joinedDate.getTime());
           
            
            pst.setString(1, this.firstName);
            pst.setString(2, this.lastName);
            pst.setString(3, this.gender);
            pst.setDate(4, (java.sql.Date) dob);
            pst.setString(5, this.religion);
            pst.setString(6, this.NIC);
            pst.setString(7, this.martialStatus);
            pst.setString(8, this.phone);
            pst.setString(9, this.mobile);
            pst.setString(10, this.email);
            pst.setString(11, this.currentAddress);
            pst.setString(12, this.permanantAddress);
            pst.setString(13, this.educationalQual);
            pst.setString(14, this.professionalQual);
            pst.setDate(15, (java.sql.Date) join);
            pst.setDouble(16, this.salary);
            pst.setString(17, this.bank);
            pst.setString(18, this.accntNo);
             System.out.println(this.staffId);
            pst.setInt(19, Integer.parseInt(this.getStaffId()));
            int suc = pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Successfully Updated");
             
            return true;
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error in Updating");
             System.out.println(ex);
            return false;
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error in Updating");
             System.out.println(ex);
            return false;
        } 
    }
    
    public boolean deleteStaff() {
        
         boolean execute=false;

        try {
           
            String deleteStaff= "delete from staff_table where staff_Id= ?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(deleteStaff);
            pst.setString(1, this.staffId);

            execute = pst.execute();          
            return execute;
        } catch (Exception e) {
            return execute;
        }

    }
    
    public ResultSet searchStaffById(int staffId){
        
        ResultSet rs=null;
        try {                                                                                                                                    
            String sql = "select staff_Id as 'Staff ID',firstName as 'First Name',mobile as 'Contact',email as 'Email',currentAdd as 'Address'from staff_table where staff_Id like '%"+staffId+"%'"; 
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            rs = pst.executeQuery();
            
                       
            return rs;
            
        } catch (Exception e) {     
            System.out.println(e);
            return rs;
        }               
               
    }
    
    public ResultSet searchStaffByFname(String staffName){
        
        ResultSet rs=null;
        try {                                                                                                                                    
            String sql = "select staff_Id as 'Staff ID',firstName as 'First Name',mobile as 'Contact',email as 'Email',currentAdd as 'Address'from staff_table where firstName like '%"+staffName+"%'"; 
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            rs = pst.executeQuery();
            
                       
            return rs;
            
        } catch (Exception e) {     
            System.out.println(e);
            return rs;
        }               
               
    }
    
    public ResultSet selectStaff(int staffId){
        
         ResultSet rs=null;  
         try {
            String sql = "select * from staff_table where staff_Id= ?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, staffId);
            rs = pst.executeQuery();
                           
            return rs;
            
        } catch (Exception e) {
            System.out.println(e);
            return rs;
        }                      
    }
    
    
}
