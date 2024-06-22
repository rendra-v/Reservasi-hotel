/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lastprojectpbo;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.beans.*;
/**
 *
 * @author ShiroKo'
 */
public class checkOut extends javax.swing.JFrame {

    /**
     * Creates new form checkOut
     */
    private Connection conn = null;
    private static final int HARGA_PER_MALAM = 300000;
    
    public checkOut() {
        initComponents();
        kamarTersedia.setSelectedIndex(0);
        addDateChooserListener();
    }
    
    private Connection connect() {
        // URL koneksi ke database
        String url = "jdbc:mysql://localhost:3306/reservasi_hotel";
        String user = "root";
        String password = "";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
        }
    
    private void addDateChooserListener() {
        tglCheckIn.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date selectedDate = tglCheckIn.getDate();
                    Date currentDate = new Date();

                    if (selectedDate != null) {
                        LocalDate currentLocalDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                        if (selectedLocalDate.isBefore(currentLocalDate)) {
                            JOptionPane.showMessageDialog(checkOut.this,
                                    "Tanggal Check-in tidak boleh sebelum hari ini!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            
                            tglCheckIn.setDate(currentDate);
                        }
                    }
                }
            }
        });
    }
    
    public boolean jikaRuanganTersedia(int room_id, Date tgl_checkIn, Date tgl_checkOut){
        String query = "SELECT COUNT(*) FROM booking WHERE room_id = ? AND (? < tgl_checkOut AND ? > tgl_checkIn)";
        try (Connection conn = connect(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, room_id);
            statement.setDate(2, new java.sql.Date(tgl_checkIn.getTime()));
            statement.setDate(3, new java.sql.Date(tgl_checkOut.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void bookingRoom(int room_id, Date tgl_checkIn, Date tgl_checkOut){
        LocalDate checkInDate = tglCheckIn.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate checkOutDate = tglCheckOut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long jumlahMalam = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        long totalHarga = jumlahMalam * HARGA_PER_MALAM;
        
        if (jikaRuanganTersedia(room_id, tgl_checkIn, tgl_checkOut)) {
            String insertQuery = "INSERT INTO booking (room_id, nama, alamat, no_Telpon, tgl_checkIn, tgl_checkOut) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = connect(); PreparedStatement statement = conn.prepareStatement(insertQuery)) {
                statement.setInt(1, room_id);
                statement.setString(2, namaBooking.getText());
                statement.setString(3, alamatBooking.getText());
                statement.setString(4, noTelpBooking.getText());
                statement.setDate(5, new java.sql.Date(tgl_checkIn.getTime()));
                statement.setDate(6, new java.sql.Date(tgl_checkOut.getTime()));
                statement.executeUpdate();
                Struk struk = new Struk(namaBooking.getText(), alamatBooking.getText(), noTelpBooking.getText(), tglCheckIn.getDate(), tglCheckOut.getDate(), kamarTersedia.getSelectedItem().toString(), jumlahMalam, totalHarga);                  
                struk.setVisible(true);
                dispose();
                JOptionPane.showMessageDialog(this, "Ruangan telah di Booking!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
            
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Booking GAGAL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ruangan telah di Booking user lain", "Tidak Tersedia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    
    public void resetForm(){
        namaBooking.setText("");
        alamatBooking.setText("");
        noTelpBooking.setText("");
        tglCheckIn.setDate(null);
        tglCheckOut.setDate(null);
        kamarTersedia.setSelectedItem("Pilih Kamar Standar");
        
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
        namaBooking = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        alamatBooking = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        noTelpBooking = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tglCheckIn = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        tglCheckOut = new com.toedter.calendar.JDateChooser();
        kamarTersedia = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastprojectpbo/img/stdKmr.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setText("Nama:");

        namaBooking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaBookingKeyPressed(evt);
            }
        });

        jLabel3.setText("Alamat:");

        alamatBooking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alamatBookingKeyPressed(evt);
            }
        });

        jLabel4.setText("No.Telp:");

        noTelpBooking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noTelpBookingKeyPressed(evt);
            }
        });

        jLabel5.setText("Tgl Check In:");

        jLabel6.setText("Tgl Check Out:");

        kamarTersedia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kamar yang ada di Standar:", "Kamar STD 01", "Kamar STD 02", "Kamar STD 03", "Kamar STD 04", "Kamar STD 05" }));
        kamarTersedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kamarTersediaActionPerformed(evt);
            }
        });

        jButton1.setText("Booking Sekarang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Kembali");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton1)
                        .addGap(93, 93, 93)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(namaBooking)
                                            .addComponent(alamatBooking, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(noTelpBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tglCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kamarTersedia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tglCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(namaBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(alamatBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(noTelpBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(tglCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(tglCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(kamarTersedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date checkIn = tglCheckIn.getDate();
        Date checkOut = tglCheckOut.getDate();
        String nama = namaBooking.getText();
        String alamat = alamatBooking.getText();
        String noTelp = noTelpBooking.getText();
        String selectedRoom = (String) kamarTersedia.getSelectedItem();
        int room_id = getRoomIdFromName(selectedRoom);

        if (nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty() || checkIn == null || checkOut == null) {
            JOptionPane.showMessageDialog(this, "Isi Semua Data Yang Ada Disini!", "Form Tidak Boleh Kosong", JOptionPane.WARNING_MESSAGE);
        } else if (checkOut.before(checkIn)) {
            JOptionPane.showMessageDialog(this, "Tanggal Check-Out tidak boleh sebelum Tanggal Check-In!", "Tanggal Tidak Valid", JOptionPane.WARNING_MESSAGE);
        } else if (kamarTersedia.getSelectedItem().toString().equals("Kamar yang ada di Standar:")) {
            JOptionPane.showMessageDialog(this, "Isi Pilihan Kamar Terlebih Dahulu!", "Form Tidak Boleh Kosong", JOptionPane.WARNING_MESSAGE);
        }else {
            bookingRoom(room_id, checkIn, checkOut);  
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed
private int getRoomIdFromName(String roomName) {
        switch (roomName) {
            case "Kamar STD 01":
                return 1;
            case "Kamar STD 02":
                return 2;
            case "Kamar STD 03":
                return 3;
            case "Kamar STD 04":
                return 4;
            case "Kamar STD 05":
                return 5;
            default:
                return -1; // Jika tidak ditemukan, kembalikan nilai -1 sebagai error
        }
    }
    private void kamarTersediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kamarTersediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kamarTersediaActionPerformed

    private void namaBookingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaBookingKeyPressed
        // TODO add your handling code here:
        char nama = evt.getKeyChar();
        if(Character.isLetter(nama) || Character.isWhitespace(nama) ||  Character.isISOControl(nama)){
            namaBooking.setEditable(true);
        }else{
            namaBooking.setEditable(false);
        }
    }//GEN-LAST:event_namaBookingKeyPressed

    private void alamatBookingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatBookingKeyPressed
        // TODO add your handling code here
    }//GEN-LAST:event_alamatBookingKeyPressed

    private void noTelpBookingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noTelpBookingKeyPressed
        // TODO add your handling code here:
        char notel = evt.getKeyChar();
         if (!Character.isDigit(notel) && !Character.isISOControl(notel)) {
            noTelpBooking.setEditable(false);
        } else {
            noTelpBooking.setEditable(true);
        }
    }//GEN-LAST:event_noTelpBookingKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainPage_1 pg = new MainPage_1();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new checkOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatBooking;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> kamarTersedia;
    private javax.swing.JTextField namaBooking;
    private javax.swing.JTextField noTelpBooking;
    private com.toedter.calendar.JDateChooser tglCheckIn;
    private com.toedter.calendar.JDateChooser tglCheckOut;
    // End of variables declaration//GEN-END:variables
}
