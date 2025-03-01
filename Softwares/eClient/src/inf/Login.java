/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import codes.DBconnect;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Iroshan
 */
public class Login extends javax.swing.JFrame {
 Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    public Login() {
        initComponents();
        conn =DBconnect.connect();
       timeDate();
       setIcon();
    }
     public void timeDate(){
         
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lblDate.setText(sdf.format(d));
  
    
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
    
    
      public void login(){
          String id =tbClientID.getText();
          String pass = tbPass.getText();
          
          try {
              String sql = "SELECT * FROM tblClient WHERE Client_ID =? && Password=?";
              pst = conn.prepareStatement(sql);
              pst.setString(1, id);
              pst.setString(2, pass);
              rs =pst.executeQuery();
              
              
              if(id.equals("") || pass.equals("")){
                  JOptionPane.showMessageDialog(null, "Please Enter Your Details!");
              }
              else if(rs.next()){
                  Home hm = new Home();
                  hm.setVisible(true);
                  this.dispose();
              }
              else{
                  JOptionPane.showMessageDialog(null, "Access Denied!");
                  tbClientID.setText("");
                  tbPass.setText("");
              }
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
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

        tbClientID = new javax.swing.JTextField();
        tbPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHead = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblForgotPass = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(677, 635));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbClientID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbClientID.setToolTipText("Type you User Name");
        tbClientID.setName(""); // NOI18N
        tbClientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbClientIDActionPerformed(evt);
            }
        });
        getContentPane().add(tbClientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 200, 30));

        tbPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbPass.setToolTipText("Enter your Password");
        tbPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPassActionPerformed(evt);
            }
        });
        tbPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbPassKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbPassKeyTyped(evt);
            }
        });
        getContentPane().add(tbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 200, 30));

        btnLogin.setBackground(new java.awt.Color(204, 204, 204));
        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 51, 204));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 120, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Client ID : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Password : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        txtHead.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        txtHead.setForeground(new java.awt.Color(0, 51, 255));
        txtHead.setText("User Login");
        getContentPane().add(txtHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Date & Time :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-key-30.png"))); // NOI18N
        jLabel7.setText("   ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 30, -1));

        lblForgotPass.setBackground(new java.awt.Color(51, 51, 255));
        lblForgotPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblForgotPass.setForeground(new java.awt.Color(255, 255, 255));
        lblForgotPass.setText("Forgot Password ?");
        lblForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseClicked(evt);
            }
        });
        getContentPane().add(lblForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 120, 20));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/images ori.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, 230));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, 440));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-keepass-35.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/Japan finance.jpg"))); // NOI18N
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 640, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-merchant-account-100.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 200));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -10, 160, 160));

        lblTime.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 140, 50));

        lblDate.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 140, 50));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 48)); // NOI18N
        jLabel5.setText("e-Banking");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 320, 70));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 640));

        setSize(new java.awt.Dimension(693, 674));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbClientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbClientIDActionPerformed
       login();
    }//GEN-LAST:event_tbClientIDActionPerformed

    private void tbPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPassActionPerformed
       login();
    }//GEN-LAST:event_tbPassActionPerformed

    private void tbPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPassKeyPressed
        
    }//GEN-LAST:event_tbPassKeyPressed

    private void tbPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPassKeyTyped

    }//GEN-LAST:event_tbPassKeyTyped

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        login();
    }//GEN-LAST:event_btnLoginKeyPressed

    private void lblForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseClicked
        String Fid = tbClientID.getText();
        if(tbClientID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter your Client ID!");
        }
        else{
            try {
                String sql = "SELECT * FROM tblClient WHERE Client_ID =?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, Fid);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    ForgotPassword fp = new ForgotPassword();
                    fp.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Client ID!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
             
            
        }
        
       
    }//GEN-LAST:event_lblForgotPassMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblForgotPass;
    private javax.swing.JLabel lblTime;
    public static javax.swing.JTextField tbClientID;
    private javax.swing.JPasswordField tbPass;
    private javax.swing.JLabel txtHead;
    // End of variables declaration//GEN-END:variables
    public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons8-merchant-account-64 (1).png")));
    }
}
