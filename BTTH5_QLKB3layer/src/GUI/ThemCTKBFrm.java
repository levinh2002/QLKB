/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import BLL.*;
import DTO.*;
import Utils.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Vivobook
 */
public class ThemCTKBFrm extends javax.swing.JFrame {

    /**
     * Creates new form ThemCTKBFrm
     */
    public ThemCTKBFrm() {
        initComponents();
        setTitle("Khám bệnh");
        setSize(640, 450);
        Date date = new Date();
        datNgKham.setDate(date);
        txtYeuCauKham.setEditable(false);
        LoadCbbTenBS();
        LoadTableDV();
        LoadTableDVBSChon();
        LoadCbbTenBN();
        setVisible(true);
    }
    
    private String MaKB;
    ArrayList<String> ListMaBS = new ArrayList<String>();
    ArrayList<String> ListTenBS = new ArrayList<String>();
    public void LoadCbbTenBS() {
        ListMaBS.removeAll(ListMaBS);
        ListTenBS.removeAll(ListMaBS);
        txtYeuCauKham.setText("");
        
        try {
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
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Lỗi");
        }
    }
    
    DefaultTableModel tblModelDV;
    public void LoadTableDV(){
//        tblModelDV = new DefaultTableModel();
//        String tieude[] = {"Mã DV", "Tên DV", "Giá"};
//        tblModelDV.setColumnIdentifiers(tieude);
//
//        ArrayList<dichvuDTO> arr = new ArrayList<dichvuDTO>();
//        dichvuBLL dichvuBLL = new dichvuBLL();// Lỗi
//        arr = dichvuBLL.getAlldichvu();
//
//        dichvuDTO dichvuDTO = new dichvuDTO();
//        for (int i = 0; i < arr.size(); i++) {
//            dichvuDTO = arr.get(i);
//            String MaDV = dichvuDTO.getMaDV();
//            String TenDV = dichvuDTO.getTenDV();
//            String DonGia = dichvuDTO.getDonGia();
//            Object[] row = {MaDV, TenDV, DonGia};
//            tblModelDV.addRow(row);
//        }
//        
//        tblDV.setModel(tblModelDV);
//        setVisible(true);
        
        /////////
        tblModelDV = new DefaultTableModel();
        String tieude[] = {"Mã DV", "Tên DV", "Giá"};
        tblModelDV.setColumnIdentifiers(tieude);
        
        DBUtils dbu = new DBUtils();
        Connection con = dbu.createConn();
        
        try {
            String row[] = new String[3];
            String strSQL = "Select * from DICHVU";
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery(strSQL);
            while(rs.next()){
                row[0] = rs.getString("MaDV");
                row[1] = rs.getString("TenDV");
                row[2] = rs.getString("DonGia");
                tblModelDV.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Lỗi");
        }
        
        tblDV.setModel(tblModelDV);
        setVisible(true);
    }
    
    DefaultTableModel tblModelDVBSChon;
    public void LoadTableDVBSChon(){
        tblModelDVBSChon = new DefaultTableModel();
        
        String tieude[] = {"Mã DV", "Tên DV", "Đơn giá", "Số lượng"};
        tblModelDVBSChon.setColumnIdentifiers(tieude);
        tblDVBSChon.setModel(tblModelDVBSChon);
        setVisible(true);
    }
    
    ArrayList<String> ListMaBN = new ArrayList<String>();
    ArrayList<String> ListTenBN = new ArrayList<String>();
    public void LoadCbbTenBN() {
        ListMaBN.removeAll(ListMaBN);
        ListTenBN.removeAll(ListMaBN);
        txtYeuCauKham.setText("");

        try {
            
            String MaBS = ListMaBS.get(cbbTenBS.getSelectedIndex());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            String NgKham = df.format(datNgKham.getDate());
            
            ArrayList<benhnhanDTO> arr = new ArrayList<benhnhanDTO>();
            benhnhanBLL bnBLL = new benhnhanBLL();
            arr = bnBLL.getbenhnhan(MaBS, NgKham);
            
            benhnhanDTO bn = new benhnhanDTO();
            for (int i = 0; i < arr.size(); i++) {
                bn = arr.get(i);
                ListMaBN.add(bn.getMaBN());
                ListTenBN.add(bn.getTenBN());
            }

            cbbTenBN.setModel(new DefaultComboBoxModel<String>(ListTenBN.toArray(new String[0])));
        } catch (Exception e) {
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

        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbTenBS = new javax.swing.JComboBox<>();
        cbbTenBN = new javax.swing.JComboBox<>();
        txtKetLuan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datNgKham = new com.toedter.calendar.JDateChooser();
        txtYeuCauKham = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDVBSChon = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDV = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Bác sĩ khám");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên bệnh nhân");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Kết luận");

        cbbTenBS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTenBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenBSActionPerformed(evt);
            }
        });
        cbbTenBS.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbbTenBSPropertyChange(evt);
            }
        });

        cbbTenBN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTenBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenBNActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày khám");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Yêu cầu khám");

        datNgKham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datNgKhamPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Danh sách dịch vụ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Danh sách dịch vụ bác sĩ chọn");

        tblDVBSChon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDVBSChon);

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
        tblDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDV);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbTenBS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbTenBN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtYeuCauKham)
                            .addComponent(datNgKham, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbbTenBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(datNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(cbbTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTenBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenBSActionPerformed
        // TODO add your handling code here:
        LoadCbbTenBN();
        MaKB = null;
    }//GEN-LAST:event_cbbTenBSActionPerformed

    private void datNgKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datNgKhamPropertyChange
        // TODO add your handling code here:
        if(ListMaBS.size() > 0){
            LoadCbbTenBN();
            MaKB = null;
        }
    }//GEN-LAST:event_datNgKhamPropertyChange

    private void tblDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDVMouseClicked
        // TODO add your handling code here:
        int indexTB = tblDV.getSelectedRow();
        
        if(indexTB >=0 && indexTB <= tblModelDV.getRowCount()) {
            String row[] = new String[4];
            row[0] = tblModelDV.getValueAt(indexTB, 0).toString();
            row[1] = tblModelDV.getValueAt(indexTB, 1).toString();
            row[2] = tblModelDV.getValueAt(indexTB, 2).toString();
            row[3] = "1";
            tblModelDVBSChon.addRow(row);
            tblModelDV.removeRow(indexTB);
        }
    }//GEN-LAST:event_tblDVMouseClicked

    private void cbbTenBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenBNActionPerformed
        // TODO add your handling code here:
        txtYeuCauKham.setText("");
        
        if(cbbTenBN.getSelectedIndex() >=0){
            try{

                String MaBN = ListMaBN.get(cbbTenBN.getSelectedIndex());
                String MaBS = ListMaBS.get(cbbTenBS.getSelectedIndex());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
                String NgKham = df.format(datNgKham.getDate());
                
                System.out.println(ListMaBN.get(cbbTenBN.getSelectedIndex()));
                System.out.println(ListMaBS.get(cbbTenBS.getSelectedIndex()));
                System.out.println(df.format(datNgKham.getDate()));
                
                khambenhBLL kbBLL = new khambenhBLL();
                khambenhDTO kbDTO = kbBLL.getkhambenh(MaBN, MaBS, NgKham);
                
                MaKB = kbDTO.getMaKB();
                txtYeuCauKham.setText(kbDTO.getYeuCauKham());
                txtKetLuan.setText(kbDTO.getKetLuan());
                
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Lỗi");
            }
        }
    }//GEN-LAST:event_cbbTenBNActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (MaKB==null || txtKetLuan.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân, nhập Kết luận", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else if (tblModelDVBSChon.getRowCount()==0)
                JOptionPane.showMessageDialog(null, "Vui lòng chọn Dịch vụ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else {
            try {

                for (int i=0; i<tblModelDVBSChon.getRowCount(); i++) {
                    thuphiDTO tpDTO = new thuphiDTO();
                    tpDTO.setMaKB(MaKB);
                    tpDTO.setMaDV(tblModelDVBSChon.getValueAt(i, 0).toString());
                    
                    String SL = tblModelDVBSChon.getValueAt(i, 3).toString();
                    tpDTO.setSoLuong(SL);
                    
                    String DonGia = tblModelDVBSChon.getValueAt(i, 2).toString();
                    int ThanhTien = Integer.parseInt(SL) * Integer.parseInt(DonGia);
                    tpDTO.setThanhTien(String.valueOf(ThanhTien));
                    
                    thuphiBLL tpBLL = new thuphiBLL();
                    int result = tpBLL.insertThuPhi(tpDTO);
                      
                }
                
                khambenhBLL kbBLL = new khambenhBLL();
                int update = kbBLL.updateKetLuan(txtKetLuan.getText(), MaKB);
                
                JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
                LoadTableDV();
                LoadTableDVBSChon();
                txtKetLuan.setText("");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Lỗi");
                JOptionPane.showMessageDialog(null, "Thêm dữ liệu KHÔNG thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbTenBSPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbbTenBSPropertyChange
        
    }//GEN-LAST:event_cbbTenBSPropertyChange

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
            java.util.logging.Logger.getLogger(ThemCTKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemCTKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemCTKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemCTKBFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemCTKBFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbTenBN;
    private javax.swing.JComboBox<String> cbbTenBS;
    private com.toedter.calendar.JDateChooser datNgKham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblDV;
    private javax.swing.JTable tblDVBSChon;
    private javax.swing.JTextField txtKetLuan;
    private javax.swing.JTextField txtYeuCauKham;
    // End of variables declaration//GEN-END:variables
}
