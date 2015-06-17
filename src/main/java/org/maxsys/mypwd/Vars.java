package org.maxsys.mypwd;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Vars {

    public static String Version = "MyPwd 1.00-RC3";
    public static String MasterPassword = "";
    private static byte[] KEY;
    private static byte[] PWD;
    public static Properties prop = new Properties();
    public static String PropFileName = "";
    public static String PropPath = "";
    public static final String CLIENT_ID = "948160247524-j9dam0gik6ngu8rpfqqujlepgbo6sdk1.apps.googleusercontent.com";
    public static final String CLIENT_SECRET = "kOmeybiX4Dln8LBTxO6NoADR";

    /*
     PwdsFileType
     PwdsFilePath
     KeysFilePath
     RefreshToken
     */
    public static void setProp(String key, String Value) {
        prop.setProperty(key, Value);
    }

    public static String getProp(String key) {
        return prop.getProperty(key);
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

    public static void addPwdItem(byte[] pwditem) {
        byte[] defile = DecryptBytes(KEY, PWD);
        if (defile == null) {
            return;
        }

        byte[] newdefile = new byte[defile.length + pwditem.length + 2];
        System.arraycopy(defile, 0, newdefile, 0, defile.length);

        int ic = defile.length;
        byte[] lb = Pwd.GetLengthInBytes(pwditem.length);

        System.arraycopy(lb, 0, newdefile, ic, 2);

        System.arraycopy(pwditem, 0, newdefile, ic + 2, pwditem.length);

        PWD = EncryptBytes(KEY, newdefile);
    }

    public static void removePwdItem(String name) {
        SImg simg = new SImg();
        simg.siShow();

        ArrayList<byte[]> items = getPwdItems();
        if (items == null) {
            return;
        }
        NewPWD();
        for (byte[] item : items) {
            Pwd p = new Pwd(item);
            if (!p.getName().equals(name)) {
                addPwdItem(item);
            }
        }

        simg.siClose();
    }

    public static void editPwdItem(String name, byte[] newpwditem) {
        SImg simg = new SImg();
        simg.siShow();

        ArrayList<byte[]> items = getPwdItems();
        if (items == null) {
            return;
        }
        NewPWD();
        for (byte[] item : items) {
            Pwd p = new Pwd(item);
            if (!p.getName().equals(name)) {
                addPwdItem(item);
            } else {
                addPwdItem(newpwditem);
            }
        }

        simg.siClose();
    }

    public static ArrayList<byte[]> getPwdItems() {
        byte[] defile = DecryptBytes(KEY, PWD);
        if (defile == null) {
            MasterPassword = "";
            return null;
        }

        int dfc = 0;
        byte[] lb = new byte[2];
        int li;

        ArrayList<byte[]> pwdItems = new ArrayList<>();

        while (dfc < defile.length) {
            lb[0] = defile[dfc];
            dfc++;
            lb[1] = defile[dfc];
            dfc++;
            li = Pwd.GetLengthInInt(lb);
            int nic = dfc + li;
            byte[] pwdItem = new byte[li];
            while (dfc < nic) {
                try {
                    pwdItem[dfc + li - nic] = defile[dfc];
                } catch (Exception e) {
                    return null;
                }
                dfc++;
            }
            pwdItems.add(pwdItem);
        }

        return pwdItems;
    }

    public static boolean tryCheckOk(byte[] defile) {
        if (defile == null) {
            return false;
        }

        int dfc = 0;
        byte[] lb = new byte[2];
        int li;

        while (dfc < defile.length) {
            lb[0] = defile[dfc];
            dfc++;
            lb[1] = defile[dfc];
            dfc++;
            li = Pwd.GetLengthInInt(lb);
            int nic = dfc + li;
            byte[] pwdItem = new byte[li];
            while (dfc < nic) {
                try {
                    pwdItem[dfc + li - nic] = defile[dfc];
                } catch (Exception e) {
                    return false;
                }
                dfc++;
            }
        }

        return true;
    }

    public static byte[] EncryptBytes(byte[] key, byte[] defile) {
        if (MasterPassword.length() == 0) {
            PasswordDialog dlg = new PasswordDialog(null, true);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
            if (MasterPassword.length() == 0) {
                return null;
            }
        }

        String enfile = "";

        int kc = (int) (Math.random() * 65535);
        int b1 = kc / 256;
        int b2 = kc - b1 * 256;

        String ehs = Integer.toHexString(b2) + "|";
        enfile += ehs;
        ehs = Integer.toHexString(b1) + "|";
        enfile += ehs;

        int mpc = 0;

        for (int dec = 0; dec < defile.length; dec++) {
            byte d = defile[dec];
            byte k = key[kc];
            kc++;
            if (kc == key.length) {
                kc = 0;
            }
            byte mpk = MasterPassword.getBytes()[mpc];
            mpc++;
            if (mpc == MasterPassword.length()) {
                mpc = 0;
            }
            byte e = (byte) (d ^ k);
            e = (byte) (e ^ mpk);
            ehs = Integer.toHexString(e & 0xFF) + "|";
            enfile += ehs;
        }

        return enfile.getBytes();
    }

    public static byte[] DecryptBytes(byte[] key, byte[] enfile) {
        if (MasterPassword.length() == 0) {
            PasswordDialog dlg = new PasswordDialog(null, true);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
            if (MasterPassword.length() == 0) {
                return null;
            }
        }

        byte e;
        int tec = 0;
        String bs = "";
        ArrayList<Byte> defile = new ArrayList<>();

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

        int mpc = 0;

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

            byte mpk = MasterPassword.getBytes()[mpc];
            mpc++;
            if (mpc == MasterPassword.length()) {
                mpc = 0;
            }

            byte d = (byte) (e ^ mpk);
            d = (byte) (d ^ k);

            defile.add(d);
        }

        byte[] debytes = new byte[defile.size()];
        for (int i = 0; i < defile.size(); i++) {
            debytes[i] = defile.get(i);
        }

        return debytes;
    }

    public static byte[] LoadFile(String filen) {
        File file = new File(filen);
        int len = (int) file.length();
        byte[] b = new byte[len];

        try {
            try (FileInputStream is = new FileInputStream(filen)) {
                is.read(b);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public static void SaveFile(String filen, byte[] file) {
        try {
            try (FileOutputStream os = new FileOutputStream(filen)) {
                os.write(file);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void LoadKEY() {
        KEY = LoadFile(getProp("KeysFilePath"));
    }

    public static void LoadKEY(String KEYFilePath) {
        KEY = LoadFile(KEYFilePath);
    }

    public static void SaveKEY() {
        SaveFile(getProp("KeysFilePath"), KEY);
    }

    public static void SaveKEY(String KEYFilePath) {
        SaveFile(KEYFilePath, KEY);
    }

    public static boolean isKEYLoaded() {
        return KEY != null;
    }

    public static void UnloadKEY() {
        KEY = null;
    }

    public static void LoadPWD() {
        PWD = LoadFile(getProp("PwdsFilePath"));
    }

    public static void SavePWD() {
        SaveFile(getProp("PwdsFilePath"), PWD);
    }

    public static void SavePWD(String PWDFilePath) {
        SaveFile(PWDFilePath, PWD);
    }

    public static boolean isPWDLoaded() {
        return PWD != null;
    }

    public static void UnloadPWD() {
        PWD = null;
    }

    public static void NewPWD() {
        PWD = EncryptBytes(KEY, new byte[0]);
    }

    public static void getPwdFromGoogleDrive() {
        SImg simg = new SImg();
        simg.siShow();

        JacksonFactory jsonFactory = new JacksonFactory();
        HttpTransport httpTransport = new NetHttpTransport();
        GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(jsonFactory)
                .setTransport(httpTransport).setClientSecrets(Vars.CLIENT_ID, Vars.CLIENT_SECRET).build();
        credential.setRefreshToken(Vars.getProp("RefreshToken"));

        Drive service = new Drive.Builder(httpTransport, jsonFactory, credential).setApplicationName(Vars.Version).build();

        com.google.api.services.drive.model.File file = null;
        try {
            file = service.files().get(Vars.getProp("GoogleDriveFileID")).execute();
        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (file == null) {
            simg.siClose();
            JOptionPane.showMessageDialog(null, "Failed to access PWD file on Google Drive!");
            return;
        }

        String pwd = "";

        try {
            HttpResponse resp = service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl())).execute();
            try (InputStream is = resp.getContent()) {
                int b = 0;
                while (b >= 0) {
                    b = is.read();
                    if (b != -1) {
                        pwd += (char) b;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }

        PWD = pwd.getBytes();

        simg.siClose();
    }

    public static void updatePwdOnGoogleDrive() {
        SImg simg = new SImg();
        simg.siShow();

        JacksonFactory jsonFactory = new JacksonFactory();
        HttpTransport httpTransport = new NetHttpTransport();
        GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(jsonFactory)
                .setTransport(httpTransport).setClientSecrets(Vars.CLIENT_ID, Vars.CLIENT_SECRET).build();
        credential.setRefreshToken(Vars.getProp("RefreshToken"));

        Drive service = new Drive.Builder(httpTransport, jsonFactory, credential).setApplicationName(Vars.Version).build();

        com.google.api.services.drive.model.File file = null;
        try {
            file = service.files().get(Vars.getProp("GoogleDriveFileID")).execute();
        } catch (IOException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (file == null) {
            simg.siClose();
            return;
        }

        AbstractInputStreamContent mediaContent = new AbstractInputStreamContent("text/plain") {
            int sp = -1;

            @Override
            public InputStream getInputStream() throws IOException {
                InputStream is = new InputStream() {

                    @Override
                    public int read() throws IOException {
                        sp++;
                        if (sp < PWD.length) {
                            return PWD[sp];
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
                return PWD.length;
            }

            @Override
            public boolean retrySupported() {
                return false;
            }
        };

        try {
            service.files().update(Vars.getProp("GoogleDriveFileID"), file, mediaContent).execute();
        } catch (IOException ex) {
            Logger.getLogger(Vars.class.getName()).log(Level.SEVERE, null, ex);
        }

        simg.siClose();
    }

    public static String getHexString(String str) {
        String hexstr = "";
        int i = 0;
        while (i < str.length()) {
            Integer ic = str.codePointAt(i);
            hexstr = hexstr + Integer.toHexString(ic);
            hexstr = hexstr + "|";
            i++;
        }
        return hexstr;
    }

    public static String getStringFromHex(String hexstr) {
        if (hexstr == null) {
            return "";
        }
        String str = "";
        String s = "";
        int ci;
        char c;
        int i = 0;
        while (i < hexstr.length()) {
            if (!hexstr.substring(i, i + 1).equals("|")) {
                s = s + hexstr.substring(i, i + 1);
                i++;
            } else {
                try {
                    ci = Integer.parseInt(s, 16);
                } catch (NumberFormatException ex) {
                    return "HEX parsing error";
                }
                c = (char) ci;
                str = str + c;
                s = "";
                i++;
            }
        }
        return str;
    }
}
