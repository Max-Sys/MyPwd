package org.maxsys.mypwd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vars {

    public static String Version = "MyPwd 0.01-00a";
    public static String MasterPassword = "qwerty";
    public static Properties prop = new Properties();
    public static String PropFileName = "";
    public static String PropPath = "";

    public static void setSecProp(String key, String value) {
        String hex = "";
        int pc = 0;
        for (int vc = 0; vc < value.length(); vc++) {
            int in = value.codePointAt(vc);
            int ke = MasterPassword.codePointAt(pc);
            int en = in ^ ke;

            hex += Integer.toHexString(en);
            hex += "|";

            pc++;
            if (pc == MasterPassword.length()) {
                pc = 0;
            }
        }

        prop.setProperty(key, hex);

        System.out.println(hex);
    }

    public static String getSecProp(String key) {
        String hex = prop.getProperty(key);
        String str = "";
        String s = "";
        int pc = 0;
        char c;
        for (int hc = 0; hc < hex.length(); hc++) {
            if (!hex.substring(hc, hc + 1).equals("|")) {
                s = s + hex.substring(hc, hc + 1);
            } else {
                int en = Integer.parseInt(s, 16);
                int ke = MasterPassword.codePointAt(pc);
                int de = en ^ ke;

                c = (char) de;
                str += c;
                s = "";

                pc++;
                if (pc == MasterPassword.length()) {
                    pc = 0;
                }
            }
        }
        return str;
    }

    public static void SaveProperties() {
        try {
            prop.storeToXML(new FileOutputStream(PropFileName, false), null);
        } catch (IOException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void LoadProperties() {
        try {
            Vars.prop.loadFromXML(new FileInputStream(PropFileName));
        } catch (IOException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
