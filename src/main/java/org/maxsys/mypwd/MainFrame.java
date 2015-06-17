package org.maxsys.mypwd;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    private boolean romode = false;

    public MainFrame() {
        initComponents();

        if (Vars.getProp("PwdsFileType").equals("L")) {
            Vars.LoadPWD();
            setTitle(Vars.Version + " - local only mode");
        }
        if (Vars.getProp("PwdsFileType").equals("G")) {
            setTitle(Vars.Version + " - remote only mode");
        }
        if (Vars.getProp("PwdsFileType").equals("LG")) {
            setTitle(Vars.Version + " - remote + local mode");
        }

        if (Vars.getProp("SortAlphabetically") != null && Vars.getProp("SortAlphabetically").equals("yes")) {
            jCheckBoxMenuItem1.setSelected(true);
        } else {
            jCheckBoxMenuItem1.setSelected(false);
        }

        jSplitPane1.setDividerLocation(0.35);

        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Field", "Value"}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(500);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(500);

        setMinimumSize(getSize());

        RefreshList();

        jList2.requestFocus();
    }

    private void RefreshList() {
        if (!Vars.getProp("PwdsFileType").equals("L")) {
            Vars.getPwdFromGoogleDrive();
        }

        if (!Vars.isPWDLoaded()) {
            jMenuItem3.setEnabled(false);
            jMenuItem4.setEnabled(false);
            jMenuItem5.setEnabled(false);
            jMenuItem7.setEnabled(false);
            jMenuItem10.setEnabled(false);
            jMenuItem6.setEnabled(false);
            jMenuItem11.setEnabled(false);
            if (!Vars.getProp("PwdsFileType").equals("LG")) {
                return;
            } else {
                try {
                    Vars.LoadPWD();
                } catch (NullPointerException e) {
                    return;
                }
                JOptionPane.showMessageDialog(null, "Local backup mode activated!");
                setTitle(Vars.Version + " - backup r/o mode");
                romode = true;
            }
        }

        DefaultListModel lm = new DefaultListModel();

        ArrayList<byte[]> pwditems = Vars.getPwdItems();
        if (pwditems != null) {
            for (byte[] pwditem : pwditems) {
                Pwd p = new Pwd(pwditem);
                lm.addElement(p);
            }
            if (!romode) {
                jMenuItem7.setEnabled(false);
                jMenuItem3.setEnabled(true);
                jMenuItem4.setEnabled(true);
                jMenuItem5.setEnabled(true);
                jMenuItem10.setEnabled(false);
                jMenuItem6.setEnabled(false);
                jMenuItem11.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Decryption failed!");
            jMenuItem7.setEnabled(true);
            jMenuItem3.setEnabled(false);
            jMenuItem4.setEnabled(false);
            jMenuItem5.setEnabled(false);
            jMenuItem10.setEnabled(false);
            jMenuItem6.setEnabled(false);
            jMenuItem11.setEnabled(false);
        }

        if (jCheckBoxMenuItem1.isSelected()) {
            Object[] pwds = lm.toArray();
            Arrays.sort(pwds, new Comparator<Object>() {

                @Override
                public int compare(Object o1, Object o2) {
                    return o1.toString().compareToIgnoreCase(o2.toString());
                }
            });
            DefaultListModel lmnew = new DefaultListModel();
            for (Object pwd : pwds) {
                lmnew.addElement(pwd);
            }
            jList2.setModel(lmnew);
        } else {
            jList2.setModel(lm);
        }
    }

    private class showtimer implements Runnable {

        private final PwdStr pstr;

        public showtimer(PwdStr pstr) {
            this.pstr = pstr;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(450);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            pstr.Hide();
            jTable1.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem8.setText("Show / Hide");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

        jMenuItem9.setText("Copy to clipboard");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        jMenu1.setText("File");

        jMenuItem7.setText("Enter master password");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Pwds");

        jMenuItem5.setText("Add new...");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Edit...");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem10.setText("Remove selected");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);
        jMenu3.add(jSeparator3);

        jCheckBoxMenuItem1.setText("Sort alphabetically");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Tools");

        jMenuItem2.setText("Initialize...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator1);

        jMenuItem11.setText("Import from plain text...");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem3.setText("Export to plain text...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator2);

        jMenuItem4.setText("Options");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        OptionsDialog dlg = new OptionsDialog(this, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Vars.MasterPassword = "";
        Vars.UnloadKEY();
        Vars.UnloadPWD();

        romode = false;

        InitDialog dlg = new InitDialog(null, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);

        Vars.LoadKEY();

        if (Vars.getProp("PwdsFileType").equals("L")) {
            Vars.LoadPWD();
            setTitle(Vars.Version + " - local only mode");
        }
        if (Vars.getProp("PwdsFileType").equals("G")) {
            setTitle(Vars.Version + " - remote only mode");
        }
        if (Vars.getProp("PwdsFileType").equals("LG")) {
            setTitle(Vars.Version + " - remote + local mode");
        }

        Vars.MasterPassword = "";
        RefreshList();
        jList2.requestFocus();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setSelectedFile(new java.io.File(Vars.PropPath + "/export.txt"));
        int r = jfc.showSaveDialog(this);

        if (r == JFileChooser.CANCEL_OPTION || jfc.getSelectedFile() == null) {
            return;
        }
        String filen = jfc.getSelectedFile().getPath();
        try {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filen)))) {
                ArrayList<byte[]> pwditems = Vars.getPwdItems();
                for (byte[] pwditem : pwditems) {
                    Pwd p = new Pwd(pwditem);
                    bw.write("==================================================");
                    bw.newLine();
                    bw.write(p.getName());
                    bw.newLine();
                    for (String fn : p.getFieldNames()) {
                        String fv = p.getField(fn);
                        bw.write("   " + fn + ": " + fv);
                        bw.newLine();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        NewPwdDialog dlg = new NewPwdDialog(this, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);

        if (Vars.getProp("PwdsFileType").equals("L")) {
            Vars.SavePWD();
        }
        if (Vars.getProp("PwdsFileType").equals("G")) {
            Vars.updatePwdOnGoogleDrive();
        }
        if (Vars.getProp("PwdsFileType").equals("LG")) {
            Vars.updatePwdOnGoogleDrive();
            Vars.SavePWD();
        }

        RefreshList();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Vars.MasterPassword = "";
        Vars.LoadKEY();
        if (Vars.getProp("PwdsFileType").equals("L")) {
            Vars.LoadPWD();
        } else {
            Vars.UnloadPWD();
        }
        romode = false;
        RefreshList();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);

        if (jList2.isSelectionEmpty()) {
            jMenuItem10.setEnabled(false);
            jMenuItem6.setEnabled(false);
            return;
        } else {
            if (!romode) {
                jMenuItem10.setEnabled(true);
                jMenuItem6.setEnabled(true);
            }
        }

        Pwd pwd = (Pwd) jList2.getSelectedValue();

        for (String fn : pwd.getFieldNames()) {
            PwdStr pstr = new PwdStr(pwd.getField(fn));
            Object[] row = new Object[2];
            row[0] = fn;
            row[1] = pstr;
            tm.addRow(row);
        }
    }//GEN-LAST:event_jList2ValueChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getButton() == 1 && evt.getClickCount() > 1) {
            PwdStr pstr = (PwdStr) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
            if (pstr.isHided()) {
                pstr.Show();
                Thread thr = new Thread(new showtimer(pstr));
                thr.start();
            } else {
                pstr.Hide();
            }
            jTable1.repaint();
        }

        int rowatpoint = jTable1.rowAtPoint(jTable1.getMousePosition());
        if (rowatpoint < 0 || evt.getButton() != 3) {
            return;
        }
        jTable1.setRowSelectionInterval(rowatpoint, rowatpoint);

        jPopupMenu1.show(jTable1, jTable1.getMousePosition().x, jTable1.getMousePosition().y);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int sr = jTable1.getSelectedRow();
        if (sr < 0) {
            return;
        }
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(((PwdStr) jTable1.getValueAt(sr, 1)).getPwd()), null);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        int sr = jTable1.getSelectedRow();
        if (sr < 0) {
            return;
        }
        PwdStr pstr = (PwdStr) jTable1.getValueAt(sr, 1);
        if (pstr.isHided()) {
            pstr.Show();
        } else {
            pstr.Hide();
        }
        jTable1.repaint();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null);
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (jList2.isSelectionEmpty()) {
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this item?", "Confirm item remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != JOptionPane.YES_OPTION) {
            return;
        }

        Pwd pwd = (Pwd) jList2.getSelectedValue();
        Vars.removePwdItem(pwd.getName());

        if (Vars.getProp("PwdsFileType").equals("L")) {
            Vars.SavePWD();
        }
        if (Vars.getProp("PwdsFileType").equals("G")) {
            Vars.updatePwdOnGoogleDrive();
        }
        if (Vars.getProp("PwdsFileType").equals("LG")) {
            Vars.updatePwdOnGoogleDrive();
            Vars.SavePWD();
        }

        RefreshList();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Warning! All existing items will be deleted! Are you sure you want to do this?", "Confirm item remove", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) != JOptionPane.YES_OPTION) {
            return;
        }

        JFileChooser jfc = new JFileChooser(Vars.PropPath);
        int r = jfc.showOpenDialog(this);

        if (r == JFileChooser.CANCEL_OPTION || jfc.getSelectedFile() == null) {
            return;
        }

        SImg simg = new SImg();
        simg.siShow();

        Vars.NewPWD();

        String filen = jfc.getSelectedFile().getPath();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(filen))) {
                String line;
                Pwd pwd = null;
                int fnum = 1;
                while ((line = br.readLine()) != null) {
                    if (line.contains("==========")) {
                        if (pwd == null) {
                            line = br.readLine();
                            pwd = new Pwd(line.trim());
                            fnum = 1;
                        } else {
                            Vars.addPwdItem(pwd.getPwdItem());
                            pwd = null;
                            line = br.readLine();
                            if (line != null) {
                                pwd = new Pwd(line.trim());
                                fnum = 1;
                            }
                        }
                    } else {
                        String[] fnfv = line.trim().split(": ");
                        if (pwd != null && fnfv.length == 2) {
                            pwd.setField(fnfv[0].trim(), fnfv[1].trim());
                        }
                        if (pwd != null && fnfv.length == 1) {
                            pwd.setField("Field-" + fnum, fnfv[0].trim());
                            fnum++;
                        }
                    }
                }
                if (pwd != null) {
                    Vars.addPwdItem(pwd.getPwdItem());
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        simg.siClose();

        if (Vars.getProp("PwdsFileType").equals("L")) {
            Vars.SavePWD();
        }
        if (Vars.getProp("PwdsFileType").equals("G")) {
            Vars.updatePwdOnGoogleDrive();
        }
        if (Vars.getProp("PwdsFileType").equals("LG")) {
            Vars.updatePwdOnGoogleDrive();
            Vars.SavePWD();
        }

        RefreshList();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (jList2.isSelectionEmpty()) {
            return;
        }

        EditPwdDialog dlg = new EditPwdDialog(this, true, (Pwd) jList2.getSelectedValue());
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);

        if (Vars.getProp("PwdsFileType").equals("L")) {
            Vars.SavePWD();
        }
        if (Vars.getProp("PwdsFileType").equals("G")) {
            Vars.updatePwdOnGoogleDrive();
        }
        if (Vars.getProp("PwdsFileType").equals("LG")) {
            Vars.updatePwdOnGoogleDrive();
            Vars.SavePWD();
        }

        RefreshList();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        if (jList2.isSelectionEmpty()) {
            return;
        }

        if (evt.getClickCount() == 2) {
            EditPwdDialog dlg = new EditPwdDialog(this, true, (Pwd) jList2.getSelectedValue());
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);

            if (Vars.getProp("PwdsFileType").equals("L")) {
                Vars.SavePWD();
            }
            if (Vars.getProp("PwdsFileType").equals("G")) {
                Vars.updatePwdOnGoogleDrive();
            }
            if (Vars.getProp("PwdsFileType").equals("LG")) {
                Vars.updatePwdOnGoogleDrive();
                Vars.SavePWD();
            }

            RefreshList();
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        if (jCheckBoxMenuItem1.isSelected()) {
            Vars.setProp("SortAlphabetically", "yes");
        } else {
            Vars.setProp("SortAlphabetically", "no");
        }

        RefreshList();

        Vars.SaveProperties();
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JList jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
