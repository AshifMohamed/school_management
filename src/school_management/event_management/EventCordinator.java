/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.event_management;

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
import net.proteanit.sql.DbUtils;
import school_management.Login;
import school_management.LoginUI;

/**
 *
 * @author wickr
 */
public class EventCordinator extends javax.swing.JFrame {

    /**
     * Creates new form EventCordinator
     */
    ResultSet rs = null;
    Event eventAdmin = new Event();
    private final String EVENT_NAME = "event_name";
    private final String EVENT_VENUE = "event_venue";
    SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat pTimeFormat = new SimpleDateFormat("HH:mm");
    String pname, pdescription, pvenue, porganizer, pstartDate, pstartTime, pendDate, pendTime;
    String pidPara = "";
    String uname = "Umani Welisara";
    String nameAlready = "", venueAlready = "";
    boolean checkSum = true;
    
    public EventCordinator() {
        initComponents();
        jTable_upcoming.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadUpcoming()));
        jTable_all.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
        clearAll();
        
        jLabel_username.setText(uname);
        
        try {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        Date d = new Date();
                        String date = d.toString();
                        String ar[] = date.split(" ");
                        String newdate = ar[5] + "-" + ar[1] + "-" + ar[2];

                        lbldate.setText(newdate);
                        lbltime.setText(ar[3]);
                    }
                }
            }).start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void clearAll(){
        
        //clear labels
        jLabel11.setText("");
        jLabel15.setText("");
        jLabel16.setText("");
        jLabel17.setText("");
        jLabel18.setText("");
        jLabel19.setText("");
        
                
        //clear fields
            //Schedule event
        jTextField_name.setText("");
        jTextArea_description.setText("");
        jTextField_organizer.setText("");
        jXDatePicker_start.setDate(null);
        jXDatePicker_end.setDate(null);
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        Date date = cal.getTime();
        jSpinner_start.setValue(date);
        jSpinner_end.setValue(date);
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

        jLabel20 = new javax.swing.JLabel();
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
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton_logout = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        jLabel_username = new javax.swing.JLabel();

        jLabel20.setText("jLabel20");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EVENT CORDINATOR");
        setBackground(new java.awt.Color(51, 51, 255));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addGap(10, 10, 10))
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
                .addGap(0, 0, 0))
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
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField_byID, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel12)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jTextField_byName, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(159, 159, 159)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXDatePicker_byDate, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(80, 80, 80)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
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
                .addGap(0, 0, 0))
        );

        jTabbedPane_event.addTab("Search Event", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel3.setText("Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel4.setText("Description");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel5.setText("Venue");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel6.setText("Organizer");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel7.setText("Startin On");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel8.setText("Starting At");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel9.setText("Ending On");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, -1, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel10.setText("Ending At");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, -1));

        jTextField_name.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jTextField_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 275, 43));

        jTextArea_description.setColumns(20);
        jTextArea_description.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jTextArea_description.setRows(5);
        jScrollPane3.setViewportView(jTextArea_description);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 275, -1));

        jComboBox_venue.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jComboBox_venue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main Hall", "Secondary Hall" }));
        jPanel3.add(jComboBox_venue, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 275, 43));

        jTextField_organizer.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jTextField_organizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 275, 43));
        jPanel3.add(jXDatePicker_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 275, 43));

        JSpinner.DateEditor startDateEditor = new JSpinner.DateEditor(jSpinner_start, "HH:mm"); jSpinner_start.setEditor(startDateEditor);
        jSpinner_start.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jSpinner_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 275, 42));
        jPanel3.add(jXDatePicker_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 275, 43));

        JSpinner.DateEditor endDateEditor = new JSpinner.DateEditor(jSpinner_end, "HH:mm"); jSpinner_end.setEditor(endDateEditor);
        jSpinner_end.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        jPanel3.add(jSpinner_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 275, 43));

        jLabel11.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("jLabel11");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("jLabel11");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        jLabel16.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("jLabel11");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        jLabel17.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("jLabel11");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        jLabel18.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("jLabel11");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, -1, -1));

        jLabel19.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("jLabel11");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 690, -1, -1));

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

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

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, 240, 120));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_calendar-clock_299096.png"))); // NOI18N
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_calendar_1055101.png"))); // NOI18N
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 0, -1, 707));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 707, -1, -1));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 852, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 756, -1, -1));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 0, -1, 771));

        jTabbedPane_event.addTab("Create Event", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jButton_logout.setBackground(new java.awt.Color(153, 0, 0));
        jButton_logout.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton_logout.setText("LOGOUT");
        jButton_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logoutActionPerformed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/17241-200.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Date:");

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldate.setText("jLabel10");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Time:");

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltime.setText("jLabel13");

        jLabel_username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_username.setText("jLabel41");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(10, 10, 10)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(9, 9, 9)
                        .addComponent(lbltime))
                    .addComponent(jLabel_username)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(28, 28, 28)
                .addComponent(jLabel_username)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(lbldate))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(lbltime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane_event, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane_event)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane_eventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane_eventMouseClicked
        // TODO add your handling code here:
        jTable_upcoming.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadUpcoming()));
        jTable_all.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.tableloadCustom()));
    }//GEN-LAST:event_jTabbedPane_eventMouseClicked

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        // TODO add your handling code here:
        clearAll();
    }//GEN-LAST:event_jButton_clearActionPerformed

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

    private void jXDatePicker_byDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker_byDateActionPerformed
        // TODO add your handling code here:
        String pendDate = oDateFormat.format(jXDatePicker_byDate.getDate());
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByDate(pendDate)));
    }//GEN-LAST:event_jXDatePicker_byDateActionPerformed

    private void jTextField_byNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_byNameKeyTyped
        // TODO add your handling code here:
        String pName = jTextField_byName.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByName(pName)));
    }//GEN-LAST:event_jTextField_byNameKeyTyped

    private void jTextField_byNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_byNameActionPerformed
        // TODO add your handling code here:
        String pName = jTextField_byName.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByName(pName)));
    }//GEN-LAST:event_jTextField_byNameActionPerformed

    private void jTextField_byIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_byIDKeyTyped
        // TODO add your handling code here:
        String pID = jTextField_byID.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByID(pID)));
    }//GEN-LAST:event_jTextField_byIDKeyTyped

    private void jTextField_byIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_byIDActionPerformed
        // TODO add your handling code here:
        String pID = jTextField_byID.getText();
        jTable_search.setModel(DbUtils.resultSetToTableModel(eventAdmin.searchByID(pID)));
    }//GEN-LAST:event_jTextField_byIDActionPerformed

    private void jButton_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logoutActionPerformed
        // TODO add your handling code here:
        LoginUI log = new LoginUI();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(EventCordinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventCordinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventCordinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventCordinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventCordinator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_logout;
    private javax.swing.JButton jButton_schedule;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_username;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner_end;
    private javax.swing.JSpinner jSpinner_start;
    private javax.swing.JTabbedPane jTabbedPane_event;
    private javax.swing.JTable jTable_all;
    private javax.swing.JTable jTable_search;
    private javax.swing.JTable jTable_upcoming;
    private javax.swing.JTextArea jTextArea_description;
    private javax.swing.JTextField jTextField_byID;
    private javax.swing.JTextField jTextField_byName;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_organizer;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_byDate;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_end;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker_start;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
