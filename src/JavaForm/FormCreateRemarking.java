/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaForm;

import DAO.RemarkIDDAO;
import Model.TbRemarkid;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author sieus
 */
public class FormCreateRemarking extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmStudent
     */
    public FormCreateRemarking() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jlabel_Username = new javax.swing.JLabel();
        jlabel_Password2 = new javax.swing.JLabel();
        cmbDayTo = new javax.swing.JComboBox<>();
        cmbDayFrom = new javax.swing.JComboBox<>();
        cmbMonthTo = new javax.swing.JComboBox<>();
        cmbMonthFrom = new javax.swing.JComboBox<>();
        cmbYearFrom = new javax.swing.JComboBox<>();
        cmbYearTo = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(600, 500));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Tạo phúc khảo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlabel_Username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel_Username.setText("Ngày bắt đầu");
        jlabel_Username.setToolTipText("");

        jlabel_Password2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabel_Password2.setText("Ngày kết thúc");
        jlabel_Password2.setToolTipText("");

        cmbDayTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDayTo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDayToItemStateChanged(evt);
            }
        });

        cmbDayFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDayFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDayFromItemStateChanged(evt);
            }
        });

        cmbMonthTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMonthTo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthToItemStateChanged(evt);
            }
        });

        cmbMonthFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMonthFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthFromItemStateChanged(evt);
            }
        });

        cmbYearFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbYearFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbYearFromItemStateChanged(evt);
            }
        });

        cmbYearTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbYearTo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbYearToItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel_Password2)
                            .addComponent(jlabel_Username))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbYearTo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlabel_Username)
                                .addComponent(cmbDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlabel_Password2)
                                .addComponent(cmbDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cmbMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25)
                            .addComponent(cmbMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(cmbYearTo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Boolean isLoad = false;
    private final String[] dayOfMonth = {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cmbDayFrom.removeAllItems();
        cmbDayTo.removeAllItems();
        cmbMonthFrom.removeAllItems();
        cmbMonthTo.removeAllItems();
        cmbYearFrom.removeAllItems();
        cmbYearTo.removeAllItems();
        for (int i = 1; i <= 31; i++) {
            String day = (i < 10 ? "0" : "") + String.valueOf(i);
            cmbDayFrom.addItem(String.valueOf(day));
            cmbDayTo.addItem(String.valueOf(day));
        }
        for (int i = 1; i <= 12; i++) {
            String month =  (i < 10 ? "0" : "") + String.valueOf(i);
            cmbMonthFrom.addItem(String.valueOf(month));
            cmbMonthTo.addItem(String.valueOf(month));
        }
        for (int i = 2018; i <= 2030; i++) {
            String year = String.valueOf(i);
            cmbYearFrom.addItem(String.valueOf(year));
            cmbYearTo.addItem(String.valueOf(year));
        }
        txtUsername.setEnabled(false);
        isLoad = true;
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RemarkIDDAO dao = new RemarkIDDAO();
        String name = txtUsername.getText();
        int dateFrom = Integer.valueOf(cmbDayFrom.getSelectedItem().toString());
        int monthFrom = Integer.valueOf(cmbMonthFrom.getSelectedItem().toString());
        int yearFrom = Integer.valueOf(cmbYearFrom.getSelectedItem().toString());
        Date dayFrom = new GregorianCalendar(yearFrom, monthFrom - 1, dateFrom).getTime();
        
        int dateTo = Integer.valueOf(cmbDayTo.getSelectedItem().toString());
        int monthTo = Integer.valueOf(cmbMonthTo.getSelectedItem().toString());
        int yearTo = Integer.valueOf(cmbYearTo.getSelectedItem().toString());
        Date dayTo = new GregorianCalendar(yearTo, monthTo - 1, dateTo).getTime();
        TbRemarkid item = new TbRemarkid(name, dayFrom, dayTo);
        Boolean isUpdate = dao.add(item);
        if (isUpdate){
            JOptionPane.showMessageDialog(null, "Thành công", "Thêm sinh viên thành công !", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Thất bại", "Thêm sinh viên thất bại !", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbDayToItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDayToItemStateChanged
        // TODO add your handling code here:
        if (isLoad){
            updateRemark();
        }
        
    }//GEN-LAST:event_cmbDayToItemStateChanged

    private void cmbDayFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDayFromItemStateChanged
        // TODO add your handling code here:
        if (isLoad){
            updateRemark();
        }
        
    }//GEN-LAST:event_cmbDayFromItemStateChanged

    private void cmbMonthToItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthToItemStateChanged
        // TODO add your handling code here:
        if (isLoad){
            updateRemark();
        }
    }//GEN-LAST:event_cmbMonthToItemStateChanged

    private void cmbMonthFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthFromItemStateChanged
        // TODO add your handling code here:
        if (isLoad){
            updateRemark();
        }
    }//GEN-LAST:event_cmbMonthFromItemStateChanged

    private void cmbYearFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbYearFromItemStateChanged
        // TODO add your handling code here:
        if (isLoad){
            updateRemark();
        }
    }//GEN-LAST:event_cmbYearFromItemStateChanged

    private void cmbYearToItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbYearToItemStateChanged
        // TODO add your handling code here:
        if (isLoad){
            updateRemark();
        }
    }//GEN-LAST:event_cmbYearToItemStateChanged
    public void updateRemark(){
        if (cmbDayFrom == null){
            return;
        }
        String from = cmbDayFrom.getSelectedItem().toString() + "/" + cmbMonthFrom.getSelectedItem().toString() + "/" + cmbYearFrom.getSelectedItem().toString();
        String to = cmbDayTo.getSelectedItem().toString() + "/" + cmbMonthTo.getSelectedItem().toString() + "/" + cmbYearTo.getSelectedItem().toString();
        String name = from + " - " + to;
        txtUsername.setText(name);
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDayFrom;
    private javax.swing.JComboBox<String> cmbDayTo;
    private javax.swing.JComboBox<String> cmbMonthFrom;
    private javax.swing.JComboBox<String> cmbMonthTo;
    private javax.swing.JComboBox<String> cmbYearFrom;
    private javax.swing.JComboBox<String> cmbYearTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlabel_Password2;
    private javax.swing.JLabel jlabel_Username;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
