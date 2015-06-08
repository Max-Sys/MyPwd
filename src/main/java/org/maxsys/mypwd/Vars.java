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

    public static String Version = "MyPwd 1.00-RC1";
    public static String MasterPassword = "";
    private static byte[] KEY;
    private static byte[] PWD;
    public static Properties prop = new Properties();
    public static String PropFileName = "";
    public static String PropPath = "";
    public static final String CLIENT_ID = "948160247524-j9dam0gik6ngu8rpfqqujlepgbo6sdk1.apps.googleusercontent.com";
    public static final String CLIENT_SECRET = "kOmeybiX4Dln8LBTxO6NoADR";
    private static final int[] CRC16_TABLE = {0x0000, 0xc0c1, 0xc181, 0x0140, 0xc301, 0x03c0, 0x0280, 0xc241, 0xc601, 0x06c0, 0x0780, 0xc741, 0x0500, 0xc5c1, 0xc481, 0x0440, 0xcc01, 0x0cc0, 0x0d80, 0xcd41, 0x0f00, 0xcfc1, 0xce81, 0x0e40, 0x0a00, 0xcac1, 0xcb81, 0x0b40, 0xc901, 0x09c0, 0x0880, 0xc841, 0xd801, 0x18c0, 0x1980, 0xd941, 0x1b00, 0xdbc1, 0xda81, 0x1a40, 0x1e00, 0xdec1, 0xdf81, 0x1f40, 0xdd01, 0x1dc0, 0x1c80, 0xdc41, 0x1400, 0xd4c1, 0xd581, 0x1540, 0xd701, 0x17c0, 0x1680, 0xd641, 0xd201, 0x12c0, 0x1380, 0xd341, 0x1100, 0xd1c1, 0xd081, 0x1040, 0xf001, 0x30c0, 0x3180, 0xf141, 0x3300, 0xf3c1, 0xf281, 0x3240, 0x3600, 0xf6c1, 0xf781, 0x3740, 0xf501, 0x35c0, 0x3480, 0xf441, 0x3c00, 0xfcc1, 0xfd81, 0x3d40, 0xff01, 0x3fc0, 0x3e80, 0xfe41, 0xfa01, 0x3ac0, 0x3b80, 0xfb41, 0x3900, 0xf9c1, 0xf881, 0x3840, 0x2800, 0xe8c1, 0xe981, 0x2940, 0xeb01, 0x2bc0, 0x2a80, 0xea41, 0xee01, 0x2ec0, 0x2f80, 0xef41, 0x2d00, 0xedc1, 0xec81, 0x2c40, 0xe401, 0x24c0, 0x2580, 0xe541, 0x2700, 0xe7c1, 0xe681, 0x2640, 0x2200, 0xe2c1, 0xe381, 0x2340, 0xe101, 0x21c0, 0x2080, 0xe041, 0xa001, 0x60c0, 0x6180, 0xa141, 0x6300, 0xa3c1, 0xa281, 0x6240, 0x6600, 0xa6c1, 0xa781, 0x6740, 0xa501, 0x65c0, 0x6480, 0xa441, 0x6c00, 0xacc1, 0xad81, 0x6d40, 0xaf01, 0x6fc0, 0x6e80, 0xae41, 0xaa01, 0x6ac0, 0x6b80, 0xab41, 0x6900, 0xa9c1, 0xa881, 0x6840, 0x7800, 0xb8c1, 0xb981, 0x7940, 0xbb01, 0x7bc0, 0x7a80, 0xba41, 0xbe01, 0x7ec0, 0x7f80, 0xbf41, 0x7d00, 0xbdc1, 0xbc81, 0x7c40, 0xb401, 0x74c0, 0x7580, 0xb541, 0x7700, 0xb7c1, 0xb681, 0x7640, 0x7200, 0xb2c1, 0xb381, 0x7340, 0xb101, 0x71c0, 0x7080, 0xb041, 0x5000, 0x90c1, 0x9181, 0x5140, 0x9301, 0x53c0, 0x5280, 0x9241, 0x9601, 0x56c0, 0x5780, 0x9741, 0x5500, 0x95c1, 0x9481, 0x5440, 0x9c01, 0x5cc0, 0x5d80, 0x9d41, 0x5f00, 0x9fc1, 0x9e81, 0x5e40, 0x5a00, 0x9ac1, 0x9b81, 0x5b40, 0x9901, 0x59c0, 0x5880, 0x9841, 0x8801, 0x48c0, 0x4980, 0x8941, 0x4b00, 0x8bc1, 0x8a81, 0x4a40, 0x4e00, 0x8ec1, 0x8f81, 0x4f40, 0x8d01, 0x4dc0, 0x4c80, 0x8c41, 0x4400, 0x84c1, 0x8581, 0x4540, 0x8701, 0x47c0, 0x4680, 0x8641, 0x8201, 0x42c0, 0x4380, 0x8341, 0x4100, 0x81c1, 0x8081, 0x4040};

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
                pwdItem[dfc + li - nic] = defile[dfc];
                dfc++;
            }
            pwdItems.add(pwdItem);
        }

        return pwdItems;
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

        int sum = 0xFFFF;

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
            sum = (sum >> 8) ^ CRC16_TABLE[((sum) ^ ((int) d & 0xff)) & 0xff];
            byte e = (byte) (d ^ k);
            e = (byte) (e ^ mpk);
            ehs = Integer.toHexString(e & 0xFF) + "|";
            enfile += ehs;
        }

        byte sbl = (byte) sum;
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
        byte e = (byte) (sbl ^ k);
        e = (byte) (e ^ mpk);
        ehs = Integer.toHexString(e & 0xFF) + "|";
        enfile += ehs;

        byte sbh = (byte) (sum >>> 8);
        k = key[kc];
        mpk = MasterPassword.getBytes()[mpc];
        e = (byte) (sbh ^ k);
        e = (byte) (e ^ mpk);
        ehs = Integer.toHexString(e & 0xFF) + "|";
        enfile += ehs;

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

        byte sbl = defile.get(defile.size() - 2);
        byte sbh = defile.get(defile.size() - 1);
        int sum = ((sbh & 0xFF) * 256 + (sbl & 0xFF)) & 0xFFFF;
        defile.remove(defile.size() - 1);
        defile.remove(defile.size() - 1);

        byte[] debytes = new byte[defile.size()];
        for (int i = 0; i < defile.size(); i++) {
            debytes[i] = defile.get(i);
        }

        int sumde = 0xFFFF;
        for (byte db : debytes) {
            sumde = (sumde >> 8) ^ CRC16_TABLE[((sumde) ^ ((int) db & 0xff)) & 0xff];
        }

        if (sum == sumde) {
            return debytes;
        } else {
            return null;
        }
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
