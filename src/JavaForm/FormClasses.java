/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaForm;

import Entities.Student2;
import JavaCode.CSVReader;
import JavaCode.CSVWriter;
import JavaCode.Utils;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sieus
 */
public class FormClasses extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmStudent
     */
    public FormClasses() {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        cmbClass = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

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

        tableData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableData);

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Môn học");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Xóa sinh viên");
        btnDelete.setToolTipText("");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private final String[] columnNames = {"STT", "MSSV", "Họ tên", "Gới tính", "CMND"};
    public List<String> className = Utils.listAllCSVFile("Classes");

    public void LoadDataToTable() {
        // TODO add your handling code here:
        Integer classID = cmbClass.getSelectedIndex();
        if (classID < 0) {
            return;
        }

        CSVReader reader = new CSVReader();
        Student2 std = new Student2();
        String fileName = "/Data/Classes/" + className.get(classID) + ".csv";
        List<Student2> data = reader.readCSV(fileName, std);
        String[][] dataTable = new String[data.size()][5];
        for (int i = 0; i < data.size(); i++) {
            dataTable[i] = data.get(i).toStringData(Integer.toString(i));
        }
        TableModel table;
        table = new DefaultTableModel(dataTable, columnNames);
        tableData.removeAll();
        tableData.setModel(table);
    }
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cmbClass.removeAllItems();
        className = Utils.listAllCSVFile("Classes");
        for (int i = 0; i < className.size(); i++) {
            cmbClass.addItem(className.get(i));
        }
        Integer classID = cmbClass.getSelectedIndex();
        if (classID == 0) {
            LoadDataToTable();
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void cmbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassItemStateChanged
        // TODO add your handling code here:
        Integer classID = cmbClass.getSelectedIndex();
        if (classID >= 0) {
            LoadDataToTable();
        }

    }//GEN-LAST:event_cmbClassItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int[] idx = tableData.getSelectedRows();
        if (idx.length <= 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần xóa", "Không đúng", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Integer classID = cmbClass.getSelectedIndex();
        if (classID < 0) {
            return;
        }

        CSVReader reader = new CSVReader();
        Student2 std = new Student2();
        String filename = "/Data/Classes/" + className.get(classID) + ".csv";
        List<Student2> dataFromCSV;
        dataFromCSV = reader.readCSV(filename, std);
        DefaultTableModel dm = (DefaultTableModel)tableData.getModel();
        dm.fireTableDataChanged();

        for (int i = 0; i < idx.length; i++) {
            dataFromCSV.remove(idx[i]);
        }

        CSVWriter writer = new CSVWriter();
        Boolean isS = writer.writeCSV(filename, dataFromCSV, new Student2());
        if (isS) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Đã cập nhật điểm số vào sơ sở dữ liệu", JOptionPane.INFORMATION_MESSAGE);
            String[][] dataTable = new String[dataFromCSV.size()][5];
            for (int i = 0; i < dataFromCSV.size(); i++) {
                dataTable[i] = dataFromCSV.get(i).toStringData(Integer.toString(i));
            }
            TableModel table;
            table = new DefaultTableModel(dataTable, columnNames);
            tableData.removeAll();
            tableData.setModel(table);
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Lỗi khi cập nhật sơ sở dữ liệu", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
