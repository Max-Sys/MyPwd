package org.maxsys.mypwd;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.ParentReference;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InitDialog extends javax.swing.JDialog {

    private byte[] key;
    private byte[] pwd;

    public InitDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setMinimumSize(getSize());

        if (!Vars.prop.containsKey("PwdsFilePath") || !Vars.getProp("PwdsFileType").equals("L")) {
            jRadioButton2.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton26 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Initialization");
        getContentPane().setLayout(new java.awt.CardLayout());

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Next >");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Create new or connect existing KEY and PWD files");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Create new KEY file and encrypt existing PWD file");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        jButton3.setText("Next >");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("KEY file"));

        jLabel2.setText("File location:");

        jTextField2.setEditable(false);

        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Create new KEY file");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("PWD file"));

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setSelected(true);
        jRadioButton4.setText("Local only");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Google Drive only");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Google Drive + local backup");

        jLabel1.setText("File location:");

        jButton7.setText("...");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jButton8.setText("Create new empty PWD file");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton9.setText("< Back");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, "card3");

        jButton22.setText("Next >");
        jButton22.setEnabled(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("Cancel");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("Create new Google drive credentials");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Google Drive file & folder"));
        jPanel10.setEnabled(false);

        jLabel11.setText("Folder name:");
        jLabel11.setEnabled(false);

        jLabel12.setText("File name:");
        jLabel12.setEnabled(false);

        jTextField7.setEnabled(false);

        jTextField8.setEnabled(false);

        jButton25.setText("Upload PWD file to Google Drive");
        jButton25.setEnabled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jLabel13.setText("Local PWD file:");
        jLabel13.setEnabled(false);

        jTextField9.setEditable(false);
        jTextField9.setEnabled(false);

        jLabel10.setText("File ID (Please note it for later use on other devices):");
        jLabel10.setEnabled(false);

        jTextField5.setEditable(false);
        jTextField5.setText("---");
        jTextField5.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton21.setText("< Back");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23))
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jButton22)
                    .addComponent(jButton21))
                .addContainerGap())
        );

        getContentPane().add(jPanel9, "card7");

        jButton10.setText("Finish");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Cancel");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel3.setText("Your KEY and PWD files initialized successfully!");

        jLabel4.setText("Click Finish to save settings.");

        jLabel9.setText("   ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton10))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, "card4");

        jButton12.setText("Finish");
        jButton12.setEnabled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Cancel");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel5.setText("KEY file location:");

        jTextField3.setEditable(false);

        jButton14.setText("Create new KEY file");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel6.setText("New KEY file location:");

        jTextField4.setEditable(false);

        jButton15.setText("Encrypt PWD file");
        jButton15.setEnabled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel7.setText("Old password:");
        jLabel7.setEnabled(false);

        jPasswordField1.setEnabled(false);

        jLabel8.setText("New password:");
        jLabel8.setEnabled(false);

        jPasswordField2.setEnabled(false);

        jButton26.setText("< Back");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4))
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton12)
                    .addComponent(jButton26))
                .addContainerGap())
        );

        getContentPane().add(jPanel6, "card5");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        if (jRadioButton1.isSelected()) {
            cl.show(getContentPane(), "card3");
        }
        if (jRadioButton2.isSelected()) {
            jTextField3.setText(Vars.getProp("KeysFilePath"));
            cl.show(getContentPane(), "card5");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        File file = new File(jTextField2.getText());

        if (!file.exists() || jTextField2.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "KEY file does not exists!");
            return;
        }

        if (jRadioButton4.isSelected()) {
            file = new File(jTextField1.getText());
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "PWD file does not exists!");
                return;
            }
        }
        if (jRadioButton5.isSelected()) {
            if ((pwd == null || jTextField1.getText().length() == 0) && !jTextField1.getText().startsWith("ID:")) {
                JOptionPane.showMessageDialog(this, "Please create new empty PWD file or choose existing one!");
                return;
            }
        } else {
            file = new File(jTextField1.getText());
            if ((pwd == null || !file.exists() || jTextField1.getText().length() == 0) && !jTextField1.getText().startsWith("ID:")) {
                JOptionPane.showMessageDialog(this, "PWD file does not exists!");
                return;
            }
        }

        CardLayout cl = (CardLayout) getContentPane().getLayout();
        if (jRadioButton4.isSelected()) {
            cl.show(getContentPane(), "card4");
        } else {
            if (jTextField1.getText().startsWith("ID:")) {
                jLabel13.setText("Google Drive file ID:");
                jTextField9.setText(jTextField1.getText().substring(3));
                jButton25.setText("Download PWD file from Google Drive");
            } else {
                jLabel13.setText("Local PWD file:");
                jTextField9.setText(jTextField1.getText());
                jButton25.setText("Upload PWD file to Google Drive");
            }
            cl.show(getContentPane(), "card7");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "card2");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser jfc = new JFileChooser(Vars.PropPath);
        jfc.showOpenDialog(null);
        if (jfc.getSelectedFile() != null) {
            File file = new File(jfc.getSelectedFile().getPath());
            if (file.exists()) {
                jTextField2.setText(jfc.getSelectedFile().getPath());
                key = Vars.LoadFile(jfc.getSelectedFile().getPath());
            } else {
                JOptionPane.showMessageDialog(this, "KEY file \"" + jfc.getSelectedFile().getPath() + "\" does not exists!");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FileOutputStream fos;
        int kfnum = 1;
        String filen = Vars.PropPath + "/key-" + kfnum + ".dat";
        try {
            File f = new File(filen);
            while (f.exists()) {
                kfnum++;
                if (kfnum == 1000) {
                    JOptionPane.showMessageDialog(this, "Error creating KEY file!");
                    return;
                }
                filen = Vars.PropPath + "/key-" + kfnum + ".dat";
                f = new File(filen);
            }
            fos = new FileOutputStream(filen);
            for (int i = 0; i < 65536; i++) {
                int b = (int) (Math.random() * 255);
                fos.write(b);
            }
            fos.close();
            key = Vars.LoadFile(filen);
            jTextField2.setText(filen);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InitDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InitDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (key == null || jTextField2.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "KEY file does not exists!");
            return;
        }

        if (jRadioButton5.isSelected() || jRadioButton6.isSelected()) {
            GetGDFileIDDialog dlg = new GetGDFileIDDialog(null, true);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
            if (dlg.getFileID().length() > 0) {
                jTextField1.setText("ID:" + dlg.getFileID());
            }
        } else {
            JFileChooser jfc = new JFileChooser(Vars.PropPath);
            jfc.showOpenDialog(null);
            if (jfc.getSelectedFile() != null) {
                if (jfc.getSelectedFile().getPath().equals(jTextField2.getText())) {
                    JOptionPane.showMessageDialog(this, "PWD file and KEY file should not be the same!");
                    return;
                }
                File f = new File(jfc.getSelectedFile().getPath());
                if (f.exists()) {
                    pwd = Vars.LoadFile(jfc.getSelectedFile().getPath());
                    Vars.MasterPassword = "";
                    if (Vars.tryCheckOk(Vars.DecryptBytes(key, pwd))) {
                        jTextField1.setText(jfc.getSelectedFile().getPath());
                    } else {
                        jTextField1.setText("");
                        JOptionPane.showMessageDialog(this, "PWD file \"" + jfc.getSelectedFile().getPath() + "\" is wrong and will not be used.");
                        Vars.MasterPassword = "";
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "PWD file does not exists!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "PWD file does not exists!");
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int kfnum = 1;
        String filen = Vars.PropPath + "/pwd-" + kfnum + ".dat";

        if (key == null || jTextField2.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "KEY file does not exists!");
            return;
        }

        File f = new File(filen);
        while (f.exists()) {
            kfnum++;
            if (kfnum == 1000) {
                JOptionPane.showMessageDialog(this, "Error creating PWD file!");
                return;
            }
            filen = Vars.PropPath + "/pwd-" + kfnum + ".dat";
            f = new File(filen);
        }

        byte[] defile = new byte[0];

        Vars.MasterPassword = "";
        PasswordDialog dlg = new PasswordDialog(null, true, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
        if (Vars.MasterPassword.length() == 0) {
            return;
        }

        pwd = Vars.EncryptBytes(key, defile);

        if (pwd != null) {
            if (jRadioButton5.isSelected()) {
                jTextField1.setText("New empty PWD file will be created on Google Drive.");
            } else {
                Vars.SaveFile(filen, pwd);
                jTextField1.setText(filen);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jRadioButton4.isSelected()) {
            Vars.setProp("PwdsFileType", "L");
            Vars.setProp("KeysFilePath", jTextField2.getText());
            Vars.setProp("PwdsFilePath", jTextField1.getText());
        }

        if (jRadioButton5.isSelected()) {
            Vars.setProp("PwdsFileType", "G");
            Vars.setProp("KeysFilePath", jTextField2.getText());
            if (!jTextField9.getText().equals("New empty PWD file will be created on Google Drive.")) {
                File f = new File(jTextField1.getText());
                f.renameTo(new File(jTextField1.getText() + ".old"));
            }
            Vars.prop.remove("PwdsFilePath");
        }

        if (jRadioButton6.isSelected()) {
            Vars.setProp("PwdsFileType", "LG");
            Vars.setProp("KeysFilePath", jTextField2.getText());
            if (jLabel13.getText().startsWith("Local")) {
                Vars.setProp("PwdsFilePath", jTextField1.getText());
            } else {
                int kfnum = 1;
                String filen = Vars.PropPath + "/pwd-" + kfnum + ".dat";
                File f = new File(filen);
                while (f.exists()) {
                    kfnum++;
                    if (kfnum == 1000) {
                        JOptionPane.showMessageDialog(this, "Error creating PWD file!");
                        return;
                    }
                    filen = Vars.PropPath + "/pwd-" + kfnum + ".dat";
                    f = new File(filen);
                }
                Vars.SaveFile(filen, pwd);
                Vars.setProp("PwdsFilePath", filen);
            }
        }

        Vars.SaveProperties();

        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (!Vars.getProp("PwdsFileType").equals("G")) {
            //Vars.KEY = Vars.LoadFile(Vars.getProp("KeysFilePath"));
            //Vars.PWD = Vars.LoadFile(Vars.getProp("PwdsFilePath"));
        } else {
            JOptionPane.showMessageDialog(this, "Sync with Google!");
        }
        dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        FileOutputStream fos;
        int kfnum = 1;
        String filen = Vars.PropPath + "/key-" + kfnum + ".dat";
        try {
            File f = new File(filen);
            while (f.exists()) {
                kfnum++;
                if (kfnum == 1000) {
                    JOptionPane.showMessageDialog(this, "Error creating KEY file!");
                    return;
                }
                filen = Vars.PropPath + "/key-" + kfnum + ".dat";
                f = new File(filen);
            }
            fos = new FileOutputStream(filen);
            for (int i = 0; i < 65536; i++) {
                int b = (int) (Math.random() * 255);
                fos.write(b);
            }
            fos.close();
            jTextField4.setText(filen);
            //JOptionPane.showMessageDialog(this, "KEY file \"" + filen + "\" created successfully.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InitDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InitDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        jButton14.setEnabled(false);
        jButton15.setEnabled(true);
        jLabel7.setEnabled(true);
        jLabel8.setEnabled(true);
        jPasswordField1.setEnabled(true);
        jPasswordField2.setEnabled(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String oldpassw = new String(jPasswordField1.getPassword());
        String newpassw = new String(jPasswordField2.getPassword());
        if (oldpassw.length() == 0 || newpassw.length() == 0) {
            JOptionPane.showMessageDialog(this, "Password can not be empty!");
            return;
        }
        pwd = Vars.LoadFile(Vars.getProp("PwdsFilePath"));
        key = Vars.LoadFile(Vars.getProp("KeysFilePath"));
        byte[] newkey = Vars.LoadFile(jTextField4.getText());

        Vars.MasterPassword = oldpassw;
        pwd = Vars.DecryptBytes(key, pwd);
        if (!Vars.tryCheckOk(pwd)) {
            JOptionPane.showMessageDialog(null, "Decryption failed! Probably the old password wrong.");
            return;
        }

        Vars.MasterPassword = newpassw;
        pwd = Vars.EncryptBytes(newkey, pwd);

        Vars.SaveFile(Vars.getProp("PwdsFilePath"), pwd);
        Vars.setProp("KeysFilePath", jTextField4.getText());
        Vars.SaveProperties();

        jButton15.setEnabled(false);
        jLabel7.setEnabled(false);
        jLabel8.setEnabled(false);
        jPasswordField1.setEnabled(false);
        jPasswordField2.setEnabled(false);
        jButton12.setEnabled(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if (jRadioButton5.isSelected() && !jTextField9.getText().equals("New empty PWD file will be created on Google Drive.")) {
            jLabel9.setText("Please note that your old PWD file will be renamed to %.old");
        }
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "card4");
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, Vars.CLIENT_ID, Vars.CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
                .setAccessType("offline")
                .setApprovalPrompt("force").build();

        AuthorizationCodeInstalledApp app = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver());

        Credential credential = null;
        try {
            credential = app.authorize("user");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (credential == null) {
            JOptionPane.showMessageDialog(null, "Google drive access failed!");
            return;
        }

        Vars.setProp("RefreshToken", credential.getRefreshToken());

        if (!jLabel13.getText().startsWith("Google")) {
            jLabel11.setEnabled(true);
            jLabel12.setEnabled(true);
            jTextField7.setEnabled(true);
            jTextField8.setEnabled(true);
        }
        jButton24.setEnabled(false);
        jPanel10.setEnabled(true);
        jLabel13.setEnabled(true);
        jTextField9.setEnabled(true);
        jButton25.setEnabled(true);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        if (jTextField8.getText().length() == 0 && jButton25.getText().startsWith("Upload")) {
            JOptionPane.showMessageDialog(this, "File name can not be empty!");
            return;
        }

        JacksonFactory jsonFactory = new JacksonFactory();
        HttpTransport httpTransport = new NetHttpTransport();
        GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(jsonFactory)
                .setTransport(httpTransport).setClientSecrets(Vars.CLIENT_ID, Vars.CLIENT_SECRET).build();
        credential.setRefreshToken(Vars.getProp("RefreshToken"));

        Drive service = new Drive.Builder(httpTransport, jsonFactory, credential).setApplicationName(Vars.Version).build();

        String fileid = "";

        if (jButton25.getText().startsWith("Upload")) {
            String folderid = "";

            if (jTextField7.getText().length() > 0) {
                com.google.api.services.drive.model.File body = new com.google.api.services.drive.model.File();
                body.setTitle(jTextField7.getText());
                body.setDescription("MyPwd Folder");
                body.setMimeType("application/vnd.google-apps.folder");

                try {
                    com.google.api.services.drive.model.File file = service.files().insert(body).execute();
                    if (file != null) {
                        folderid = file.getId();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error creating folder!");
                        return;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(InitDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            com.google.api.services.drive.model.File body = new com.google.api.services.drive.model.File();
            body.setTitle(jTextField8.getText());
            body.setDescription("MyPwd PWD file");
            body.setMimeType("text/plain");
            if (folderid.length() > 0) {
                body.setParents(Arrays.asList(new ParentReference().setId(folderid)));
            }

            AbstractInputStreamContent mediaContent = new AbstractInputStreamContent("text/plain") {
                int sp = -1;

                @Override
                public InputStream getInputStream() throws IOException {
                    InputStream is = new InputStream() {

                        @Override
                        public int read() throws IOException {
                            sp++;
                            if (sp < pwd.length) {
                                return pwd[sp];
                            } else {
                                return -1;
                            }
                        }
                    };
                    return is;
                }

                @Override
                public String getType() {
                    return "text/plain";
                }

                @Override
                public long getLength() throws IOException {
                    return pwd.length;
                }

                @Override
                public boolean retrySupported() {
                    return false;
                }
            };

            try {
                com.google.api.services.drive.model.File file = service.files().insert(body, mediaContent).execute();
                if (file != null) {
                    fileid = file.getId();
                } else {
                    JOptionPane.showMessageDialog(this, "Error creating file!");
                    return;
                }
            } catch (IOException ex) {
                Logger.getLogger(InitDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (jButton25.getText().startsWith("Download")) {
            com.google.api.services.drive.model.File file = null;
            try {
                file = service.files().get(jTextField9.getText()).execute();
            } catch (IOException | NullPointerException ex) {
                Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (file == null) {
                JOptionPane.showMessageDialog(null, "Failed to access PWD file on Google Drive!");
                return;
            }

            String spwd = "";

            try {
                HttpResponse resp = service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl())).execute();
                try (InputStream is = resp.getContent()) {
                    int b = 0;
                    while (b >= 0) {
                        b = is.read();
                        if (b != -1) {
                            spwd += (char) b;
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
            }

            fileid = jTextField9.getText();
            pwd = spwd.getBytes();
        }

        jTextField5.setText(fileid);
        Vars.setProp("GoogleDriveFileID", fileid);

        jLabel10.setEnabled(true);
        jTextField5.setEnabled(true);
        jPanel10.setEnabled(false);
        jLabel11.setEnabled(false);
        jLabel12.setEnabled(false);
        jLabel13.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jButton25.setEnabled(false);
        jButton22.setEnabled(true);
        jButton21.setEnabled(false);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "card3");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "card2");
    }//GEN-LAST:event_jButton26ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
