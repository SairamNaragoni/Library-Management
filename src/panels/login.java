package panels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





/**
 *
 * @author Sairam
 */
public class login extends javax.swing.JPanel {

    private JButton SignUpB;
    private JButton SignIn;
    private JButton Profile;
    private JButton SignOutB;
    private login signin;
    private gVar g;
    private JButton Admin;
    private home home;
    private JPanel curr;

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    public login(JButton SignUpB,JButton SignIn,JButton Profile,JButton SignOutB,gVar g,JButton Admin,home home,JPanel curr) {
         //To change body of generated methods, choose Tools | Templates.
         initComponents();
         this.SignUpB = SignUpB;
         this.SignIn = SignIn;
         this.Profile = Profile;
         this.SignOutB = SignOutB;
         this.g = g;
         this.Admin = Admin;
         this.home = home;
         this.curr = curr;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        SignInB = new javax.swing.JButton();
        SignInB1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(1, 27, 29));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(54, 72, 107));

        jLabel1.setBackground(new java.awt.Color(1, 45, 60));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username :");
        jLabel1.setAlignmentX(0.5F);

        jLabel2.setBackground(new java.awt.Color(1, 45, 50));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        jLabel2.setAlignmentX(0.5F);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        SignInB.setText("Sign In");
        SignInB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInBActionPerformed(evt);
            }
        });

        SignInB1.setText("Sign Up");
        SignInB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInB1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SignInB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(SignInB1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(username)
                    .addComponent(password))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SignInB)
                    .addComponent(SignInB1))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        //jLabel1.setOpaque(true);
        //jLabel2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void SignInBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInBActionPerformed
        try {
            // TODO add your handling code here:
            String uname = (String)username.getText();
            String pass = password.getText();
            dbConn db = new dbConn();
            Statement stmt = db.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(*) from users where username = '"+uname+"'" );
            rs.next();
            int count = rs.getInt(1);
            if(count == 0 )
            {
                JOptionPane.showMessageDialog(new JFrame(), "Invalid Username","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               rs = stmt.executeQuery("select * from users where username = '"+uname+"'" );
               rs.next();
               String dbpass = rs.getString("password");
               //System.out.println(dbpass + " nd " + pass);
               if(dbpass.equals(pass))
               {
                    JOptionPane.showMessageDialog(new JFrame(), "Login Successful","Success",JOptionPane.INFORMATION_MESSAGE);
                    g.user_id = rs.getInt("id");
                    g.admin = rs.getInt("admin");
                    updateInfo();
               }                               
               else
               {
                   JOptionPane.showMessageDialog(new JFrame(), "Invalid Password","Error",JOptionPane.ERROR_MESSAGE);
               }
                   
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_SignInBActionPerformed

    private void SignInB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInB1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String uname = (String)username.getText();
            String pass = password.getText();
            dbConn db = new dbConn();
            Statement stmt = db.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(*) from users where username = '"+uname+"'" );
            rs.next();
            int count = rs.getInt(1);
            if(count != 0 )
            {
                JOptionPane.showMessageDialog(new JFrame(), "Username Already Exists,Try Again With Another Username","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String sql = "INSERT INTO users (username,password) values ('"+uname+"','"+pass+"')";
                PreparedStatement pStmt = db.conn.prepareStatement(sql);
                pStmt.execute();
                JOptionPane.showMessageDialog(new JFrame(), "Sign UP Successful","Success",JOptionPane.INFORMATION_MESSAGE);
                rs = stmt.executeQuery("select * from users where username = '"+uname+"'");
                rs.next();
                g.user_id = rs.getInt("id");
                updateInfo();         
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        SignUpB.setVisible(false);
    }//GEN-LAST:event_SignInB1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignInB;
    private javax.swing.JButton SignInB1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private void updateInfo() {
       SignUpB.setVisible(false);
       SignIn.setVisible(false);
       SignOutB.setVisible(true);
       this.setVisible(false);
       Profile.setVisible(true);
       home.setVisible(true);
       curr = home;
       if(g.admin==1)
           Admin.setVisible(true);
    }
}