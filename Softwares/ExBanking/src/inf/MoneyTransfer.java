/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import codes.DBconnect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author Iroshan
 */
public class MoneyTransfer extends javax.swing.JFrame {

       Connection conn;
       PreparedStatement pst;
       ResultSet rs;
       PreparedStatement pst2;
       PreparedStatement pst3;
       PreparedStatement pst4;
       PreparedStatement pst5;
       progressThread th;
       
       String status = null;
       
    public MoneyTransfer() {
        initComponents();
        Login log = new Login();
        log.setIcon();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblUser.setText(Home.lblUser.getText());
        conn = DBconnect.connect();
        btnCancel.enable(false);
        btnCancel.hide();
        clear();
        date();
        time();
    }
   public void date(){
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lblDate.setText(sdf.format(d));
    }
    public void time(){
        
      new Timer(0, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                lblTime.setText(sdf.format(d));
              
          }
      }){
            
        }.start();
    }
   class progressThread extends Thread{
      
      JProgressBar proBar;
      
      progressThread(JProgressBar proBar){
          
          proBar = ProgressBar; 
      }
      
      public void run(){
          
          String Tamount = tbTransferAmount.getText();
               
          if(Float.parseFloat(Tamount) <= 20000){
               int min = 0;
               int max =50;
                ProgressBar.setMaximum(min);
                ProgressBar.setMaximum(max);
                ProgressBar.setValue(0);
          
          for(int i=min; i<=max; i++){
              
              ProgressBar.setValue(i);
             
              
              try {
                  sleep(500);
                  
              } catch (InterruptedException ex) {
                  Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
              }
              
            if (i==max){
                JOptionPane.showMessageDialog(null, "Transfaction Completed!");
                ProgressBar.setValue(0);
                lblProgress.setText("");
                btnCancel.enable(false);
                btnCancel.hide();
                clear();
              
          }
          }
          }
         
          else{
               int min = 0;
               int max =100;
                   ProgressBar.setMaximum(min);
          ProgressBar.setMaximum(max);
          ProgressBar.setValue(0);
          
          for(int i=min; i<=max; i++){
              
              ProgressBar.setValue(i);
             
              
              try {
                  sleep(500);
                  
              } catch (InterruptedException ex) {
                  Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
              }
              
            if (i==max){
                JOptionPane.showMessageDialog(null, "Transfaction Successfully!");
                ProgressBar.setValue(0);
                lblProgress.setText("");
                btnCancel.enable(false);
                btnCancel.hide();
                clear();
          }
         
            }  
          }       
      
      }
  }
        
         public void clear(){
               tbAccNo.setText("");
               tbAccUserName.setText("");
               tbCurrentAmount.setText("");
               tbTransferAccNo.setText("");
               tbTransferUserName.setText("");
               tbCurrentAmount1.setText("");
               tbTransferAmount.setText("");
               ProgressBar.hide();
    }
         
         public void searchAcc1(){
              String srch = tbAccNo.getText();
        try {
            String sql = "SELECT * FROM tblSavingAccount WHERE Account_No='"+srch+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()){
                String name = rs.getString("User_Name");
                    tbAccUserName.setText(name);
                String CAmount = rs.getString("Amount");
                    tbCurrentAmount.setText(CAmount);
                 
                rs.close();
                pst.close();
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         }
         public void searchAcc2(){
              String srch = tbTransferAccNo.getText();
        String check = tbAccNo.getText();
        
        if(srch.equals(check)){
            JOptionPane.showMessageDialog(null, "Same Accounts.Please check Account Numbers");
            tbTransferAccNo.setText("");
        }
        else{
             try {
            String sql = "SELECT * FROM tblSavingAccount WHERE Account_No='"+srch+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()){
                String name = rs.getString("User_Name");
                    tbTransferUserName.setText(name);
                String CAmount = rs.getString("Amount");
                    tbCurrentAmount1.setText(CAmount);
                 
                rs.close();
                pst.close();
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
       
         }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblProgress = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tbAccNo = new javax.swing.JTextField();
        tbAccUserName = new javax.swing.JTextField();
        tbCurrentAmount = new javax.swing.JTextField();
        btnTransSearch = new javax.swing.JButton();
        tbTransferAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tbTransferAccNo = new javax.swing.JTextField();
        btnAccSearch = new javax.swing.JButton();
        tbTransferUserName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tbCurrentAmount1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        btnTransfer1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblBankAccounts = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        lblHelp = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        JMenuExit = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mone7y Transfer");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Money Transfer");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-left-24.png"))); // NOI18N
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 30, -1));

        lblProgress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblProgress.setForeground(new java.awt.Color(0, 204, 0));
        getContentPane().add(lblProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 700, 180, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Acccount NO :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("User Name : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Current Amount : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tranfer Amount : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("LKR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 300, -1, -1));

        tbAccNo.setBackground(new java.awt.Color(204, 204, 204));
        tbAccNo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAccNoActionPerformed(evt);
            }
        });
        getContentPane().add(tbAccNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 340, 30));

        tbAccUserName.setEditable(false);
        tbAccUserName.setBackground(new java.awt.Color(204, 204, 204));
        tbAccUserName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbAccUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAccUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(tbAccUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 340, 30));

        tbCurrentAmount.setEditable(false);
        tbCurrentAmount.setBackground(new java.awt.Color(204, 204, 204));
        tbCurrentAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCurrentAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbCurrentAmountActionPerformed(evt);
            }
        });
        getContentPane().add(tbCurrentAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 290, 140, 30));

        btnTransSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTransSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-search-24.png"))); // NOI18N
        btnTransSearch.setText("Search");
        btnTransSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 370, 110, 30));

        tbTransferAmount.setBackground(new java.awt.Color(204, 204, 204));
        tbTransferAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTransferAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTransferAmountActionPerformed(evt);
            }
        });
        getContentPane().add(tbTransferAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, 140, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("LKR");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, -1, -1));

        btnCancel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 680, 110, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Transfer Acc. No : ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        tbTransferAccNo.setBackground(new java.awt.Color(204, 204, 204));
        tbTransferAccNo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTransferAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTransferAccNoActionPerformed(evt);
            }
        });
        getContentPane().add(tbTransferAccNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 340, 30));

        btnAccSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAccSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-search-24.png"))); // NOI18N
        btnAccSearch.setText("Search");
        btnAccSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnAccSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 110, 30));

        tbTransferUserName.setEditable(false);
        tbTransferUserName.setBackground(new java.awt.Color(204, 204, 204));
        tbTransferUserName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTransferUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTransferUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(tbTransferUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 340, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("User Name : ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));

        tbCurrentAmount1.setEditable(false);
        tbCurrentAmount1.setBackground(new java.awt.Color(204, 204, 204));
        tbCurrentAmount1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCurrentAmount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbCurrentAmount1ActionPerformed(evt);
            }
        });
        getContentPane().add(tbCurrentAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 460, 140, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("LKR");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 470, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Current Amount : ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, -1, -1));

        ProgressBar.setBackground(new java.awt.Color(0, 255, 0));
        ProgressBar.setForeground(new java.awt.Color(0, 255, 0));
        getContentPane().add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 680, 450, 30));

        btnTransfer1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTransfer1.setText("Transfer");
        btnTransfer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransfer1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransfer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 620, 110, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Date & Time :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        lblDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        jPanel14.setBackground(new java.awt.Color(32, 101, 101));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel14.setToolTipText("Search Transfaction Details Here");
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Transfaction Details");
        jLabel24.setToolTipText("Search Transfaction Details Here");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel15.setBackground(new java.awt.Color(153, 51, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Transfaction Details");
        jLabel25.setToolTipText("Bank Branch List");
        jPanel15.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 50));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 250, 50));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Log Out");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 60, -1, -1));

        jPanel3.setBackground(new java.awt.Color(32, 101, 101));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(0, 153, 255));
        jLabel27.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("eBanking");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Home");
        jLabel28.setToolTipText("Go to Home Page");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 20));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Employees");
        jLabel18.setToolTipText("Add Employee");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jLabel18.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jLabel18ComponentMoved(evt);
            }
        });
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        lblBankAccounts.setBackground(new java.awt.Color(255, 255, 255));
        lblBankAccounts.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblBankAccounts.setForeground(new java.awt.Color(255, 255, 255));
        lblBankAccounts.setText("Bank Accounts\n");
        lblBankAccounts.setToolTipText("Bank Account Type Details Here");
        lblBankAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBankAccountsMouseClicked(evt);
            }
        });
        jPanel3.add(lblBankAccounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Admin");
        lblUser.setToolTipText("Log Out");
        lblUser.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblUserAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
        });
        jPanel3.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 70, -1));

        lblReport.setBackground(new java.awt.Color(255, 255, 255));
        lblReport.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblReport.setForeground(new java.awt.Color(255, 255, 255));
        lblReport.setText("Reports");
        lblReport.setToolTipText("Get Bank Reports");
        lblReport.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblReportAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReportMouseClicked(evt);
            }
        });
        jPanel3.add(lblReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        lblHelp.setBackground(new java.awt.Color(255, 255, 255));
        lblHelp.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblHelp.setForeground(new java.awt.Color(255, 255, 255));
        lblHelp.setText("Help");
        lblHelp.setToolTipText("Get Bank Reports");
        lblHelp.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblHelpAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHelpMouseClicked(evt);
            }
        });
        jPanel3.add(lblHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 50, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 1180, 50));

        jPanel10.setBackground(new java.awt.Color(32, 101, 101));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel10.setToolTipText("Money Transfer Here");
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Money Transfer");
        jLabel21.setToolTipText("Money Transfer Here");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 250, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-shutdown-35 (1).png"))); // NOI18N
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 50, -1, -1));

        jPanel12.setBackground(new java.awt.Color(32, 101, 101));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel12.setToolTipText("Search Deposit Details Here");
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Deposit Details");
        jLabel22.setToolTipText("Search Deposit Details Here");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel13.setBackground(new java.awt.Color(153, 51, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Transfaction Details");
        jLabel23.setToolTipText("Bank Branch List");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 50));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 250, 50));

        jPanel9.setBackground(new java.awt.Color(32, 101, 101));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel9.setToolTipText("Money Deposit Here");
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Money Deposit");
        jLabel19.setToolTipText("Money Deposit Here");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, -1));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, 50));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 3, true));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 880, 430));

        lblTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/beautiful-wallpaper-39.jpg"))); // NOI18N
        jLabel2.setText("jLabel1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -220, 1390, 1130));

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-16.png"))); // NOI18N
        jMenuItem2.setText("Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-change-user-16.png"))); // NOI18N
        jMenuItem1.setText("Changer User");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        JMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        JMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/Actions-edit-delete-icon.png"))); // NOI18N
        JMenuExit.setText("Exit");
        JMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuExit);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("       About");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-about-16.png"))); // NOI18N
        jMenuItem3.setText("About Bank");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("      Help");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-contact-16.png"))); // NOI18N
        jMenuItem4.setText("Developer");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1396, 819));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
       Home hm = new Home();
       hm.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void tbAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAccNoActionPerformed
       searchAcc1();
    }//GEN-LAST:event_tbAccNoActionPerformed

    private void tbAccUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAccUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbAccUserNameActionPerformed

    private void tbCurrentAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCurrentAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCurrentAmountActionPerformed

    private void btnTransSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransSearchActionPerformed
            searchAcc2();
    }//GEN-LAST:event_btnTransSearchActionPerformed

    private void tbTransferAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTransferAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTransferAmountActionPerformed

    private void tbTransferAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTransferAccNoActionPerformed
        searchAcc2();
    }//GEN-LAST:event_tbTransferAccNoActionPerformed

    private void btnAccSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccSearchActionPerformed
            searchAcc1();
 
        
    }//GEN-LAST:event_btnAccSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
     
        
            th.stop();
          int check = JOptionPane.showConfirmDialog(null, "Do you want to cancel?");
           
           if(check == 0){
               
               String Aid = tbAccNo.getText();
               String Aamount = tbCurrentAmount.getText();
               String Bid = tbTransferAccNo.getText();
               String Bamount = tbCurrentAmount1.getText();
            
                float MinValue = Float.parseFloat(Aamount);
                float AddValue = Float.parseFloat(Bamount);
                
                try {
                   
                   String sql = "UPDATE tblSavingAccount SET Amount='"+MinValue+"' WHERE Account_No='"+Aid+"' ";
                   String SQL2 = "UPDATE tblSavingAccount SET Amount='"+AddValue+"' WHERE Account_No='"+Bid+"'";
                   pst = conn.prepareStatement(sql);
                   pst2 =conn.prepareStatement(SQL2);
                   pst.execute();
                   pst2.execute();
                   JOptionPane.showMessageDialog(null, "Tranfaction Canceled!");
                    ProgressBar.setValue(0);
                    
        
                   
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
               }
                clear();
                lblProgress.setText("");
                btnCancel.enable(false);
                btnCancel.hide();
             
               
               
               
           }

        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tbTransferUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTransferUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTransferUserNameActionPerformed

    private void tbCurrentAmount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCurrentAmount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCurrentAmount1ActionPerformed

    private void btnTransfer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransfer1ActionPerformed
         
          String fill=tbTransferAmount.getText();
          if(fill.equals("")){
              JOptionPane.showMessageDialog(null, "Please Enter Amount you want to Transfer!");
          }
          else{
                int check = JOptionPane.showConfirmDialog(null, "Are you sure?");
           
           if(check == 0){
               String date = lblDate.getText();
               String time = lblTime.getText();
               String Aid = tbAccNo.getText();
               String AUname = tbAccUserName.getText();
               String Aamount = tbCurrentAmount.getText();
               String Bid = tbTransferAccNo.getText();
               String BUname = tbTransferUserName.getText();
               String Bamount = tbCurrentAmount1.getText();
               String Tamount = tbTransferAmount.getText();
                float MinValue = Float.parseFloat(Aamount)-Float.parseFloat(Tamount);
                float AddValue = Float.parseFloat(Bamount)+Float.parseFloat(Tamount);
               
                if(Float.parseFloat(Aamount)<= Float.parseFloat(Tamount) && Float.parseFloat(Aamount) <= 1500 && Float.parseFloat(Tamount) - Float.parseFloat(Aamount) <=1500 ){
                    
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                
                }
                else{
                    
                    try {
                   
                   String sql = "UPDATE tblSavingAccount SET Amount='"+MinValue+"' WHERE Account_No='"+Aid+"' ";
                   String SQL2 = "UPDATE tblSavingAccount SET Amount='"+AddValue+"' WHERE Account_No='"+Bid+"'";
                   String SQL3 = "UPDATE tblClient SET Amount='"+MinValue+"' WHERE Account_No='"+Aid+"' ";
                   String SQL4 = "UPDATE tblClient SET Amount='"+AddValue+"' WHERE Account_No='"+Bid+"'";
                   String SQL5 ="INSERT INTO tblMoneyTransfer (Date,Time,From_Acc,From_User_Name,FBefore_Amount,To_Acc,To_User_Name,TBefore_Amount,Transfered_Amount) VALUES ('"+date+"','"+time+"','"+Aid+"','"+AUname+"','"+Aamount+"','"+Bid+"','"+BUname+"','"+Bamount+"','"+Tamount+"')";
                   pst = conn.prepareStatement(sql);
                   pst2 =conn.prepareStatement(SQL2);
                   pst3 = conn.prepareStatement(SQL3);
                   pst4 = conn.prepareStatement(SQL4);
                   pst5 = conn.prepareStatement(SQL5);
                   pst.execute();
                   pst2.execute();
                   pst3.execute();
                   pst4.execute();
                   pst5.execute();
                   ProgressBar.show();
                   lblProgress.setText("Progressing....");
                   th = new progressThread(ProgressBar);
                   th.start();
                   btnCancel.show();
                   btnCancel.enable();
                   tbAccNo.setEditable(false);
                   tbTransferAccNo.setEditable(false);
                   
                   
                   
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
               }
                }
           
               
               
               
           }
          }
      
    }//GEN-LAST:event_btnTransfer1ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        Transfactiondetails TD = new Transfactiondetails();
        TD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        Transfactiondetails TD = new Transfactiondetails();
        TD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        int check = JOptionPane.showConfirmDialog(null, "Do you want to Log Out?");

        if (check == 0){
            Login log = new Login();
            log.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked

        Home hm = new Home();
        hm.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        status = "Employee";
        Home hm = new Home();
        hm.user();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel18ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18ComponentMoved

    private void lblBankAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBankAccountsMouseClicked
        AccountTypeDetails ATD = new AccountTypeDetails();
        ATD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBankAccountsMouseClicked

    private void lblUserAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblUserAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserAncestorAdded

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserMouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        MoneyTransfer MT = new MoneyTransfer();
        MT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        MoneyTransfer MT = new MoneyTransfer();
        MT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        DepositDetails DD = new DepositDetails();
        DD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        DepositDetails DD = new DepositDetails();
        DD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        Deposit DP = new Deposit();
        DP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        Deposit DP = new Deposit();
        DP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void lblReportAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblReportAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReportAncestorAdded

    private void lblReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseClicked
        Reports rp = new Reports();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblReportMouseClicked

    private void lblHelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblHelpAncestorAdded

    }//GEN-LAST:event_lblHelpAncestorAdded

    private void lblHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHelpMouseClicked
        Help hp =new Help();
        hp.setVisible(true);
    }//GEN-LAST:event_lblHelpMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Reports rpts = new Reports();
        rpts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuExitActionPerformed
        int ex =JOptionPane.showConfirmDialog(null, "Do you wan to Exit?");
        if (ex == 0){
            this.dispose();
        }

    }//GEN-LAST:event_JMenuExitActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        AboutBank AB = new AboutBank();
        AB.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Help hp =  new Help();
        hp.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(MoneyTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoneyTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoneyTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoneyTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoneyTransfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuExit;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton btnAccSearch;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnTransSearch;
    private javax.swing.JButton btnTransfer1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblBankAccounts;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblTime;
    public static javax.swing.JLabel lblUser;
    private javax.swing.JTextField tbAccNo;
    private javax.swing.JTextField tbAccUserName;
    private javax.swing.JTextField tbCurrentAmount;
    private javax.swing.JTextField tbCurrentAmount1;
    private javax.swing.JTextField tbTransferAccNo;
    private javax.swing.JTextField tbTransferAmount;
    private javax.swing.JTextField tbTransferUserName;
    // End of variables declaration//GEN-END:variables
}
