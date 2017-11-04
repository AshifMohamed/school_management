/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management.staff_management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import school_management.DBConn;

/**
 *
 * @author AIA Insurance
 */
public class ApplyLeaveModel {
    
    
    private int staffId;
    private String staffName;
    private int availableBalance;
    private Date startDate;
    private Date endDate;
    private int noOfDays;
    private int AvailableBalanceBefore;
    private int AvailableBalanceAfter;
    private Date ApplyDate;
    private String Status;
    private PreparedStatement pst ;
    private ResultSet   rs ;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public int getAvailableBalanceBefore() {
        return AvailableBalanceBefore;
    }

    public void setAvailableBalanceBefore(int AvailableBalanceBefore) {
        this.AvailableBalanceBefore = AvailableBalanceBefore;
    }

    public int getAvailableBalanceAfter() {
        return AvailableBalanceAfter;
    }

    public void setAvailableBalanceAfter(int AvailableBalanceAfter) {
        this.AvailableBalanceAfter = AvailableBalanceAfter;
    }

    public Date getApplyDate() {
        return ApplyDate;
    }

    public void setApplyDate(Date ApplyDate) {
        this.ApplyDate = ApplyDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public boolean addLeave(){
        boolean status=false;
        
        return status;
    }
    
    public void getFirstNamefromStaffId(){
        
        String sql="select firstName from staff_table where staff_Id='"+this.staffId+"'";
        try{
         pst = DBConn.myConn().prepareStatement(sql);
         rs = pst.executeQuery();
          if(rs.next()){
        this.staffName=rs.getString("firstName");
          }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void getLeaveBalancefromStaffId(){
        
        String sql="select LeaveBalance from EmpLeave where staff_Id='"+this.staffId+"'";
        try{
         pst = DBConn.myConn().prepareStatement(sql);
         rs = pst.executeQuery();
         
         if(rs.next()){
        this.availableBalance=Integer.parseInt(rs.getString("LeaveBalance"));
         }
        
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public boolean applyLeave(){
        
        boolean execute=false;
                      
             String applyLeave = "insert into EmpLeaveRequest(staff_Id,FirstName,LeaveStartDate,LeaveEndDate,NoOfDays,AvailableBalanceBefore"
                     + ",AvailableBalanceAfter,ApplyDate,Status)"
                     + " values (?,?,?,?,?,?,?,?,?)";
         try {
           
            PreparedStatement pst = DBConn.myConn().prepareStatement(applyLeave);
           
            java.sql.Date start = new java.sql.Date(this.startDate.getTime());
            java.sql.Date end = new java.sql.Date(this.endDate.getTime());
            java.sql.Date apply = new java.sql.Date(this.ApplyDate.getTime());
            
            pst.setInt(1, this.staffId);
            pst.setString(2, this.staffName);
            pst.setDate(3, (java.sql.Date) start);
            pst.setDate(4, (java.sql.Date) end);
            pst.setInt(5, this.noOfDays);
            pst.setInt(6, this.availableBalance);
            pst.setInt(7, this.AvailableBalanceAfter);
            pst.setDate(8,(java.sql.Date) apply);
            pst.setString(9, "Pending");
            
            
                 int executeUpdate = pst.executeUpdate();
            
        

           
             System.out.println(executeUpdate);
            JOptionPane.showMessageDialog(null, "Leave Request Successfully Sent");
            return execute;
            
        } catch (SQLException ex) {
           
             System.out.println(ex);
             System.out.println(execute);
             JOptionPane.showMessageDialog(null, "Error in sending Leave Request ");
            return execute;
        } catch (Exception ex) {
           
             System.out.println(ex);
              System.out.println(execute);
              JOptionPane.showMessageDialog(null, "Error in sending Leave Request");
            return execute;
        }
    }
    
    
}
