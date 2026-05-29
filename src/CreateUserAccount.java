
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Random;
import DAO.*;
import DBC.*;
import Objects.*;
import java.util.Date;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class CreateUserAccount extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateUserAccount.class.getName());

    public CreateUserAccount() {
        initComponents();
    }
    
    // ── add this with the other private fields, below the logger ──
    private userDAO userDAO = new userDAO();
    
    private String fname;
    private String lname;
    private String mname;
    private int age;
    private String gender;
    private int pin;
    private String convertedPin;
    private String bdayMonth;
    private String bdayDay;
    private String bdayYear;
    
    private String contactNum;
    private String username;
    private String password;
    private String passwordConfirmation;
    private boolean isUsernameValid;
    private boolean isContactNumValid;
    private boolean isPinValid;
    private boolean passCheck;
    
    private boolean fnameValid,lnameValid,mnameValid, ageValid;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TF_lname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TF_contactNum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TF_fname = new javax.swing.JTextField();
        noMname = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        f = new javax.swing.JRadioButton();
        m = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        CB_age = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        bday_month = new javax.swing.JComboBox<>();
        bday_day = new javax.swing.JComboBox<>();
        bday_year = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TF_mname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TF_username = new javax.swing.JTextField();
        securityDetailesPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        TF_password = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TF_AccountPin = new javax.swing.JTextField();
        TF_passwordConfirm = new javax.swing.JTextField();
        clearbtn = new javax.swing.JButton();
        createAccBtn = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 750));
        setPreferredSize(new java.awt.Dimension(1370, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 3));
        jPanel1.setForeground(new java.awt.Color(0, 51, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Please Fill Up the Following:");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Qbank (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome to QBANK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 857, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 100);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 8), "Personal Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Last Name: ");

        TF_lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_lnameKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("First Name: ");

        TF_contactNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_contactNumKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Middle Name: ");

        TF_fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_fnameKeyReleased(evt);
            }
        });

        noMname.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        noMname.setForeground(new java.awt.Color(102, 102, 102));
        noMname.setText("No legal middle name");
        noMname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noMnameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Gender:");

        f.setText("Female");

        m.setText("Male");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Age:");

        CB_age.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200" }));
        CB_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ageActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Birthday:");

        bday_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        bday_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bday_monthActionPerformed(evt);
            }
        });

        bday_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        bday_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bday_dayActionPerformed(evt);
            }
        });

        bday_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        bday_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bday_yearActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Contact Number:");

        TF_mname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_mnameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noMname, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bday_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bday_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bday_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(TF_fname)
                            .addComponent(TF_lname)
                            .addComponent(TF_mname, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                            .addComponent(TF_contactNum))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(f)
                        .addGap(18, 18, 18)
                        .addComponent(m)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_age, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(TF_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noMname)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(f)
                    .addComponent(m)
                    .addComponent(jLabel8)
                    .addComponent(CB_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bday_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bday_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bday_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_contactNum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(70, 120, 530, 490);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 8), "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Username (@john_cena):");

        TF_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_usernameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TF_username, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(TF_username, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(730, 120, 590, 190);

        securityDetailesPanel.setBackground(new java.awt.Color(255, 255, 255));
        securityDetailesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 8), "Security Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        securityDetailesPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel21.setText("Create Password:");

        TF_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_passwordKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel22.setText("Confirm Password:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel23.setText("Enter 6-Digit Pin:");

        TF_AccountPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_AccountPinActionPerformed(evt);
            }
        });
        TF_AccountPin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_AccountPinKeyReleased(evt);
            }
        });

        TF_passwordConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_passwordConfirmKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout securityDetailesPanelLayout = new javax.swing.GroupLayout(securityDetailesPanel);
        securityDetailesPanel.setLayout(securityDetailesPanelLayout);
        securityDetailesPanelLayout.setHorizontalGroup(
            securityDetailesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(securityDetailesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(securityDetailesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(securityDetailesPanelLayout.createSequentialGroup()
                        .addGroup(securityDetailesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_password)
                            .addGroup(securityDetailesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(TF_AccountPin)
                    .addComponent(TF_passwordConfirm)
                    .addGroup(securityDetailesPanelLayout.createSequentialGroup()
                        .addGroup(securityDetailesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(securityDetailesPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel23))
                            .addComponent(jLabel22))
                        .addGap(0, 438, Short.MAX_VALUE))))
        );
        securityDetailesPanelLayout.setVerticalGroup(
            securityDetailesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(securityDetailesPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_password, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(5, 5, 5)
                .addComponent(TF_passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_AccountPin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(securityDetailesPanel);
        securityDetailesPanel.setBounds(730, 330, 590, 280);

        clearbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(0, 102, 51));
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearbtn);
        clearbtn.setBounds(1060, 640, 90, 40);

        createAccBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createAccBtn.setForeground(new java.awt.Color(0, 102, 51));
        createAccBtn.setText("Create Account");
        createAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccBtnActionPerformed(evt);
            }
        });
        getContentPane().add(createAccBtn);
        createAccBtn.setBounds(1160, 640, 160, 40);

        Backbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(0, 102, 51));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Backbtn);
        Backbtn.setBounds(70, 640, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 780);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void noMnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noMnameActionPerformed
        if (noMname.isSelected()) {
            TF_mname.setText("");
            TF_mname.setEnabled(false);
            TF_mname.setBackground(Color.WHITE);
            mnameValid = true;   // no middle name is valid
        } else {
            TF_mname.setEnabled(true);
            mnameValid = false;  // force user to re-enter
        }
    }//GEN-LAST:event_noMnameActionPerformed

    private void bday_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bday_monthActionPerformed
        bdayMonth = bday_month.getSelectedItem().toString();

    }//GEN-LAST:event_bday_monthActionPerformed

    private void bday_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bday_dayActionPerformed
        bdayDay = bday_day.getSelectedItem().toString();
    }//GEN-LAST:event_bday_dayActionPerformed

    private void bday_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bday_yearActionPerformed
        bdayYear = bday_year.getSelectedItem().toString();
    }//GEN-LAST:event_bday_yearActionPerformed

    private void TF_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_passwordKeyReleased
        password = TF_password.getText();
        if (password.isBlank()) {
            TF_password.setBackground(Color.WHITE);
        } else {
            TF_password.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_TF_passwordKeyReleased

    private void TF_AccountPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_AccountPinActionPerformed
        
        convertedPin = TF_password.getText();
        
        if(convertedPin.isBlank()){
            TF_password.setBackground(Color.WHITE);
            isPinValid = false;
        }else{
            boolean validFormat = true;
            try{
                pin = Integer.parseInt(TF_password.getText());
            }catch(Exception e){
                validFormat = false;
            }
        
            if(validFormat){
                TF_password.setBackground(Color.WHITE);
                isPinValid = true;
            }else{
                TF_password.setBackground(Color.RED);
            }
        
            boolean ExactNumPin = true;
            if(convertedPin.length()>6 || convertedPin.length()<6){
                ExactNumPin = false;
                TF_password.setBackground(Color.RED);
            }
        
            if(convertedPin.length()>6){
                TF_password.setToolTipText("Pin must not exceeds in 6 digits");
            }else if(convertedPin.length()<6){
                TF_password.setToolTipText("Pin must consists 6 digits");
            }else if(!validFormat){
                TF_password.setToolTipText("Pin mut only contains numbers");
            }
        }
    }//GEN-LAST:event_TF_AccountPinActionPerformed

    private void TF_AccountPinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_AccountPinKeyReleased
        convertedPin = TF_AccountPin.getText();
        
        if(convertedPin.isBlank()){
            TF_AccountPin.setBackground(Color.WHITE);
            isPinValid = false;
        }else{
            boolean validFormat = true;
            try{
                pin = Integer.parseInt(TF_AccountPin.getText());
            }catch(Exception e){
                validFormat = false;
            }
        
            if(validFormat){
                TF_AccountPin.setBackground(Color.WHITE);
                isPinValid = true;
            }else{
                TF_AccountPin.setBackground(Color.RED);
            }
        
            boolean ExactNumPin = true;
            if(convertedPin.length()>6 || convertedPin.length()<6){
                ExactNumPin = false;
                TF_AccountPin.setBackground(Color.RED);
            }
        
            if(convertedPin.length()>6){
                TF_AccountPin.setToolTipText("Pin must not exceeds in 6 digits");
            }else if(convertedPin.length()<6){
                TF_AccountPin.setToolTipText("Pin must consists 6 digits");
            }else if(!validFormat){
                TF_AccountPin.setToolTipText("Pin mut only contains numbers");
            }
        }
    }//GEN-LAST:event_TF_AccountPinKeyReleased

    private void TF_passwordConfirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_passwordConfirmKeyReleased
        passwordConfirmation = TF_passwordConfirm.getText();
        boolean confirmedPass = true;
        
        if(passwordConfirmation.isBlank()){
            TF_passwordConfirm.setBackground(Color.WHITE);
            confirmedPass = false;
        }else{
            if(!password.equals(passwordConfirmation)){
                confirmedPass = false;
                TF_passwordConfirm.setBackground(Color.RED);
                TF_passwordConfirm.setToolTipText("Password is incorrect");
            }else{
                confirmedPass = true;
            }
        
            if(confirmedPass){
                TF_passwordConfirm.setBackground(Color.WHITE);
                passCheck=true;
            }
        }
    }//GEN-LAST:event_TF_passwordConfirmKeyReleased

    private void TF_lnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_lnameKeyReleased
        lname = TF_lname.getText().toUpperCase();
        
        if(lname.isBlank()){
            lnameValid = false;
            TF_lname.setBackground(Color.WHITE);
        }else if(lname.matches("[a-zA-Z]+")){
            TF_lname.setBackground(Color.WHITE);
            lnameValid=true;
        }else{
            TF_lname.setBackground(Color.RED);
            TF_lname.setToolTipText("Invalid Format: Letters only");
        }
    }//GEN-LAST:event_TF_lnameKeyReleased

    private void TF_fnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_fnameKeyReleased
        fname = TF_fname.getText().toUpperCase();
        
        if(fname.isBlank()){
            fnameValid = false;
            TF_fname.setBackground(Color.WHITE);
        }else if(fname.matches("[a-zA-Z]+")){
            TF_fname.setBackground(Color.WHITE);
            fnameValid=true;
        }else{
            TF_fname.setBackground(Color.RED);
            TF_fname.setToolTipText("Invalid Format: Letters only");
        }      
    }//GEN-LAST:event_TF_fnameKeyReleased

    private void TF_mnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_mnameKeyReleased
        
        mname = TF_mname.getText().toUpperCase();
        
        if(mname.isBlank()){
            mnameValid = false;
            TF_mname.setBackground(Color.WHITE);
        }else if(mname.matches("[a-zA-Z]+")){
            TF_mname.setBackground(Color.WHITE);
            mnameValid=true;
        }else{
            TF_mname.setBackground(Color.RED);
            TF_mname.setToolTipText("Invalid Format: Letters only");
        }
        
    }//GEN-LAST:event_TF_mnameKeyReleased

    private void CB_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ageActionPerformed
        String selectedAge = CB_age.getSelectedItem().toString();
    
    // Check if placeholder is selected
        if(selectedAge.equals("-- Select Age --") || selectedAge.trim().isEmpty()) {
            age = 0;
            return;
        }
    
        try {
            age = Integer.parseInt(selectedAge);
        } catch(NumberFormatException e) {
            age = 0;
        }
    }//GEN-LAST:event_CB_ageActionPerformed

    private void TF_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_usernameKeyReleased
        username = TF_username.getText();
        
        isUsernameValid = userDAO.usernameConfirmation(username);
        
        if(!isUsernameValid){
            TF_username.setToolTipText("This username is already registered");
            TF_username.setBackground(Color.RED);
        }else{
            TF_username.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_TF_usernameKeyReleased

    private void TF_contactNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_contactNumKeyReleased
        contactNum = TF_contactNum.getText();
        if(contactNum.isBlank()){
            TF_contactNum.setBackground(Color.WHITE);
            isContactNumValid = false;
        }else{
            boolean isValidFormat = true;
            try {
                long convertedNum = Long.parseLong(contactNum);
            }catch(Exception e){
                isValidFormat = false;
            }
            
            boolean isContactNumExist = userDAO.contactNumConfirmation(contactNum);
            
            if(isValidFormat && !isContactNumExist){
                isContactNumValid = true;
                TF_contactNum.setBackground(Color.WHITE);
            }else{
                  TF_contactNum.setBackground(Color.RED);
            }
            
            if(!isValidFormat) {
                TF_contactNum.setToolTipText("Please enter only numbers");
            } else if(isContactNumExist) {
                TF_contactNum.setToolTipText("This contact number is already registered");
            }            
        }
    }//GEN-LAST:event_TF_contactNumKeyReleased

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        TF_fname.setText("");         TF_fname.setBackground(Color.WHITE);
        TF_lname.setText("");         TF_lname.setBackground(Color.WHITE);
        TF_mname.setText("");         TF_mname.setBackground(Color.WHITE);
        TF_contactNum.setText("");    TF_contactNum.setBackground(Color.WHITE);
        TF_username.setText("");      TF_username.setBackground(Color.WHITE);
        TF_password.setText("");      TF_password.setBackground(Color.WHITE);
        TF_passwordConfirm.setText(""); TF_passwordConfirm.setBackground(Color.WHITE);
        TF_AccountPin.setText("");    TF_AccountPin.setBackground(Color.WHITE);

        CB_age.setSelectedIndex(0);
        bday_month.setSelectedIndex(0);
        bday_day.setSelectedIndex(0);
        bday_year.setSelectedIndex(0);

        f.setSelected(false);
        m.setSelected(false);
        noMname.setSelected(false);
        TF_mname.setEnabled(true);

        // Reset all flags
        fnameValid = false; lnameValid = false; mnameValid = false;
        isUsernameValid = false; isContactNumValid = false;
        isPinValid = false; passCheck = false;
        age = 0; gender = null;
        bdayMonth = null; bdayDay = null; bdayYear = null;
    }//GEN-LAST:event_clearbtnActionPerformed

    private void createAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccBtnActionPerformed
            // Validate gender selection
     if (!f.isSelected() && !m.isSelected()) {
         JOptionPane.showMessageDialog(this, "Please select a gender.");
         return;
     }
     gender = f.isSelected() ? f.getText() : m.getText();

     // Validate age
     if (age == 0) {
         JOptionPane.showMessageDialog(this, "Please select your age.");
         return;
     }

     // Validate birthdate
     if (bdayYear == null || bdayMonth == null || bdayDay == null
             || bdayYear.trim().isEmpty() || bdayMonth.trim().isEmpty() || bdayDay.trim().isEmpty()) {
         JOptionPane.showMessageDialog(this, "Please complete your birthdate.");
         return;
     }

     java.sql.Date sqlDate;
     try {
         String birthdate = bdayYear + "-" + bdayMonth + "-" + bdayDay;
         sqlDate = java.sql.Date.valueOf(birthdate);
     } catch (Exception e) {
         JOptionPane.showMessageDialog(this, "Invalid birthdate. Please check month/day/year.");
         return;
     }

     // Validate middle name
     if (!noMname.isSelected()) {
         mname = TF_mname.getText().trim().toUpperCase();
         if (mname.isBlank()) {
             JOptionPane.showMessageDialog(this, "Please enter middle name or check 'No legal middle name'.");
             return;
         }
         mnameValid = mname.matches("[a-zA-Z]+");
         if (!mnameValid) {
             JOptionPane.showMessageDialog(this, "Middle name must contain letters only.");
             return;
         }
     } else {
         mname = "";
         mnameValid = true;
     }

     // Check all validations passed
     if (!fnameValid) {
         JOptionPane.showMessageDialog(this, "Please enter a valid first name.");
         return;
     }
     if (!lnameValid) {
         JOptionPane.showMessageDialog(this, "Please enter a valid last name.");
         return;
     }
     if (!isContactNumValid) {
         JOptionPane.showMessageDialog(this, "Please enter a valid contact number.");
         return;
     }
     if (!isUsernameValid) {
         JOptionPane.showMessageDialog(this, "Username is invalid or already taken.");
         return;
     }
     if (!isPinValid) {
         JOptionPane.showMessageDialog(this, "Please enter a valid 6-digit PIN.");
         return;
     }
     if (!passCheck) {
         JOptionPane.showMessageDialog(this, "Passwords do not match.");
         return;
     }

     // Build User object
     user newUser = new user();
     newUser.setFname(fname);
     newUser.setMname(mname);
     newUser.setLname(lname);
     newUser.setAge(age);
     newUser.setGender(gender);
     newUser.setDateCreated(sqlDate);
     newUser.setContactNum(contactNum);
     newUser.setUsername(username);
     newUser.setPassword(password);
     newUser.setPin(convertedPin);

     // Call DAO
     boolean created = userDAO.createUser(newUser, java.math.BigDecimal.ZERO);

     if (created) {
         JOptionPane.showMessageDialog(this, "Account created successfully! Please log in.");
         new Main().setVisible(true);
         dispose();
     } else {
         JOptionPane.showMessageDialog(this,
             "Registration failed. Username or contact number may already exist.",
             "Error", JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_createAccBtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        new Main().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CreateUserAccount().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JComboBox<String> CB_age;
    private javax.swing.JTextField TF_AccountPin;
    private javax.swing.JTextField TF_contactNum;
    private javax.swing.JTextField TF_fname;
    private javax.swing.JTextField TF_lname;
    private javax.swing.JTextField TF_mname;
    private javax.swing.JTextField TF_password;
    private javax.swing.JTextField TF_passwordConfirm;
    private javax.swing.JTextField TF_username;
    private javax.swing.JComboBox<String> bday_day;
    private javax.swing.JComboBox<String> bday_month;
    private javax.swing.JComboBox<String> bday_year;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton createAccBtn;
    private javax.swing.JRadioButton f;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton m;
    private javax.swing.JCheckBox noMname;
    private javax.swing.JPanel securityDetailesPanel;
    // End of variables declaration//GEN-END:variables
}
