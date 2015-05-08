package org.maxsys.mypwd;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {

        // Logger
        try {
            Logger.getLogger("").addHandler(new FileHandler("errorlog.xml"));
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Initialisation and Properties
        Vars.PropPath = System.getProperty("user.home") + "/.MyPwd";
        Vars.PropFileName = Vars.PropPath + "/Options.xml";
        File dir = new File(Vars.PropPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Vars.LoadProperties();

        if (!Vars.prop.containsKey("PwdsFileType")) {
            InitDialog dlg = new InitDialog(null, true);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);

            if (!Vars.prop.containsKey("PwdsFileType")) {
//                return;
            }
        }

        PasswordDialog dlg = new PasswordDialog(null, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);

        if (Vars.MasterPassword.length() == 0) {
            return;
        }

        MainFrame frm = new MainFrame();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

}
