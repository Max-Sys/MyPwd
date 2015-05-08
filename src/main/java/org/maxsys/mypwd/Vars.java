package org.maxsys.mypwd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public static byte[] EncryptPwds(byte[] key, byte[] defile) {
        String enfile = "";

        int kc = (int) (Math.random() * 65535);
        int b1 = kc / 256;
        int b2 = kc - b1 * 256;

        String ehs = Integer.toHexString(b2) + "|";
        enfile += ehs;
        ehs = Integer.toHexString(b1) + "|";
        enfile += ehs;

        for (int dec = 0; dec < defile.length; dec++) {
            byte d = defile[dec];
            byte k = key[kc];
            kc++;
            if (kc == key.length) {
                kc = 0;
            }
            byte e = (byte) (d ^ k);
            ehs = Integer.toHexString(e & 0xFF) + "|";
            enfile += ehs;
        }

        return enfile.getBytes();
    }

    public static byte[] DecryptPwds(byte[] key, byte[] enfile) {
        byte e;
        int tec = 0;
        String bs = "";
        String defile = "";

        int b2 = -1;
        while (b2 < 0) {
            e = enfile[tec];
            tec++;
            if ((char) e != '|') {
                bs += (char) e;
            } else {
                b2 = Integer.parseInt(bs, 16);
                bs = "";
            }
        }

        int b1 = -1;
        while (b1 < 0) {
            e = enfile[tec];
            tec++;
            if ((char) e != '|') {
                bs += (char) e;
            } else {
                b1 = Integer.parseInt(bs, 16);
                bs = "";
            }
        }

        int kc = b1 * 256 + b2;

        for (int ec = tec; ec < enfile.length; ec++) {
            e = enfile[ec];
            if ((char) e != '|') {
                bs += (char) e;
                continue;
            }

            e = (byte) Integer.parseInt(bs, 16);
            bs = "";

            byte k = key[kc];
            kc++;
            if (kc == key.length) {
                kc = 0;
            }

            byte d = (byte) (e ^ k);

            defile += (char) d;
        }

        return defile.getBytes();
    }

    public static byte[] LoadFile(String filen) {
        File file = new File(filen);
        int len = (int) file.length();
        byte[] b = new byte[len];

        try {
            FileInputStream key = new FileInputStream(filen);
            key.read(b);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vars.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Vars.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public static void SaveFile(String filen, byte[] file) {
        try {
            try (FileOutputStream os = new FileOutputStream(filen)) {
                os.write(file);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vars.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Vars.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
