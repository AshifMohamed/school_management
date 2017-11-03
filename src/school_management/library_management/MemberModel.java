/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management.library_management;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import school_management.DBConn;
/**
 *
 * @author Umani Welisara
 */
public class MemberModel {

    private String mregID;
    private String mname;
    private String mgrade;
    private String memail;
    private String mcontactnum;
    private String mstatus;

    public MemberModel(String mregID, String mname, String mgrade, String memail, String mcontactnum, String mstatus) {
        this.mregID = mregID;
        this.mname = mname;
        this.mgrade = mgrade;
        this.memail = memail;
        this.mcontactnum = mcontactnum;
        this.mstatus = mstatus;

    }

    public MemberModel(String pmregID) {
        this.mregID = pmregID;
    }

    public MemberModel(String mname, String mgrade, String memail, String mcontactnum, String mstatus) {
        this.mname = mname;
        this.mgrade = mgrade;
        this.memail = memail;
        this.mcontactnum = mcontactnum;
        this.mstatus = mstatus;
    }

    public boolean insertMember() {
        try {
            String s = "insert into members (mname,mgrade,memail,mcontactnum,mstatus) values (?,?,?,?,?)";
             PreparedStatement pst = DBConn.myConn().prepareStatement(s);
            pst.setString(1, this.mname);
            pst.setString(2, this.mgrade);
            pst.setString(3, this.memail);
            pst.setString(4, this.mcontactnum);
            pst.setString(5, this.mstatus);
            pst.execute();

            return true;
        } catch (SQLException e) {
            //return false;
            e.printStackTrace();
            //
        }
        return false;
//
    }

    public boolean updateMember() {
        try {
//            Label lblmregid = null;
//              String mregid = lblmregid.getText();
            String qu = "update members "
                    + "set mname=?,mgrade=?,memail=?,mcontactnum=?,mstatus=? "
                    + "where mregID=? ";

            PreparedStatement pst = DBConn.myConn().prepareStatement(qu);
           
            // pst = conn.prepareStatement(qr);
            // pst.setString(1, this.mregID);
            pst.setString(1, this.mname);
            pst.setString(2, this.mgrade);
            pst.setString(3, this.memail);
            pst.setString(4, this.mcontactnum);
            pst.setString(5, this.mstatus);
            pst.setString(6, this.mregID);

            pst.execute();
System.out.println(pst);
            //System.out.println(String.valueOf(pst.execute()).toString());

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public String getMregID() {
        return mregID;
    }

    public void setMregID(String mregID) {
        this.mregID = mregID;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMgrade() {
        return mgrade;
    }

    public void setMgrade(String mgrade) {
        this.mgrade = mgrade;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getMcontactnum() {
        return mcontactnum;
    }

    public void setMcontactnum(String mcontactnum) {
        this.mcontactnum = mcontactnum;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

}
