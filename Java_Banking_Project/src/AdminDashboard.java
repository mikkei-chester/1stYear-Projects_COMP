
import javax.swing.JOptionPane;
import DAO.*;
import DBC.*;
import Objects.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AdminDashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDashboard.class.getName());

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        Dashboard.setVisible(true);
        AllUser.setVisible(false);
        TransactionLog.setVisible(false);

        loadDashboard();
    }

    
    private void loadDashboard() {
        loadTotalUsers();
        loadRecentTransactions();
    }


    private void loadTotalUsers() {
        userAdminDAO aDAO = new userAdminDAO();
        int count = aDAO.readAllUsers().size();
        lblallusercount.setText("Total Number of Users:  " + count);
    }

    // jTable2 — Dashboard panel (last 10)
    private void loadRecentTransactions() {
        userAdminDAO aDAO = new userAdminDAO();
        java.util.List<transaction> list = aDAO.getAllTransactions();
        String[] cols = {"ID", "Date & Time", "Amount (₱)", "Balance (₱)", "Sender", "Receiver"};
        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(cols, 0) {
                @Override
                public boolean isCellEditable(int r, int c) { return false; }
            };
        int limit = Math.min(list.size(), 10);
        for (int i = 0; i < limit; i++) {
            transaction t = list.get(i);
            model.addRow(new Object[]{
                t.getTransactId(), t.getDateTime(),
                t.getAmount(), t.getBalance(),
                t.getSender(), t.getReceiver()
            });
        }
        tablelog.setModel(model);
    }

    // jTable3 — All Users panel
    private void loadAllUsersTable() {
        userAdminDAO aDAO = new userAdminDAO();
        java.util.List<user> users = aDAO.readAllUsers();
        String[] cols = {"First Name", "Last Name", "Username", "Gender", "Age", "Contact"};
        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(cols, 0) {
                @Override
                public boolean isCellEditable(int r, int c) { return false; }
            };
        for (user u : users) {
            model.addRow(new Object[]{
                u.getFname(), u.getLname(),
                u.getUsername(), u.getGender(),
                u.getAge(), u.getContactNum()
            });
        }
        tablealluserlog.setModel(model);
    }

    // jTable1 — Transaction Log panel (all)
    private void loadTransactionLog() {
        userAdminDAO aDAO = new userAdminDAO();
        java.util.List<transaction> list = aDAO.getAllTransactions();
        String[] cols = {"ID", "Date & Time", "Amount (₱)", "Balance (₱)", "Sender", "Receiver"};
        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(cols, 0) {
                @Override
                public boolean isCellEditable(int r, int c) { return false; }
            };
        for (transaction t : list) {
            model.addRow(new Object[]{
                t.getTransactId(), t.getDateTime(),
                t.getAmount(), t.getBalance(),
                t.getSender(), t.getReceiver()
            });
        }
        tabletransact.setModel(model);
    }
    

    private void filterAllUsers(String keyword) {
        String kw = (keyword == null) ? "" : keyword.trim().toLowerCase();
        userAdminDAO aDAO = new userAdminDAO();
        java.util.List<user> users = aDAO.readAllUsers();

        String[] cols = {"First Name", "Last Name", "Username", "Gender", "Age", "Contact"};
        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(cols, 0) {
                @Override public boolean isCellEditable(int r, int c) { return false; }
            };

        for (user u : users) {
            boolean match = kw.isEmpty()
                || u.getFname()     .toLowerCase().contains(kw)
                || u.getLname()     .toLowerCase().contains(kw)
                || u.getUsername()  .toLowerCase().contains(kw)
                || u.getContactNum().toLowerCase().contains(kw)
                || u.getGender()    .toLowerCase().contains(kw);
            if (match) {
                model.addRow(new Object[]{
                    u.getFname(), u.getLname(),
                    u.getUsername(), u.getGender(),
                    u.getAge(), u.getContactNum()
                });
            }
        }
        tablealluserlog.setModel(model);
    }

    private void filterTransactionLog(String keyword) {
        String kw = (keyword == null) ? "" : keyword.trim().toLowerCase();
        userAdminDAO aDAO = new userAdminDAO();
        java.util.List<transaction> list = aDAO.getAllTransactions();

        String[] cols = {"ID", "Date & Time", "Amount (₱)", "Balance (₱)", "Sender", "Receiver"};
        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(cols, 0) {
                @Override public boolean isCellEditable(int r, int c) { return false; }
            };

        for (transaction t : list) {
            boolean match = kw.isEmpty()
                || t.getSender()               .toLowerCase().contains(kw)
                || t.getReceiver()             .toLowerCase().contains(kw)
                || t.getAmount().toPlainString().contains(kw)
                || String.valueOf(t.getTransactId()).contains(kw)
                || t.getDateTime().toString()  .toLowerCase().contains(kw);
            if (match) {
                model.addRow(new Object[]{
                    t.getTransactId(), t.getDateTime(),
                    t.getAmount(),     t.getBalance(),
                    t.getSender(),     t.getReceiver()
                });
            }
        }
        tabletransact.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        t = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        Dashboard1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel5 = new javax.swing.JPanel();
        lblallusercount = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablelog = new javax.swing.JTable();
        AllUser = new javax.swing.JPanel();
        AllUser1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfsearchfilter = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        All = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablealluserlog = new javax.swing.JTable();
        CreateNewAdmin = new javax.swing.JPanel();
        CreateUser2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        create1st1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        tfadminmname = new javax.swing.JTextField();
        tfadminfname = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfadminlname = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        f1 = new javax.swing.JRadioButton();
        m1 = new javax.swing.JRadioButton();
        create2nd4 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        btnaddmin = new javax.swing.JButton();
        btnadminclear = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        EditUser = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        tfeditolduser = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        tfeditoldpass = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        tfeditoldconpass = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        tfeditnewconpass = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        tfeditnewuser = new javax.swing.JTextField();
        tfeditnewpass = new javax.swing.JTextField();
        btneditclear = new javax.swing.JButton();
        btneditenter = new javax.swing.JButton();
        TransactionLog = new javax.swing.JPanel();
        TransactionLog1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabletransact = new javax.swing.JTable();
        tfsearchfilter2 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1370, 750));
        setSize(new java.awt.Dimension(1450, 800));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Admin Dashboard");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(358, 358, 358)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addContainerGap())
        );

        t.setBackground(new java.awt.Color(255, 255, 255));
        t.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 8));

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));

        Dashboard1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 3, true));

        lblallusercount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblallusercount.setText("Total Number of User:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblallusercount, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblallusercount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("LOGS");

        tablelog.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tablelog);

        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLayeredPane2)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2))
        );

        javax.swing.GroupLayout Dashboard1Layout = new javax.swing.GroupLayout(Dashboard1);
        Dashboard1.setLayout(Dashboard1Layout);
        Dashboard1Layout.setHorizontalGroup(
            Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );
        Dashboard1Layout.setVerticalGroup(
            Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 955, Short.MAX_VALUE)
            .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
            .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AllUser.setBackground(new java.awt.Color(255, 255, 255));

        AllUser1.setBackground(new java.awt.Color(255, 255, 255));
        AllUser1.setPreferredSize(new java.awt.Dimension(600, 450));
        AllUser1.setVerifyInputWhenFocusTarget(false);

        tfsearchfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfsearchfilterActionPerformed(evt);
            }
        });
        tfsearchfilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfsearchfilterKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        All.setBackground(new java.awt.Color(255, 255, 255));
        All.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 5, true));

        tablealluserlog.setModel(new javax.swing.table.DefaultTableModel(
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
        tablealluserlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablealluserlogMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablealluserlog);

        javax.swing.GroupLayout AllLayout = new javax.swing.GroupLayout(All);
        All.setLayout(AllLayout);
        AllLayout.setHorizontalGroup(
            AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        );
        AllLayout.setVerticalGroup(
            AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AllLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Logs", All);

        CreateNewAdmin.setBackground(new java.awt.Color(204, 255, 204));
        CreateNewAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 5));

        CreateUser2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user (2).png"))); // NOI18N

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));

        create1st1.setBackground(new java.awt.Color(255, 255, 255));
        create1st1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 2, true));
        create1st1.setPreferredSize(new java.awt.Dimension(300, 800));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel23.setText("Last Name:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel24.setText("Middle Name:");

        tfadminlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfadminlnameActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel25.setText("First Name:");

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox2.setText("No legal middle name");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel26.setText("Birthdate:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel33.setText("Username (@john_cena):");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel34.setText("Contact Number:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel35.setText("Gender:");

        f1.setText("Female");

        m1.setText("Male");

        create2nd4.setBackground(new java.awt.Color(255, 255, 255));
        create2nd4.setBorder(javax.swing.BorderFactory.createTitledBorder("Security  Details"));
        create2nd4.setPreferredSize(new java.awt.Dimension(368, 419));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel36.setText("Create Password:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel37.setText("Confirm Password:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel38.setText("Enter 6-Digit Pin:");

        jTextField20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout create2nd4Layout = new javax.swing.GroupLayout(create2nd4);
        create2nd4.setLayout(create2nd4Layout);
        create2nd4Layout.setHorizontalGroup(
            create2nd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create2nd4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(create2nd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField18)
                    .addComponent(jTextField19)
                    .addComponent(jTextField20)
                    .addGroup(create2nd4Layout.createSequentialGroup()
                        .addGroup(create2nd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addGap(0, 178, Short.MAX_VALUE)))
                .addContainerGap())
        );
        create2nd4Layout.setVerticalGroup(
            create2nd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create2nd4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(5, 5, 5)
                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        javax.swing.GroupLayout create1st1Layout = new javax.swing.GroupLayout(create1st1);
        create1st1.setLayout(create1st1Layout);
        create1st1Layout.setHorizontalGroup(
            create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create1st1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create1st1Layout.createSequentialGroup()
                        .addGroup(create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel34)
                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel33)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfadminlname)
                            .addComponent(tfadminfname)
                            .addComponent(tfadminmname)
                            .addComponent(jLabel23)
                            .addGroup(create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(m1)
                                .addGroup(create1st1Layout.createSequentialGroup()
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField13))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(create1st1Layout.createSequentialGroup()
                        .addGroup(create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(create1st1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(f1))
                            .addGroup(create1st1Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(create2nd4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 37, Short.MAX_VALUE))))
        );
        create1st1Layout.setVerticalGroup(
            create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create1st1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(5, 5, 5)
                .addComponent(tfadminlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfadminfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfadminmname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f1)
                    .addComponent(m1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(create1st1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create1st1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel39)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(create1st1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(create2nd4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane6.setViewportView(create1st1);

        btnaddmin.setBackground(new java.awt.Color(0, 102, 0));
        btnaddmin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnaddmin.setForeground(new java.awt.Color(255, 255, 255));
        btnaddmin.setText("Add Admin");
        btnaddmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddminActionPerformed(evt);
            }
        });

        btnadminclear.setBackground(new java.awt.Color(0, 102, 0));
        btnadminclear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnadminclear.setForeground(new java.awt.Color(255, 255, 255));
        btnadminclear.setText("Clear All");
        btnadminclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadminclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnadminclear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnaddmin)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaddmin)
                    .addComponent(btnadminclear))
                .addGap(15, 15, 15))
        );

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setText("Create New Admin");

        javax.swing.GroupLayout CreateUser2Layout = new javax.swing.GroupLayout(CreateUser2);
        CreateUser2.setLayout(CreateUser2Layout);
        CreateUser2Layout.setHorizontalGroup(
            CreateUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateUser2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateUser2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(207, 207, 207))
        );
        CreateUser2Layout.setVerticalGroup(
            CreateUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateUser2Layout.createSequentialGroup()
                .addGroup(CreateUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateUser2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel8))
                    .addGroup(CreateUser2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CreateNewAdminLayout = new javax.swing.GroupLayout(CreateNewAdmin);
        CreateNewAdmin.setLayout(CreateNewAdminLayout);
        CreateNewAdminLayout.setHorizontalGroup(
            CreateNewAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 884, Short.MAX_VALUE)
            .addGroup(CreateNewAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CreateNewAdminLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CreateUser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(91, Short.MAX_VALUE)))
        );
        CreateNewAdminLayout.setVerticalGroup(
            CreateNewAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
            .addGroup(CreateNewAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CreateNewAdminLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CreateUser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Create  New Admin ", CreateNewAdmin);

        EditUser.setBackground(new java.awt.Color(255, 255, 255));
        EditUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 5, true));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 5));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Enter Old Username:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Enter Old Password:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Confirm Old Password:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(jLabel31)
                    .addComponent(tfeditoldpass, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(tfeditolduser)
                    .addComponent(tfeditoldconpass))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfeditolduser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfeditoldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfeditoldconpass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 5));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Enter New Username:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("Enter New Password:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("Confirm New Password:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43)
                    .addComponent(tfeditnewpass, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(tfeditnewuser)
                    .addComponent(tfeditnewconpass))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addComponent(tfeditnewuser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(tfeditnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfeditnewconpass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btneditclear.setBackground(new java.awt.Color(0, 102, 51));
        btneditclear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditclear.setForeground(new java.awt.Color(255, 255, 255));
        btneditclear.setText("Clear");
        btneditclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditclearActionPerformed(evt);
            }
        });

        btneditenter.setBackground(new java.awt.Color(0, 102, 51));
        btneditenter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditenter.setForeground(new java.awt.Color(255, 255, 255));
        btneditenter.setText("Enter");
        btneditenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditenterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditUserLayout = new javax.swing.GroupLayout(EditUser);
        EditUser.setLayout(EditUserLayout);
        EditUserLayout.setHorizontalGroup(
            EditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btneditclear)
                .addGap(18, 18, 18)
                .addComponent(btneditenter)
                .addGap(53, 53, 53))
        );
        EditUserLayout.setVerticalGroup(
            EditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditUserLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(EditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(EditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneditclear)
                    .addComponent(btneditenter))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Edit User", EditUser);

        javax.swing.GroupLayout AllUser1Layout = new javax.swing.GroupLayout(AllUser1);
        AllUser1.setLayout(AllUser1Layout);
        AllUser1Layout.setHorizontalGroup(
            AllUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUser1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addGroup(AllUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AllUser1Layout.createSequentialGroup()
                        .addComponent(tfsearchfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AllUser1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(23, 23, 23))))
        );
        AllUser1Layout.setVerticalGroup(
            AllUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUser1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(AllUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfsearchfilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(AllUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllUser1Layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(AllUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AllUser1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(344, 344, 344))
                            .addGroup(AllUser1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(481, 481, 481))))
                    .addGroup(AllUser1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout AllUserLayout = new javax.swing.GroupLayout(AllUser);
        AllUser.setLayout(AllUserLayout);
        AllUserLayout.setHorizontalGroup(
            AllUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AllUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
                .addContainerGap())
        );
        AllUserLayout.setVerticalGroup(
            AllUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AllUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        TransactionLog.setBackground(new java.awt.Color(255, 255, 255));

        TransactionLog1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Transaction Log");

        tabletransact.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabletransact);

        tfsearchfilter2.setText("Filter");
        tfsearchfilter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfsearchfilter2ActionPerformed(evt);
            }
        });
        tfsearchfilter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfsearchfilter2KeyReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N

        javax.swing.GroupLayout TransactionLog1Layout = new javax.swing.GroupLayout(TransactionLog1);
        TransactionLog1.setLayout(TransactionLog1Layout);
        TransactionLog1Layout.setHorizontalGroup(
            TransactionLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionLog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TransactionLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionLog1Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionLog1Layout.createSequentialGroup()
                        .addComponent(tfsearchfilter2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41))))
            .addGroup(TransactionLog1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
                .addContainerGap())
        );
        TransactionLog1Layout.setVerticalGroup(
            TransactionLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionLog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransactionLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(TransactionLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel32)
                        .addGroup(TransactionLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfsearchfilter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout TransactionLogLayout = new javax.swing.GroupLayout(TransactionLog);
        TransactionLog.setLayout(TransactionLogLayout);
        TransactionLogLayout.setHorizontalGroup(
            TransactionLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1071, Short.MAX_VALUE)
            .addGroup(TransactionLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TransactionLog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TransactionLogLayout.setVerticalGroup(
            TransactionLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
            .addGroup(TransactionLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TransactionLogLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TransactionLog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout tLayout = new javax.swing.GroupLayout(t);
        t.setLayout(tLayout);
        tLayout.setHorizontalGroup(
            tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tLayout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(AllUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
            .addGroup(tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(TransactionLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );
        tLayout.setVerticalGroup(
            tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AllUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(TransactionLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(t, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(310, 20, 970, 660);

        jPanel4.setBackground(new java.awt.Color(0, 51, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 3));
        jPanel4.setForeground(new java.awt.Color(0, 51, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Qbank (1).png"))); // NOI18N

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 0));
        jButton5.setText("Dashboard");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 0));
        jButton6.setText("Sign Out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 102, 0));
        jButton8.setText("Transaction Log");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 102, 0));
        jButton9.setText("All Users");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 280, 770);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 1412, 780);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        title.setText("Admin Dashboard");
        Dashboard.setVisible(true);
        AllUser.setVisible(false);
        TransactionLog.setVisible(false);
        loadDashboard();
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        title.setText("Admin Dashboard");
        Dashboard.setVisible(true);
        AllUser.setVisible(false);
        TransactionLog.setVisible(false);
        loadDashboard();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?");
        if (choice == JOptionPane.YES_OPTION) {
            new Main().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        title.setText("Transaction Log");
        Dashboard.setVisible(false);
        AllUser.setVisible(false);
        TransactionLog.setVisible(true);
        tfsearchfilter.setText("");
        loadTransactionLog();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        title.setText("All Users");
        Dashboard.setVisible(false);
        AllUser.setVisible(true);
        TransactionLog.setVisible(false);
        tfsearchfilter.setText("");
        loadAllUsersTable();
        loadTotalUsers();        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tfsearchfilter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfsearchfilter2ActionPerformed
        // TODO add your handling code here:
        String keyword = tfsearchfilter2.getText().trim().toLowerCase();
        if (keyword.isEmpty()) { loadTransactionLog(); return; }
        userAdminDAO aDAO = new userAdminDAO();
        java.util.List<transaction> list = aDAO.getAllTransactions();
        String[] cols = {"ID", "Date & Time", "Amount (₱)", "Balance (₱)", "Sender", "Receiver"};
        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(cols, 0) {
                @Override
                public boolean isCellEditable(int r, int c) { return false; }
            };
        for (transaction t : list) {
            if (t.getSender().toLowerCase().contains(keyword) ||
                t.getReceiver().toLowerCase().contains(keyword)) {
                model.addRow(new Object[]{
                    t.getTransactId(), t.getDateTime(),
                    t.getAmount(), t.getBalance(),
                    t.getSender(), t.getReceiver()
                });
            }
        }
        tabletransact.setModel(model);
    }//GEN-LAST:event_tfsearchfilter2ActionPerformed

    private void tfsearchfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfsearchfilterActionPerformed
        // TODO add your handling code here:
        String keyword = tfsearchfilter.getText().trim().toLowerCase();
        if (keyword.isEmpty()) { loadAllUsersTable(); return; }
        userAdminDAO aDAO = new userAdminDAO();
        java.util.List<user> users = aDAO.readAllUsers();
        String[] cols = {"First Name", "Last Name", "Username", "Gender", "Age", "Contact"};
        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(cols, 0) {
                @Override
                public boolean isCellEditable(int r, int c) { return false; }
            };
        for (user u : users) {
            if (u.getUsername().toLowerCase().contains(keyword) ||
                u.getFname().toLowerCase().contains(keyword) ||
                u.getLname().toLowerCase().contains(keyword)) {
                model.addRow(new Object[]{
                    u.getFname(), u.getLname(),
                    u.getUsername(), u.getGender(),
                    u.getAge(), u.getContactNum()
                });
            }
        }
        tablealluserlog.setModel(model);
    }//GEN-LAST:event_tfsearchfilterActionPerformed

    private void jTextField20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20MouseClicked

    private void btneditenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditenterActionPerformed
        String oldUsername = tfeditolduser.getText().trim();
        String oldPass     = tfeditoldpass.getText().trim();
        String confirmOld  = tfeditoldconpass.getText().trim();
        String newUsername = tfeditnewuser.getText().trim();
        String newPass     = tfeditnewpass.getText().trim();
        String confirmNew  = tfeditnewconpass.getText().trim();

        // ── Validation ────────────────────────────────────────────────────
        if (oldUsername.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the current username.");
            return;
        }
        if (oldPass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the current password.");
            return;
        }
        if (!oldPass.equals(confirmOld)) {
            JOptionPane.showMessageDialog(this, "Current passwords do not match.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!newPass.isEmpty() && !newPass.equals(confirmNew)) {
            JOptionPane.showMessageDialog(this, "New passwords do not match.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newUsername.isEmpty() && newPass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter at least one field to update.");
            return;
        }

        // ── Verify old credentials ────────────────────────────────────────
        userAdminDAO aDAO = new userAdminDAO();
        Long uid = aDAO.getIdByUsername(oldUsername);
        if (uid == null) {
            JOptionPane.showMessageDialog(this, "Username not found.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        userDAO uDAO = new userDAO();
        user u = uDAO.viewDetails(uid);
        if (u == null || !u.getPassword().equals(oldPass)) {
            JOptionPane.showMessageDialog(this, "Current password is incorrect.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ── Apply updates ─────────────────────────────────────────────────
        boolean ok = aDAO.updateUser(oldUsername, newUsername, newPass);
        if (ok) {
            JOptionPane.showMessageDialog(this, "User updated successfully.");
            loadAllUsersTable();
            btneditclearActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Update failed. Username may already exist.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneditenterActionPerformed

    private void tfadminlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfadminlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfadminlnameActionPerformed

    private void btnaddminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddminActionPerformed
        // TODO add your handling code here:
        String username = jTextField12.getText().trim();
        String password = jTextField18.getText().trim();
        String confirm  = jTextField19.getText().trim();

        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }
        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        userAdminDAO aDAO = new userAdminDAO();
        boolean ok = aDAO.createAdmin(username, password);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Admin account created successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed. Username may already exist.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnaddminActionPerformed

    private void btnadminclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadminclearActionPerformed
        // TODO add your handling code here:
        tfadminfname.setText("");  tfadminlname.setText("");
        tfadminmname.setText(""); jTextField12.setText("");
        jTextField13.setText(""); jTextField18.setText("");
        jTextField19.setText(""); jTextField20.setText("");
        f1.setSelected(false); m1.setSelected(false);
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_btnadminclearActionPerformed

    private void btneditclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditclearActionPerformed
        // TODO add your handling code here:
        tfeditolduser.setText("");
        tfeditoldpass.setText("");
        tfeditoldconpass.setText("");
        tfeditnewuser.setText("");
        tfeditnewpass.setText("");
        tfeditnewconpass.setText("");
    }//GEN-LAST:event_btneditclearActionPerformed

    private void tfsearchfilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsearchfilterKeyReleased
        // TODO add your handling code here:
        filterAllUsers(tfsearchfilter.getText());
    }//GEN-LAST:event_tfsearchfilterKeyReleased

    private void tfsearchfilter2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsearchfilter2KeyReleased
        // TODO add your handling code here:
        filterTransactionLog(tfsearchfilter2.getText());
    }//GEN-LAST:event_tfsearchfilter2KeyReleased

    private void tablealluserlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablealluserlogMouseClicked
        // TODO add your handling code here:
        int row = tablealluserlog.getSelectedRow();
        if (row < 0) return;

        // Read from the table — col 0=First, 1=Last, 2=Username
        String fname    = tablealluserlog.getValueAt(row, 0).toString();
        String lname    = tablealluserlog.getValueAt(row, 1).toString();
        String username = tablealluserlog.getValueAt(row, 2).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
            "Delete account for " + fname + " " + lname + " (@" + username + ")?\n"
            + "This action cannot be undone.",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        if (confirm != JOptionPane.YES_OPTION) return;

        javax.swing.JPasswordField pwField = new javax.swing.JPasswordField(20);
        pwField.setEchoChar('●');
        int pwResult = JOptionPane.showConfirmDialog(this,
            new Object[]{ "Enter password for @" + username + " to confirm:", pwField },
            "Password Required",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        if (pwResult != JOptionPane.OK_OPTION) return;

        String enteredPass = new String(pwField.getPassword()).trim();
        if (enteredPass.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        userAdminDAO aDAO = new userAdminDAO();
        Long uid = aDAO.getIdByUsername(username);
        if (uid == null) {
            JOptionPane.showMessageDialog(this,
                "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        userDAO uDAO = new userDAO();
        user u = uDAO.viewDetails(uid);
        if (u == null || !u.getPassword().equals(enteredPass)) {
            JOptionPane.showMessageDialog(this,
                "Incorrect password. Deletion cancelled.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ── Step 4: Delete ────────────────────────────────────────────────
        boolean ok = uDAO.deleteAccount(uid);
        if (ok) {
            JOptionPane.showMessageDialog(this,
                "Account @" + username + " deleted successfully.");
            loadAllUsersTable();
            loadTotalUsers();
        } else {
            JOptionPane.showMessageDialog(this,
                "Delete failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tablealluserlogMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new AdminDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel All;
    private javax.swing.JPanel AllUser;
    private javax.swing.JPanel AllUser1;
    private javax.swing.JPanel CreateNewAdmin;
    private javax.swing.JPanel CreateUser2;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Dashboard1;
    private javax.swing.JPanel EditUser;
    private javax.swing.JPanel TransactionLog;
    private javax.swing.JPanel TransactionLog1;
    private javax.swing.JButton btnaddmin;
    private javax.swing.JButton btnadminclear;
    private javax.swing.JButton btneditclear;
    private javax.swing.JButton btneditenter;
    private javax.swing.JPanel create1st1;
    private javax.swing.JPanel create2nd4;
    private javax.swing.JRadioButton f1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JLabel lblallusercount;
    private javax.swing.JRadioButton m1;
    private javax.swing.JPanel t;
    private javax.swing.JTable tablealluserlog;
    private javax.swing.JTable tablelog;
    private javax.swing.JTable tabletransact;
    private javax.swing.JTextField tfadminfname;
    private javax.swing.JTextField tfadminlname;
    private javax.swing.JTextField tfadminmname;
    private javax.swing.JTextField tfeditnewconpass;
    private javax.swing.JTextField tfeditnewpass;
    private javax.swing.JTextField tfeditnewuser;
    private javax.swing.JTextField tfeditoldconpass;
    private javax.swing.JTextField tfeditoldpass;
    private javax.swing.JTextField tfeditolduser;
    private javax.swing.JTextField tfsearchfilter;
    private javax.swing.JTextField tfsearchfilter2;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
