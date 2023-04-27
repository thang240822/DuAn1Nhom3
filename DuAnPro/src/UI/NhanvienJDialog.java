/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.NhanVienDAO;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.SanPham;
import Ultils.Auth;
import static Ultils.Auth.user;
import Ultils.MsgBox;
import Ultils.XImage;
import Ultils.dateHelper;
import Ultils.utilityHelper;

import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nolan
 */
public class NhanvienJDialog extends javax.swing.JDialog {

    /**
     * Creates new form NhanvienJDialog
     */
    public NhanvienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        Tabs = new javax.swing.JTabbedPane();
        TabCapNhapNV = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        rdoquanly = new javax.swing.JRadioButton();
        rdonhanvien = new javax.swing.JRadioButton();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDoiMK = new javax.swing.JButton();
        TabDanhSachNV = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnhanvien = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiemNV = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Mã Nhân Viên");

        txtmanv.setName("Mã nhân viên"); // NOI18N

        jLabel3.setText("Mật Khẩu");

        jLabel4.setText("Tên Nhân Viên");

        jLabel5.setText("Giới Tính");

        jLabel7.setText("Vai Trò");

        txttennv.setName("Họ và tên"); // NOI18N

        btnThem.setForeground(new java.awt.Color(51, 255, 51));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setForeground(new java.awt.Color(255, 51, 102));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setForeground(new java.awt.Color(51, 51, 255));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/New.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Previous.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/First.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdonam);
        rdonam.setSelected(true);
        rdonam.setText("Nữ");

        buttonGroup1.add(rdonu);
        rdonu.setText("Nam");
        rdonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdonuActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoquanly);
        rdoquanly.setText("Quản Lý");

        buttonGroup2.add(rdonhanvien);
        rdonhanvien.setSelected(true);
        rdonhanvien.setText("Nhân Viên");

        txtMatKhau.setName("Mật khẩu"); // NOI18N

        btnDoiMK.setBackground(new java.awt.Color(255, 0, 51));
        btnDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Aupdate-icon.png"))); // NOI18N
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TabCapNhapNVLayout = new javax.swing.GroupLayout(TabCapNhapNV);
        TabCapNhapNV.setLayout(TabCapNhapNVLayout);
        TabCapNhapNVLayout.setHorizontalGroup(
            TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(btnFirst)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrev)
                        .addGap(26, 26, 26)
                        .addComponent(btnNext)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast)
                        .addGap(34, 34, 34))
                    .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                        .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                                .addComponent(rdonhanvien)
                                .addGap(18, 18, 18)
                                .addComponent(rdoquanly)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                                .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                                        .addComponent(rdonam)
                                        .addGap(28, 28, 28)
                                        .addComponent(rdonu))
                                    .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtmanv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                        .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                        .addComponent(btnDoiMK)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        TabCapNhapNVLayout.setVerticalGroup(
            TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TabCapNhapNVLayout.createSequentialGroup()
                        .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdonam)
                            .addComponent(rdonu))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7))
                    .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdonhanvien)
                        .addComponent(rdoquanly)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnDoiMK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabCapNhapNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnMoi)
                    .addComponent(btnPrev)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap())
        );

        Tabs.addTab("Cập Nhật", TabCapNhapNV);

        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Mật Khẩu", "Tên Nhân Viên", "Giới Tính", "Vai Trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnhanvien);

        jLabel8.setText("Tìm");

        txtTimKiemNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemNVKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout TabDanhSachNVLayout = new javax.swing.GroupLayout(TabDanhSachNV);
        TabDanhSachNV.setLayout(TabDanhSachNVLayout);
        TabDanhSachNVLayout.setHorizontalGroup(
            TabDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(TabDanhSachNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemNV)
                .addContainerGap())
        );
        TabDanhSachNVLayout.setVerticalGroup(
            TabDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDanhSachNVLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(TabDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabs.addTab("Danh Sách", TabDanhSachNV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (utilityHelper.checkNullText(txtmanv)
                && utilityHelper.checkNullPass(txtMatKhau)
                && utilityHelper.checkNullText(txttennv)) {
            if (utilityHelper.checkMa(txtmanv)
                    && utilityHelper.checkPass(txtMatKhau)
                    && utilityHelper.checkName(txttennv)) {
                if (checkTrungMa(txtmanv)) {
                    insert();
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblnhanvien.rowAtPoint(evt.getPoint());
            if (this.row >= 0) {
                this.edit();
                Tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (Auth.user.getVaiTro()) {
            if (checkChinhMinh(txtmanv)) {
                delete();
            }
        } else {
            MsgBox.alert(this, "Chỉ trưởng phòng mới được phép xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkNullPass(txtMatKhau)
                && utilityHelper.checkNullText(txttennv)) {
            if (utilityHelper.checkPass(txtMatKhau)
                    && utilityHelper.checkName(txttennv)) {
                update();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        Prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        Last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtTimKiemNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNVKeyReleased
        // TODO add your handling code here:
        fillTableTimKiemNV();
    }//GEN-LAST:event_txtTimKiemNVKeyReleased

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        // TODO add your handling code here:
        this.openDoiMatKhau();
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void rdonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdonuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdonuActionPerformed

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
            java.util.logging.Logger.getLogger(NhanvienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanvienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanvienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanvienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanvienJDialog dialog = new NhanvienJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TabCapNhapNV;
    private javax.swing.JPanel TabDanhSachNV;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonhanvien;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JRadioButton rdoquanly;
    private javax.swing.JTable tblnhanvien;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txttennv;
    // End of variables declaration//GEN-END:variables
private void init() {
        setTitle("Quản Lý Nhân Viên");
        setLocationRelativeTo(null);
        setIconImage(XImage.getAppIcon());
        this.fillTable();
    }
    NhanVienDAO nvDAO = new NhanVienDAO();
    int row = -1;

    void fillTableTimKiemNV() {
        DefaultTableModel model = (DefaultTableModel) tblnhanvien.getModel();
        model.setRowCount(0);

        String keyword = txtTimKiemNV.getText();
        List<NhanVien> list = nvDAO.selectByKeywordNV(keyword);

        for (NhanVien nv : list) {
            model.addRow(new Object[]{
                nv.getMaNV(),
                Auth.user.getVaiTro() ? matKhauToSao(nv.getMatKhau()) : nv.getMatKhau(),
                nv.getTenNV(),
                nv.getGioiTinh() ? "Nam" : "Nữ",
                nv.getVaiTro() ? "Quản Lý" : "Nhân viên"
            });

        }
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblnhanvien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = nvDAO.selectAll();
            for (NhanVien nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    Auth.user.getVaiTro() ? matKhauToSao(nv.getMatKhau()) : nv.getMatKhau(),
                    nv.getTenNV(),
                    nv.getGioiTinh() ? "Nữ":"Nam" ,
                    nv.getVaiTro() ? "Quản Lý" : "Nhân viên"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void edit() {
        try {
            String MaNV = (String) tblnhanvien.getValueAt(this.row, 0);
            NhanVien nv = nvDAO.selectById(MaNV);
            this.setForm(nv);
            Tabs.setSelectedIndex(0);
            this.updateStatusSP();
        } catch (Exception e) {
            System.out.println("edit:  " + e);
        }
    }

    void setForm(NhanVien nv) {
        txtmanv.setText(nv.getMaNV());
        txtMatKhau.setText(nv.getMatKhau());
        txttennv.setText(nv.getTenNV());
        if (nv.getGioiTinh()) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }

        if (nv.getVaiTro()) {
            rdoquanly.setSelected(true);

        } else {
            rdonhanvien.setSelected(true);
        }
    }

    NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtmanv.getText());
        nv.setMatKhau(new String(txtMatKhau.getText()));
        nv.setTenNV(txttennv.getText());
        nv.setGioiTinh(rdonam.isSelected());
        nv.setVaiTro(rdoquanly.isSelected());
        return nv;
    }

    void insert() {
        NhanVien nv = getForm();
        try {
            nvDAO.insert(nv);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        NhanVien model = getForm();
        try {
            nvDAO.update(model);     //cập nhật nhân viên theo maNV
            this.fillTable();
            this.clearForm();//điền tt mới vào bảng
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
            String manv = txtmanv.getText();
            try {
                nvDAO.delete(manv);   //xóa nhân viên theo maNV
                this.fillTable();//điền tt mới vào bảng
                this.clearForm();//xóa trắng form và chỉnh lại status
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }
    }

    void clearForm() {
        txtmanv.setText("");
        txtMatKhau.setText("");
        txttennv.setText("");
        rdonam.setSelected(true);
        txtMatKhau.setEditable(true);
        rdonhanvien.setSelected(true);
        btnThem.setEnabled(true);
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
        txtmanv.setEditable(true);
    }

    private void updateStatusSP() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblnhanvien.getRowCount() - 1);
        txtMatKhau.setEditable(!edit);
        txtmanv.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    public String matKhauToSao(String pass) {
        String sao = "";
        for (int i = 0; i < pass.length(); i++) {
            sao += "*";
        }
        return sao;
    }

    private void first() {
        this.row = 0;
        this.edit();
    }

    private void Prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    private void next() {
        if (this.row < tblnhanvien.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    private void Last() {
        this.row = tblnhanvien.getRowCount() - 1;
        this.edit();
    }

    public boolean checkTrungMa(JTextField txt) {
        txt.setBackground(white);
        if (nvDAO.selectById(txt.getText()) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(this, txt.getName() + " đã bị tồn tại.");
            return false;
        }
    }

    public boolean checkChinhMinh(JTextField txt) {
        NhanVien nv = nvDAO.selectById(txt.getText());
        if (nv.getMaNV().equals(user.getMaNV())) {
            MsgBox.alert(this, "bạn không được xóa chính mình.");
            return false;
        } else {
            return true;
        }
    }
    void openDoiMatKhau(){
          
        new DoiMatKhauJDialog(null, true).setVisible(true);
       
}
}