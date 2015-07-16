package org.maxsys.mypwd;

import javax.swing.table.DefaultTableModel;

public class EditPwdDialog extends javax.swing.JDialog {

    String oldPwdName;
    public boolean cancelPressed = false;

    public EditPwdDialog(java.awt.Frame parent, boolean modal, Pwd pwd) {
        super(parent, modal);
        initComponents();

        setMinimumSize(getSize());

        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Field", "Value"}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(400);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(600);

        this.oldPwdName = pwd.getName();

        jTextField1.setText(pwd.getName());

        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        for (String n : pwd.getFieldNames()) {
            String v = pwd.getField(n);
            Object[] row = new Object[2];
            row[0] = n;
            row[1] = new PwdStr(v);
            tm.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit pwd");

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Add field");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remove field");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Edit field");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("↓");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("↑");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cancelPressed = true;
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTextField1.getText().length() == 0) {
            return;
        }

        Pwd pwd = new Pwd(jTextField1.getText());

        for (int ri = 0; ri < jTable1.getRowCount(); ri++) {
            String n = (String) jTable1.getValueAt(ri, 0);
            String v = ((PwdStr) jTable1.getValueAt(ri, 1)).getPwd();
            pwd.setField(n, v);
        }

        Vars.editPwdItem(oldPwdName, pwd.getPwdItem());

        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AddFieldDialog dlg = new AddFieldDialog(null, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);

        String n = dlg.getP_name();
        String v = dlg.getP_value();

        if (n.length() == 0 || v.length() == 0) {
            return;
        }

        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();

        Object[] row = new Object[2];
        row[0] = n;
        row[1] = new PwdStr(v);

        tm.addRow(row);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getButton() == 1 && evt.getClickCount() > 1) {
            int sr = jTable1.getSelectedRow();
            if (sr > -1) {
                EditFieldDialog dlg = new EditFieldDialog(null, true, (String) jTable1.getValueAt(sr, 0), ((PwdStr) jTable1.getValueAt(sr, 1)).getPwd());
                dlg.setLocationRelativeTo(null);
                dlg.setVisible(true);

                String n = dlg.getP_name();
                String v = dlg.getP_value();

                if (n.length() == 0 || v.length() == 0) {
                    return;
                }

                jTable1.setValueAt(n, sr, 0);
                jTable1.setValueAt(new PwdStr(v), sr, 1);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int sr = jTable1.getSelectedRow();
        if (sr > -1) {
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.removeRow(sr);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int sr = jTable1.getSelectedRow();
        if (sr > -1) {
            EditFieldDialog dlg = new EditFieldDialog(null, true, (String) jTable1.getValueAt(sr, 0), ((PwdStr) jTable1.getValueAt(sr, 1)).getPwd());
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);

            String n = dlg.getP_name();
            String v = dlg.getP_value();

            if (n.length() == 0 || v.length() == 0) {
                return;
            }

            jTable1.setValueAt(n, sr, 0);
            jTable1.setValueAt(new PwdStr(v), sr, 1);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int sr = jTable1.getSelectedRow();
        if (sr > 0) {
            Object s0 = jTable1.getValueAt(sr, 0);
            Object s1 = jTable1.getValueAt(sr, 1);
            Object d0 = jTable1.getValueAt(sr - 1, 0);
            Object d1 = jTable1.getValueAt(sr - 1, 1);
            jTable1.setValueAt(d0, sr, 0);
            jTable1.setValueAt(d1, sr, 1);
            jTable1.setValueAt(s0, sr - 1, 0);
            jTable1.setValueAt(s1, sr - 1, 1);
            jTable1.setRowSelectionInterval(sr - 1, sr - 1);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int sr = jTable1.getSelectedRow();
        if (sr > -1 && sr < jTable1.getRowCount() - 1) {
            Object s0 = jTable1.getValueAt(sr, 0);
            Object s1 = jTable1.getValueAt(sr, 1);
            Object d0 = jTable1.getValueAt(sr + 1, 0);
            Object d1 = jTable1.getValueAt(sr + 1, 1);
            jTable1.setValueAt(d0, sr, 0);
            jTable1.setValueAt(d1, sr, 1);
            jTable1.setValueAt(s0, sr + 1, 0);
            jTable1.setValueAt(s1, sr + 1, 1);
            jTable1.setRowSelectionInterval(sr + 1, sr + 1);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
