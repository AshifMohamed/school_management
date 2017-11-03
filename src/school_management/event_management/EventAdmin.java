/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.event_management;

import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import school_management.DBConn;

/**
 *
 * @author wickr
 */
public class EventAdmin extends javax.swing.JFrame {

    /**
     * Creates new form EventAdmin
     */
    ResultSet rs = null;
    Event eventAdmin = new Event();
    private final String EVENT_NAME = "event_name";
    private final String EVENT_VENUE = "event_venue";
    SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat pTimeFormat = new SimpleDateFormat("HH:mm");
    String pname, pdescription, pvenue, porganizer, pstartDate, pstartTime, pendDate, pendTime;
    String pidPara = "";
    String nameAlready = "", venueAlready = "";
    boolean checkSum = true;

    public EventAdmin() {
        initComponents();
        jTable_upcoming.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadUpcoming()));
        jTable_all.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
        jTable_update.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadAll()));
        clearAll();
    }
    
    public void clearAll(){
        
        //clear labels
        jLabel11.setText("");
        jLabel15.setText("");
        jLabel16.setText("");
        jLabel17.setText("");
        jLabel18.setText("");
        jLabel19.setText("");
        jLabel28.setText("");
        jLabel29.setText("");
        jLabel30.setText("");
        jLabel31.setText("");
        jLabel32.setText("");
        jLabel33.setText("");
        
                
        //clear fields
            //Schedule event
        jTextField_name.setText("");
        jTextArea_description.setText("");
        jTextField_organizer.setText("");
        jXDatePicker_start.setDate(null);
        jXDatePicker_end.setDate(null);
            //Update event
        jTextField_updateName.setText("");
        jTextField_updateDescription.setText("");
        jTextField_updateOrganizer.setText("");
        jXDatePicker_updateStartOn.setDate(null);
        jXDatePicker_updateEndOn.setDate(null);
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        Date date = cal.getTime();
        jSpinner_start.setValue(date);
        jSpinner_end.setValue(date);
        jSpinner_updateStartAt.setValue(date);
        jSpinner_updateEndAt.setValue(date);
    }
    
    public boolean checkAvailability(){
        pstartDate = oDateFormat.format(jXDatePicker_start.getDate());
        pstartTime = jSpinner_start.getValue().toString().split(" ")[3].substring(0,5);
        pvenue = jComboBox_venue.getSelectedItem().toString();
        ResultSet temp = eventAdmin.searchThis(pstartDate, pstartTime, pvenue);
        try {
            while (temp.next()) {
                nameAlready = temp.getString(EVENT_NAME);
                venueAlready = temp.getString(EVENT_VENUE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nameAlready != "" && (venueAlready != "" || venueAlready == pvenue)){
            JOptionPane.showMessageDialog(this, "Already you have an event\n"+"Event - "+nameAlready+"\nVenue - "+venueAlready);
            nameAlready = "";
            venueAlready = "";
            return true;
        }
        else
            return false;
    }
    
    public void checkAndAssignUpdate() throws ParseException{
        if (jTextField_updateName.getText().isEmpty()){
            jLabel29.setText("*");
        }
        else{
            pname = jTextField_updateName.getText();
            jLabel29.setText("");
        }
        
        pvenue = jComboBox_updateVenue.getSelectedItem().toString();
        
        if (jTextField_updateDescription.getText().isEmpty()){
            jLabel30.setText("*");
        }
        else{
            pdescription = jTextField_updateDescription.getText();
            jLabel30.setText("");
        }
        
        if (jTextField_updateOrganizer.getText().isEmpty()){
            jLabel31.setText("*");
        }
        else{
            porganizer = jTextField_updateOrganizer.getText();
            jLabel31.setText("");
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        if (jXDatePicker_updateStartOn.getDate() == null || jXDatePicker_updateStartOn.getDate().compareTo(date) < 0){
            jLabel32.setText("*");
        }
        else{ 
            pstartDate = oDateFormat.format(jXDatePicker_updateStartOn.getDate());
            jLabel32.setText("");
        }
        
        pstartTime = jSpinner_updateStartAt.getValue().toString().split(" ")[3].substring(0,5);
        
        if (jXDatePicker_updateEndOn.getDate() == null){
            jLabel33.setText("*");
        }
        else if ((jXDatePicker_updateStartOn.getDate().after(jXDatePicker_updateEndOn.getDate()))){
            jLabel33.setText("Check start and end date");
        }
        else{
            pendDate = oDateFormat.format(jXDatePicker_updateEndOn.getDate());
            jLabel33.setText("");
        }
       
        pendTime = jSpinner_updateEndAt.getValue().toString().split(" ")[3].substring(0,5);
        
        if (jXDatePicker_updateStartOn.getDate().equals(jXDatePicker_updateEndOn.getDate())){
            Date stTime = pTimeFormat.parse(pstartTime);
            Date edTime = pTimeFormat.parse(pendTime);
            if (stTime.after(edTime)){
                jLabel28.setText("Check start and end time");
            }
            else
                jLabel28.setText("");
        }
    }
    
    public void checkAndAssign() throws ParseException{
        if (jTextField_name.getText().isEmpty()){
            jLabel11.setText("*");
        }
        else{
            pname = jTextField_name.getText();
            jLabel11.setText("");
        }
        
        pvenue = jComboBox_venue.getSelectedItem().toString();
        
        if (jTextArea_description.getText().isEmpty()){
            jLabel15.setText("*");
        }
        else{
            pdescription = jTextArea_description.getText();
            jLabel15.setText("");
        }
        
        if (jTextField_organizer.getText().isEmpty()){
            jLabel16.setText("*");
        }
        else{
            porganizer = jTextField_organizer.getText();
            jLabel16.setText("");
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        if (jXDatePicker_start.getDate() == null || jXDatePicker_start.getDate().compareTo(date) < 0){
            jLabel17.setText("*");
        }
        else{ 
            pstartDate = oDateFormat.format(jXDatePicker_start.getDate());
            jLabel17.setText("");
        }
        
        pstartTime = jSpinner_start.getValue().toString().split(" ")[3].substring(0,5);
        
        if (jXDatePicker_end.getDate() == null){
            jLabel18.setText("*");
        }
        else if ((jXDatePicker_start.getDate().after(jXDatePicker_end.getDate()))){
            jLabel18.setText("Check start and end date");
        }
        else{
            pendDate = oDateFormat.format(jXDatePicker_end.getDate());
            jLabel18.setText("");
        }
       
        pendTime = jSpinner_end.getValue().toString().split(" ")[3].substring(0,5);
        
        if (jXDatePicker_start.getDate().equals(jXDatePicker_end.getDate())){
            Date stTime = pTimeFormat.parse(pstartTime);
            Date edTime = pTimeFormat.parse(pendTime);
            if (stTime.after(edTime)){
                jLabel19.setText("Check start and end time");
            }
            else
                jLabel19.setText("");
        }        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jTabbedPane_event = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_upcoming = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_all = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField_byID = new javax.swing.JTextField();
        jTextField_byName = new javax.swing.JTextField();
        jXDatePicker_byDate = new org.jdesktop.swingx.JXDatePicker();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_search = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_description = new javax.swing.JTextArea();
        jComboBox_venue = new javax.swing.JComboBox<>();
        jTextField_organizer = new javax.swing.JTextField();
        jXDatePicker_start = new org.jdesktop.swingx.JXDatePicker();
        Date sdate = new Date(); SpinnerDateModel spinnerStartDate = new SpinnerDateModel(sdate, null, null, Calendar.HOUR_OF_DAY);
        jSpinner_start = new javax.swing.JSpinner(spinnerStartDate);
        jXDatePicker_end = new org.jdesktop.swingx.JXDatePicker();
        Date edate = new Date(); SpinnerDateModel spinnerEndDate = new SpinnerDateModel(edate, null, null, Calendar.HOUR_OF_DAY);
        jSpinner_end = new javax.swing.JSpinner(spinnerEndDate);
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton_schedule = new javax.swing.JButton();
        jButton_clear = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_update = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jTextField_updateName = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jComboBox_updateVenue = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextField_updateDescription = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jTextField_updateOrganizer = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jXDatePicker_updateStartOn = new org.jdesktop.swingx.JXDatePicker();
        jLabel22 = new javax.swing.JLabel();
        Date usdate = new Date(); SpinnerDateModel spinnerUpdateStartDate = new SpinnerDateModel(usdate, null, null, Calendar.HOUR_OF_DAY);
        jSpinner_updateStartAt = new javax.swing.JSpinner(spinnerUpdateStartDate);
        jXDatePicker_updateEndOn = new org.jdesktop.swingx.JXDatePicker();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Date uedate = new Date(); SpinnerDateModel spinnerUpdateEndDate = new SpinnerDateModel(uedate, null, null, Calendar.HOUR_OF_DAY);
        jSpinner_updateEndAt = new javax.swing.JSpinner(spinnerUpdateEndDate);
        jPanel13 = new javax.swing.JPanel();
        jButton_update = new javax.swing.JButton();
        jButton_updateClear = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Event Administrator");
        setAlwaysOnTop(true);
        setName("frame_eventAdmin"); // NOI18N
        setResizable(false);

        jTabbedPane_event.setBackground(new java.awt.Color(0, 0, 102));
        jTabbedPane_event.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane_event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane_eventMouseClicked(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jTable_upcoming.setBackground(new java.awt.Color(204, 204, 204));
        jTable_upcoming.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_upcoming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_upcoming.setEnabled(false);
        jScrollPane1.setViewportView(jTable_upcoming);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable_all.setBackground(new java.awt.Color(153, 153, 153));
        jTable_all.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_all.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_all.setEnabled(false);
        jScrollPane2.setViewportView(jTable_all);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Sitka Display", 1, 14)); // NOI18N
        jLabel1.setText("UPCOMING EVENTS");

        jLabel2.setFont(new java.awt.Font("Sitka Display", 1, 14)); // NOI18N
        jLabel2.setText("ALL EVENTS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);

        jTabbedPane_event.addTab("Events", jPanel1);

        jLabel12.setFont(new java.awt.Font("Sitka Display", 1, 14)); // NOI18N
        jLabel12.setText("EVENT ID");

        jLabel13.setFont(new java.awt.Font("Sitka Display", 1, 14)); // NOI18N
        jLabel13.setText("EVENT NAME");

        jLabel14.setFont(new java.awt.Font("Sitka Display", 1, 14)); // NOI18N
        jLabel14.setText("EVENT DATE");

        jTextField_byID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_byIDActionPerformed(evt);
            }
        });
        jTextField_byID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_byIDKeyTyped(evt);
            }
        });

        jTextField_byName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_byNameActionPerformed(evt);
            }
        });
        jTextField_byName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_byNameKeyTyped(evt);
            }
        });

        jXDatePicker_byDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker_byDateActionPerformed(evt);
            }
        });

        jTable_search.setBackground(new java.awt.Color(153, 153, 153));
        jTable_search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_search.setEnabled(false);
        jScrollPane4.setViewportView(jTable_search);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jTextField_byID, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel12)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jTextField_byName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(114, 114, 114)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jXDatePicker_byDate, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXDatePicker_byDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_byID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_byName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane_event.addTab("Search Event", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel3.setText("Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel4.setText("Description");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel5.setText("Venue");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel6.setText("Organizer");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel7.setText("Startin On");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel8.setText("Starting At");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel9.setText("Ending On");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel10.setText("Ending At");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        jTextField_name.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jTextField_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 275, 43));

        jTextArea_description.setColumns(20);
        jTextArea_description.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jTextArea_description.setRows(5);
        jScrollPane3.setViewportView(jTextArea_description);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 275, -1));

        jComboBox_venue.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jComboBox_venue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main Hall", "Secondary Hall" }));
        jPanel3.add(jComboBox_venue, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 275, 43));

        jTextField_organizer.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jTextField_organizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 275, 43));

        jXDatePicker_start.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jXDatePicker_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 275, 43));

        JSpinner.DateEditor startDateEditor = new JSpinner.DateEditor(jSpinner_start, "HH:mm"); jSpinner_start.setEditor(startDateEditor);
        jSpinner_start.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jSpinner_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 275, 42));

        jXDatePicker_end.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jXDatePicker_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 275, 43));

        JSpinner.DateEditor endDateEditor = new JSpinner.DateEditor(jSpinner_end, "HH:mm"); jSpinner_end.setEditor(endDateEditor);
        jSpinner_end.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jSpinner_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 275, 43));

        jLabel11.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("jLabel11");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("jLabel11");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("jLabel11");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        jLabel17.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("jLabel11");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        jLabel18.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("jLabel11");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, -1, -1));

        jLabel19.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("jLabel11");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, -1));

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new java.awt.GridLayout());

        jButton_schedule.setBackground(new java.awt.Color(0, 51, 102));
        jButton_schedule.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_schedule.setText("SCHEDULE");
        jButton_schedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_scheduleActionPerformed(evt);
            }
        });
        jPanel14.add(jButton_schedule);

        jButton_clear.setBackground(new java.awt.Color(0, 51, 102));
        jButton_clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_clear.setText("CLEAR");
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });
        jPanel14.add(jButton_clear);

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 240, 120));

        jTabbedPane_event.addTab("Create Event", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_update.setBackground(new java.awt.Color(153, 153, 153));
        jTable_update.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_update.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_updateMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_update);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 870, -1));

        jLabel24.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel24.setText("Name");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jTextField_updateName.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel4.add(jTextField_updateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 260, 41));

        jLabel25.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel25.setText("Venue");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jComboBox_updateVenue.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jComboBox_updateVenue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main Hall", "Secondary Hall" }));
        jPanel4.add(jComboBox_updateVenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 260, 40));

        jLabel26.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel26.setText("Description");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jTextField_updateDescription.setColumns(20);
        jTextField_updateDescription.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jTextField_updateDescription.setRows(5);
        jScrollPane7.setViewportView(jTextField_updateDescription);

        jPanel4.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 260, 180));

        jLabel20.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel20.setText("Organizer");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jTextField_updateOrganizer.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel4.add(jTextField_updateOrganizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 245, 41));

        jLabel21.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel21.setText("Starting On");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        jXDatePicker_updateStartOn.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel4.add(jXDatePicker_updateStartOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 245, 41));

        jLabel22.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel22.setText("Starting At");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, -1, -1));

        JSpinner.DateEditor updateStartDateEditor = new JSpinner.DateEditor(jSpinner_updateStartAt, "HH:mm"); jSpinner_updateStartAt.setEditor(updateStartDateEditor);
        jSpinner_updateStartAt.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel4.add(jSpinner_updateStartAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 245, 39));

        jXDatePicker_updateEndOn.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel4.add(jXDatePicker_updateEndOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 245, 40));

        jLabel23.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel23.setText("Ending On");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, -1, -1));

        jLabel27.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel27.setText("Ending At");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, -1, -1));

        JSpinner.DateEditor updateEndDateEditor = new JSpinner.DateEditor(jSpinner_updateEndAt, "HH:mm"); jSpinner_updateEndAt.setEditor(updateEndDateEditor);
        jSpinner_updateEndAt.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel4.add(jSpinner_updateEndAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, 245, 39));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setLayout(new java.awt.GridLayout());

        jButton_update.setBackground(new java.awt.Color(0, 51, 102));
        jButton_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_update.setText("UPDATE");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });
        jPanel13.add(jButton_update);

        jButton_updateClear.setBackground(new java.awt.Color(0, 51, 102));
        jButton_updateClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_updateClear.setText("CLEAR");
        jButton_updateClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateClearActionPerformed(evt);
            }
        });
        jPanel13.add(jButton_updateClear);

        jPanel4.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, 240, 120));

        jLabel28.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 0, 0));
        jLabel28.setText("jLabel11");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, 230, 20));

        jLabel29.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("jLabel11");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 60, 20));

        jLabel30.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 0, 0));
        jLabel30.setText("jLabel11");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 60, 20));

        jLabel31.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 0, 0));
        jLabel31.setText("jLabel11");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 60, 20));

        jLabel32.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 0, 0));
        jLabel32.setText("jLabel11");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 60, 20));

        jLabel33.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 0, 0));
        jLabel33.setText("jLabel11");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 220, 20));

        jTabbedPane_event.addTab("Update Event", jPanel4);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setText("MAIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane_event)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane_event))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_scheduleActionPerformed
        
        if (!checkAvailability()){
            try {
                checkAndAssign();
            } 
            catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
            if (jLabel11.getText() == "" && jLabel15.getText() == "" && jLabel16.getText() == "" && jLabel17.getText() == "" && jLabel18.getText() == "" && jLabel19.getText() == ""){
                Event evObj = new Event(pname, pdescription, pvenue, porganizer, pstartDate, pstartTime, pendDate, pendTime);
                if (evObj.InsertThis()){
                    JOptionPane.showMessageDialog(this, "SUCESSFULLY SCHEDULED");
                }
                else
                    JOptionPane.showMessageDialog(this, "SCHEDULE FAILED");      
            }
        }
    }//GEN-LAST:event_jButton_scheduleActionPerformed

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        // TODO add your handling code here:
        clearAll();
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jTabbedPane_eventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane_eventMouseClicked
        // TODO add your handling code here:
        jTable_upcoming.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadUpcoming()));
        jTable_all.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
        jTable_update.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadAll()));
    }//GEN-LAST:event_jTabbedPane_eventMouseClicked

    private void jTextField_byIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_byIDActionPerformed
        // TODO add your handling code here:
        String pID = jTextField_byID.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByID(pID)));
    }//GEN-LAST:event_jTextField_byIDActionPerformed

    private void jTextField_byIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_byIDKeyTyped
        // TODO add your handling code here:
        String pID = jTextField_byID.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByID(pID)));
    }//GEN-LAST:event_jTextField_byIDKeyTyped

    private void jTextField_byNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_byNameActionPerformed
        // TODO add your handling code here:
        String pName = jTextField_byName.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByName(pName)));
    }//GEN-LAST:event_jTextField_byNameActionPerformed

    private void jTextField_byNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_byNameKeyTyped
        // TODO add your handling code here:
        String pName = jTextField_byName.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByName(pName)));
    }//GEN-LAST:event_jTextField_byNameKeyTyped

    private void jXDatePicker_byDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker_byDateActionPerformed
        // TODO add your handling code here:
        String pendDate = oDateFormat.format(jXDatePicker_byDate.getDate());
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByDate(pendDate)));
    }//GEN-LAST:event_jXDatePicker_byDateActionPerformed

    private void jButton_updateClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateClearActionPerformed
        // TODO add your handling code here:
        clearAll();
    }//GEN-LAST:event_jButton_updateClearActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        // TODO add your handling code here:
            try {
                checkAndAssignUpdate();
            } 
            catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
            if (jLabel29.getText() == "" && jLabel30.getText() == "" && jLabel31.getText() == "" && jLabel32.getText() == "" && jLabel33.getText() == "" && jLabel28.getText() == ""){
                Event evObj = new Event(pname, pdescription, pvenue, porganizer, pstartDate, pstartTime, pendDate, pendTime);
                if (evObj.updateSpecific(pidPara)){
                    JOptionPane.showMessageDialog(this, "SUCESSFULLY UPDATED");
                    jTable_update.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadAll()));
                    clearAll();
                }
                else
                    JOptionPane.showMessageDialog(this, "UPDATE FAILED");      
            }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jTable_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_updateMouseClicked
        // TODO add your handling code here:
        int row = jTable_update.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable_update.getModel();
        pidPara = model.getValueAt(row, 0).toString();
        jTextField_updateName.setText(model.getValueAt(row, 1).toString());
        jTextField_updateDescription.setText(model.getValueAt(row, 2).toString());
        jComboBox_updateVenue.setSelectedItem(model.getValueAt(row, 3).toString());
        jTextField_updateOrganizer.setText(model.getValueAt(row, 4).toString());
        String tempSDate = model.getValueAt(row, 5).toString();
        SimpleDateFormat tempSDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1;
        try {
            date1 = tempSDateFormat.parse(tempSDate);
            jXDatePicker_updateStartOn.setDate(date1);  
        } catch (ParseException ex) {
            Logger.getLogger(EventAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tempEDate = model.getValueAt(row, 6).toString();
        SimpleDateFormat tempEDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        try {
            date2 = tempEDateFormat.parse(tempEDate);
            jXDatePicker_updateEndOn.setDate(date2);  
        } catch (ParseException ex) {
            Logger.getLogger(EventAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SimpleDateFormat pSTimeFormat = new SimpleDateFormat("HH:mm");
        String tempSTime = model.getValueAt(row, 7).toString();
        try {
            jSpinner_updateStartAt.setValue((Date)pSTimeFormat.parse(tempSTime));
        } catch (ParseException ex) {
        }
        
        SimpleDateFormat pETimeFormat = new SimpleDateFormat("HH:mm");
        String tempETime = model.getValueAt(row, 8).toString();
        try {
            jSpinner_updateEndAt.setValue((Date)pETimeFormat.parse(tempETime));
        } catch (ParseException ex) {
        }
        
    }//GEN-LAST:event_jTable_updateMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EventAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_schedule;
    private javax.swing.JButton jButton_update;
    private javax.swing.JButton jButton_updateClear;
    private javax.swing.JComboBox<String> jComboBox_updateVenue;
    private javax.swing.JComboBox<String> jComboBox_venue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinner_end;
    private javax.swing.JSpinner jSpinner_start;
    private javax.swing.JSpinner jSpinner_updateEndAt;
    private javax.swing.JSpinner jSpinner_updateStartAt;
    private javax.swing.JTabbedPane jTabbedPane_event;
    private javax.swing.JTable jTable_all;
    private javax.swing.JTable jTable_search;
    private javax.swing.JTable jTable_upcoming;
    private javax.swing.JTable jTable_update;
    private javax.swing.JTextArea jTextArea_description;
    private javax.swing.JTextField jTextField_byID;
    private javax.swing.JTextField jTextField_byName;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_organizer;
    private javax.swing.JTextArea jTextField_updateDescription;
    private javax.swing.JTextField jTextField_updateName;
    private javax.swing.JTextField jTextField_updateOrganizer;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_byDate;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_end;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_start;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_updateEndOn;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_updateStartOn;
    // End of variables declaration//GEN-END:variables
}
