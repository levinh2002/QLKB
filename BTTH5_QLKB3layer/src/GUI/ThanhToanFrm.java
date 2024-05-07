/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.*;
import DTO.*;
import Utils.*;
import java.sql.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Vivobook
 */
public class ThanhToanFrm extends javax.swing.JFrame {

    /**
     * Creates new form ThanhToanFrm
     */
    public ThanhToanFrm() {
        initComponents();
        setTitle("Thanh toán khám bệnh");
        setSize(610, 450);
        Date date = new Date();
        datNgKham.setDate(date);
        txtTenBN.setEditable(false);
        txtKetLuan.setEditable(false);
        txtYeuCauKham.setEditable(false);
        txtTongTien.setEditable(false);
        tblDV.setEnabled(false);
        btnThanhToan.setEnabled(false);
        LoadTableDV();
        setVisible(true);
    }
    
    private String MaKB;
    
    DefaultTableModel tblModelDV;
    public void LoadTableDV(){
        tblModelDV = new DefaultTableModel();
        String tieude[] = {"Mã DV", "Tên DV", "Số lượng", "Thành tiền"};
        tblModelDV.setColumnIdentifiers(tieude);
        
        tblDV.setModel(tblModelDV);
        setVisible(true);
    }
    
    public void LoadData() {
//        if (txtMaBN.getText().equals("") || datNgKham.getDate().equals(""))
//            JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã bệnh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        else {
//            LoadTableDV();
//            txtYeuCauKham.setText("");
//            txtKetLuan.setText("");
//            txtTongTien.setText("0");
//            ckbThanhToan.setEnabled(true);
//            ckbThanhToan.setSelected(false);
//            btnThanhToan.setEnabled(false);
//            
//            try{
//                ArrayList<khambenhDTO> arr = new ArrayList<khambenhDTO>();
//                khambenhBLL kbBLL = new khambenhBLL();
//                                
//                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//                arr = kbBLL.getkhambenh2(txtMaBN.getText(), df.format(datNgKham.getDate()));
//                
//                if (arr.size() != 0){
//                    khambenhDTO kbDTO = arr.get(0);
//                    MaKB = kbDTO.getMaKB();
//                    txtYeuCauKham.setText(kbDTO.getYeuCauKham());
//                    txtKetLuan.setText(kbDTO.getKetLuan());
//                    String ThanhToan = kbDTO.getThanhToan();
//                    ckbThanhToan.setSelected(ThanhToan.equals(""));
//                    
//                    if (ThanhToan.equals("") == true) {
//                        ckbThanhToan.setEnabled(false);
//                        btnThanhToan.setEnabled(false);
//                    }
//                    else btnThanhToan.setEnabled(true);
//                    
//                    ArrayList<thuphiDTO> tparr = new ArrayList<thuphiDTO>();
//                    thuphiBLL tpBLL = new thuphiBLL();
//                    tparr = tpBLL.getThuPhi(MaKB);
//                    
//                    int TongTien = 0;
//                    for (int i = 0; i < tparr.size(); i++) {
//                        thuphiDTO tpDTO = tparr.get(i);
//                        String[] row = new String[4];
//                        row[0] = tpDTO.getMaDV();
//                        row[1] = tpDTO.getTenDV();
//                        row[2] = tpDTO.getSoLuong();
//                        row[3] = tpDTO.getThanhTien();
//                        tblModelDV.addRow(row);
//                        
//                        TongTien += Integer.parseInt(tpDTO.getThanhTien());
//                    }
//                    txtTongTien.setText(String.valueOf(TongTien));
//                }
//                
//                
//            } catch (Exception e) {
//                System.out.println(e);
//                System.out.println("Lỗi");
//            }
//        }
        
/////////////////////////

        if (txtMaBN.getText().equals("") || datNgKham.getDate().equals(""))
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã bệnh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else {
            LoadTableDV();
            txtYeuCauKham.setText("");
            txtKetLuan.setText("");
            txtTongTien.setText("0");
            ckbThanhToan.setEnabled(true);
            ckbThanhToan.setSelected(false);
            btnThanhToan.setEnabled(false);
            
            DBUtils dbu = new DBUtils();
            Connection con = dbu.createConn();
            try{
                String strSQL = "Select * from KHAMBENH WHERE MABN=? AND NGAYKHAM=?";
                PreparedStatement pres = con.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
                
                pres.setString(1, txtMaBN.getText());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                pres.setString(2, df.format(datNgKham.getDate()));
                
                ResultSet rs = pres.executeQuery();
                
                if (rs.next() == true){
                    rs.absolute(1);
                    
                    MaKB = rs.getString("MaKB");
                    txtYeuCauKham.setText(rs.getString("YeuCauKham"));
                    txtKetLuan.setText(rs.getString("KetLuan"));
                    boolean ThanhToan = rs.getBoolean("ThanhToan");
                    ckbThanhToan.setSelected(ThanhToan);
                    
                    if (ThanhToan == true) {
                        ckbThanhToan.setEnabled(false);
                        btnThanhToan.setEnabled(false);
                    }
                    else btnThanhToan.setEnabled(true);
                    
                    //Load tableDV và tính tổng tiền
                    strSQL = "Select * from THUPHI, DICHVU WHERE THUPHI.MADV = DICHVU.MADV AND MAKB = ?";
                    pres = con.prepareStatement(strSQL);
                    pres.setString(1, MaKB);
                    
                    rs = pres.executeQuery();
                    int TongTien = 0;
                    
                    while (rs.next()){
                        String[] row = new String[4];
                        row[0] = rs.getString("ThuPhi.MaDV");
                        row[1] = rs.getString("TenDV");
                        row[2] = rs.getString("SoLuong");
                        row[3] = rs.getString("ThanhTien");
                        tblModelDV.addRow(row);
                        TongTien = TongTien + rs.getInt("ThanhTien");
                    }
                    txtTongTien.setText(String.valueOf(TongTien));
                }
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("Lỗi");
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaBN = new javax.swing.JTextField();
        txtTenBN = new javax.swing.JTextField();
        txtKetLuan = new javax.swing.JTextField();
        datNgKham = new com.toedter.calendar.JDateChooser();
        txtYeuCauKham = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ckbThanhToan = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDV = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã bệnh nhân");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên bệnh nhân");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Kết luận");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày khám");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Yêu cầu khám");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tổng tiền");

        txtMaBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBNActionPerformed(evt);
            }
        });

        datNgKham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datNgKhamPropertyChange(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Danh sách dịch vụ đã khám");

        ckbThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ckbThanhToan.setText("Đã thanh toán");

        tblDV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDV);

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(datNgKham, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(txtYeuCauKham)
                                    .addComponent(txtTongTien)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(ckbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(datNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ckbThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBNActionPerformed
        // TODO add your handling code here:
//        try{
//            benhnhanBLL bnBLL = new benhnhanBLL();// Lỗi
//            benhnhanDTO bnDTO = bnBLL.getbenhnhan2(txtMaBN.getText());
//            if (bnDTO.getTenBN().equals("") == true){
//                JOptionPane.showMessageDialog(null, "Không tìm thấy bênh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                txtTenBN.setText("");
//                txtMaBN.setText("");
//            }
//            else {
//                txtTenBN.setText(bnDTO.getTenBN());
//                LoadData();
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println("Lỗi");
//        }

/////////////////////

        DBUtils dbu = new DBUtils();
        Connection con = dbu.createConn();
        String strSQL = "SELECT * FROM BENHNHAN WHERE MABN = ?";
        try{
                PreparedStatement pres = con.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
                pres.setString(1, txtMaBN.getText());
                ResultSet rs = pres.executeQuery();
                
                if (rs.absolute(1) == false) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy bênh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtTenBN.setText("");
                    txtMaBN.setText("");
                }
                else {
                    txtTenBN.setText(rs.getString("TenBN"));
                    LoadData();
                }
                con.close();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Lỗi");
            }
    }//GEN-LAST:event_txtMaBNActionPerformed

    private void datNgKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datNgKhamPropertyChange
        // TODO add your handling code here:
        if (txtMaBN.getText().equals("")==false)
            LoadData();
    }//GEN-LAST:event_datNgKhamPropertyChange

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        try {
            DBUtils dbu = new DBUtils();
            Connection con = dbu.createConn();
            String strUpdate = "Update KHAMBENH set ThanhToan = true where MaKB = ?";
            PreparedStatement pres = con.prepareStatement(strUpdate);
            pres.setString(1, MaKB);
            pres.execute();
            
            JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Lỗi");
            JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu KHÔNG thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThanhToanFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JCheckBox ckbThanhToan;
    private com.toedter.calendar.JDateChooser datNgKham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDV;
    private javax.swing.JTextField txtKetLuan;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtTenBN;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtYeuCauKham;
    // End of variables declaration//GEN-END:variables
}
