/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lastprojectpbo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;



/**
 *
 * @author Rafli Dika
 * Kelas Login untuk menangani proses masuk pengguna ke dalam sistem.
 * Menyediakan fungsi untuk mengambil input pengguna dan kata sandi,
 * serta memvalidasi kredensial terhadap database.
 * Menampilkan tampilan utama aplikasi setelah pengguna berhasil login.
 * Mengarahkan pengguna ke form Signup jika belum memiliki akun.
 * Memiliki mekanisme untuk menampilkan dan menyembunyikan kata sandi.
 * 
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    private String username;
    private String password;
    
    
    /**
     * Membuat form Login baru.
     */
    public Login() {
        initComponents();
        hidePW.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textPengguna = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        showPW = new javax.swing.JLabel();
        hidePW = new javax.swing.JLabel();
        passwordPengguna = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        buttonSignup = new javax.swing.JButton();
        buttonLogin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastprojectpbo/img/hotelBG.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 579));

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 117, -1));

        textPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPenggunaActionPerformed(evt);
            }
        });
        jPanel1.add(textPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 176, -1));

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 80, -1));

        showPW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastprojectpbo/img/eye.png"))); // NOI18N
        showPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPWMouseClicked(evt);
            }
        });
        jPanel1.add(showPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 30, 20));

        hidePW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastprojectpbo/img/hidden.png"))); // NOI18N
        hidePW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePWMouseClicked(evt);
            }
        });
        jPanel1.add(hidePW, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 30, 20));

        passwordPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordPenggunaActionPerformed(evt);
            }
        });
        jPanel1.add(passwordPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 181, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Don't have an account yet?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        buttonSignup.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        buttonSignup.setText("Sign up!");
        buttonSignup.setToolTipText("");
        buttonSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSignupActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        buttonLogin.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        buttonLogin.setText("Login!");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("HOTEL LAVIEN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 150, -1));

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Welcome");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 150, 20));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, -10, 410, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Mengambil teks dari kolom pengguna.
     * 
     * @return Teks yang diinputkan pada kolom pengguna.
     */
    
    public String getTextPengguna() {
        return textPengguna.getText();
    }

    /**
     * Mengatur teks untuk kolom pengguna.
     * 
     * @param username Teks yang akan diatur untuk kolom pengguna.
     */
    
    public void setUsername(String username) {
        this.username = username;
        textPengguna.setText(username);
    }
    
    /**
     * Mengambil kata sandi dari kolom kata sandi pengguna.
     * 
     * @return Kata sandi yang diinputkan pada kolom kata sandi pengguna.
     */
    
    public String getPasswordPengguna() {
        return new String(passwordPengguna.getPassword());
    }

    /**
     * Mengatur kata sandi untuk kolom kata sandi pengguna.
     * 
     * @param password Kata sandi yang akan diatur untuk kolom kata sandi pengguna.
     */
    
    public void setPassword(String password) {
        this.password = password;
        passwordPengguna.setText(password);
    }

    /**
     * Menangani aksi ketika tombol Login ditekan.
     * Memvalidasi input pengguna dan kata sandi, dan mengecek kredensial terhadap database.
     * Mengarahkan pengguna ke halaman utama sesuai dengan peran (admin atau pengguna biasa) jika login berhasil.
     * Menampilkan pesan kesalahan jika kredensial tidak cocok.
     * 
     * @param evt Peristiwa yang memicu metode ini.
     */
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        if(getTextPengguna().isEmpty() && getPasswordPengguna().isEmpty()){
            JOptionPane.showMessageDialog(this, "Isi Pengguna dan Password Terlebih Dahulu!", "Form Tidak Boleh Kosong", JOptionPane.WARNING_MESSAGE);
        }else if(getPasswordPengguna().isEmpty()){
            JOptionPane.showMessageDialog(this, "Masukkan Password Terlebih Dahulu", "Form Password Tidak Boleh Kosong", JOptionPane.WARNING_MESSAGE);
        }else if(getTextPengguna().isEmpty()){
            JOptionPane.showMessageDialog(this, "Isi Pengguna Terlebih Dahulu!", "Form Pengguna Tidak Boleh Kosong", JOptionPane.WARNING_MESSAGE);

        }
        try{
            String username = textPengguna.getText();
            String password = passwordPengguna.getText();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservasi_hotel", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
            if(rs.next()){
                String role = rs.getString("role");
            
            if("admin".equals(role)){
                JOptionPane.showMessageDialog(this, "Login Berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                frameAdmin frameAdmin = new frameAdmin(); // Sesuaikan dengan nama kelas frame Admin Anda
                frameAdmin.loadData();
                frameAdmin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login Berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                MainPage_1 mainPage = new MainPage_1();
                mainPage.setVisible(true);
            }
                
            }else {
                JOptionPane.showMessageDialog(this, "Kombinasi Pengguna dan Kata Sandi tidak cocok.", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }//GEN-LAST:event_buttonLoginActionPerformed
/**
     * Menangani aksi ketika tombol Signup ditekan.
     * Mengarahkan pengguna ke form Signup.
     * 
     * @param evt Peristiwa yang memicu metode ini.
     */
    private void buttonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSignupActionPerformed

        this.dispose();
        Signup daftar = new Signup();
        daftar.setVisible(true);
    }//GEN-LAST:event_buttonSignupActionPerformed

    private void textPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPenggunaActionPerformed

    /**
     * Menangani aksi ketika ikon show password diklik.
     * Menampilkan karakter kata sandi di kolom kata sandi.
     * 
     * @param evt Peristiwa yang memicu metode ini.
     */
    private void showPWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPWMouseClicked
        // TODO add your handling code here:
        showPW.setVisible(false);
        hidePW.setVisible(true);
        passwordPengguna.setEchoChar((char)0);
    }//GEN-LAST:event_showPWMouseClicked

    private void hidePWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePWMouseClicked
        // TODO add your handling code here:
        showPW.setVisible(true);
        hidePW.setVisible(false);
        passwordPengguna.setEchoChar('*');
    }//GEN-LAST:event_hidePWMouseClicked

    private void passwordPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordPenggunaActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonSignup;
    private javax.swing.JLabel hidePW;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordPengguna;
    private javax.swing.JLabel showPW;
    private javax.swing.JTextField textPengguna;
    // End of variables declaration//GEN-END:variables
}
