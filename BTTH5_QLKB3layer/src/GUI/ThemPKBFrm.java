/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import BLL.*;
import DTO.*;
import DAL.*;
import Utils.DBUtils;
import java.sql.*;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Vivobook
 */
public class ThemPKBFrm extends javax.swing.JFrame {

    /**
     * Creates new form ThemPKBFrm
     */
    public ThemPKBFrm() {
        initComponents();
        setTitle("Đặt lịch khám");
        setSize(400, 350);
        Date date = new Date();
        datNgKham.setDate(date);
        txtTenBN.setEditable(false);
        LoadCbbTenBS();
        setVisible(true);
    }

    ArrayList<String> ListMaBS = new ArrayList<String>();
    ArrayList<String> ListTenBS = new ArrayList<String>();
    public void LoadCbbTenBS(){
        // Lấy dữ liệu 
        try{
            ArrayList<bacsiDTO> arr = new ArrayList<bacsiDTO>();
            bacsiBLL bsBLL = new bacsiBLL();
            arr = bsBLL.getAllbacsi();
            
            bacsiDTO bs = new bacsiDTO();
            for (int i = 0; i < arr.size(); i++) {
                bs = arr.get(i);
                ListMaBS.add(bs.getMaBS());
                ListTenBS.add(bs.getTenBS());
            }
            
            cbbTenBS.setModel(new DefaultComboBoxModel<String>(ListTenBS.toArray(new String[0])));
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Lỗi");
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

        lblMaBN = new javax.swing.JLabel();
        lblTenBN = new javax.swing.JLabel();
        lblNgKham = new javax.swing.JLabel();
        lblYeuCauKham = new javax.swing.JLabel();
        lblTenBS = new javax.swing.JLabel();
        txtMaBN = new javax.swing.JTextField();
        txtTenBN = new javax.swing.JTextField();
        txtYeuCauKham = new javax.swing.JTextField();
        datNgKham = new com.toedter.calendar.JDateChooser();
        cbbTenBS = new javax.swing.JComboBox<>();
        btnDatLichKham = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMaBN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaBN.setText("Mã bệnh nhân");

        lblTenBN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenBN.setText("Tên bệnh nhân");

        lblNgKham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNgKham.setText("Ngày khám");

        lblYeuCauKham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblYeuCauKham.setText("Yêu cầu khám");

        lblTenBS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenBS.setText("Bác sĩ khám");

        txtMaBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBNActionPerformed(evt);
            }
        });

        cbbTenBS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbTenBS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDatLichKham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatLichKham.setText("Đặt lịch khám");
        btnDatLichKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLichKhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTenBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTenBN, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(lblNgKham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblYeuCauKham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaBN)
                            .addComponent(txtTenBN)
                            .addComponent(datNgKham, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txtYeuCauKham)
                            .addComponent(cbbTenBS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnDatLichKham, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaBN)
                    .addComponent(txtMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenBN)
                    .addComponent(txtTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgKham)
                    .addComponent(datNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYeuCauKham)
                    .addComponent(txtYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenBS)
                    .addComponent(cbbTenBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDatLichKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBNActionPerformed
        // TODO add your handling code here:
        DBUtils dbu = new DBUtils();
        Connection con = dbu.createConn();
        
        String strSQL = "SELECT * FROM BENHNHAN WHERE MABN = '"+txtMaBN.getText()+"'";
        try {
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery(strSQL);
            
            if(rs.first() == false) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                txtTenBN.setText("");
                txtMaBN.setText("");
            }
            else {
                txtTenBN.setText(rs.getString("TenBN"));
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi");
        }
    }//GEN-LAST:event_txtMaBNActionPerformed

    public String LayMaKB() {
        String MaKB = "";
        DBUtils dbu = new DBUtils();
        Connection con = dbu.createConn();
        
        String strSQL = "SELECT MaKB FROM KHAMBENH order by MaKB DESC";
        try {
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery(strSQL);
            if (rs.absolute(1) == false) {
                MaKB="KB0001";
            }
            else {
                String MaKBHienTai = rs.getString("MaKB");
                MaKB = MaKBHienTai.substring(2,6);
                int MaKBmoi = Integer.parseInt(MaKB) + 1;
                
                if (MaKBmoi < 10)
                    MaKB = "KB000"+MaKBmoi;
                else 
                    if (MaKBmoi < 100)
                        MaKB = "KB00"+MaKBmoi;
                    else
                        if (MaKBmoi < 1000)
                            MaKB = "KB0"+MaKBmoi;
                        else
                            MaKB = "KB"+MaKBmoi;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi");
        }
        return MaKB;
    }
    private void btnDatLichKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLichKhamActionPerformed
        // TODO add your handling code here:
        if (txtMaBN.getText().equals("") || txtYeuCauKham.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            Date nowdate = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            if (df.format(nowdate).compareTo(df.format(datNgKham.getDate())) > 0)
                JOptionPane.showMessageDialog(null, "Ngày khám phải >= Ngày hiện tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            else {                
                try {
                    khambenhDTO kbDTO = new khambenhDTO();
                    
                    kbDTO.setMaKB(LayMaKB());
                    kbDTO.setMaBN(txtMaBN.getText());
                    kbDTO.setMaBS(ListMaBS.get(cbbTenBS.getSelectedIndex()));
                    kbDTO.setNgayKham(df.format(datNgKham.getDate()));
                    kbDTO.setYeuCauKham(txtYeuCauKham.getText());
                    
                    khambenhBLL kbBLL = new khambenhBLL();
                    try {
                        int result = kbBLL.insertkhambenh(kbDTO);
                        if (result != 0) { //nếu thành công
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Lỗi");
                    JOptionPane.showMessageDialog(null, "Thêm dữ liệu KHÔNG thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDatLichKhamActionPerformed

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
            java.util.logging.Logger.getLogger(ThemPKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemPKBFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLichKham;
    private javax.swing.JComboBox<String> cbbTenBS;
    private com.toedter.calendar.JDateChooser datNgKham;
    private javax.swing.JLabel lblMaBN;
    private javax.swing.JLabel lblNgKham;
    private javax.swing.JLabel lblTenBN;
    private javax.swing.JLabel lblTenBS;
    private javax.swing.JLabel lblYeuCauKham;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtTenBN;
    private javax.swing.JTextField txtYeuCauKham;
    // End of variables declaration//GEN-END:variables
}
