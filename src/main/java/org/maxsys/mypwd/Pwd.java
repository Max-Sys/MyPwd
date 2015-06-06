package org.maxsys.mypwd;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public final class Pwd {

    private final String h_name;
    private final LinkedHashMap<String, String> h_fields;

    public Pwd(String name) {
        this.h_name = Vars.getHexString(name);
        this.h_fields = new LinkedHashMap<>();
    }

    public Pwd(byte[] pwdItem) {
        int ic = 2;
        byte[] lb = new byte[2];
        int li;

        lb[0] = pwdItem[0];
        lb[1] = pwdItem[1];
        li = GetLengthInInt(lb);

        String ns = "";
        while (ic < (2 + li)) {
            ns += (char) pwdItem[ic];
            ic++;
        }
        this.h_name = ns;

        this.h_fields = new LinkedHashMap<>();

        while (ic < pwdItem.length) {
            lb[0] = pwdItem[ic];
            ic++;
            lb[1] = pwdItem[ic];
            ic++;
            li = GetLengthInInt(lb);
            int nic = ic + li;
            String fn = "";
            while (ic < nic) {
                fn += (char) pwdItem[ic];
                ic++;
            }
            lb[0] = pwdItem[ic];
            ic++;
            lb[1] = pwdItem[ic];
            ic++;
            li = GetLengthInInt(lb);
            nic = ic + li;
//            byte[] fi = new byte[li];
//            while (ic < nic) {
//                fi[ic + li - nic] = pwdItem[ic];
//                ic++;
//            }
            String fi = "";
            while (ic < nic) {
                fi += (char) pwdItem[ic];
                ic++;
            }
            this.h_fields.put(fn, fi);
        }
    }

    public void setField(String fieldName, String fieldValue) {
        this.h_fields.put(Vars.getHexString(fieldName), Vars.getHexString(fieldValue));
    }

    public String getField(String fieldName) {
        return Vars.getStringFromHex(this.h_fields.get(Vars.getHexString(fieldName)));
    }

    public String[] getFieldNames() {
        String[] names = new String[this.h_fields.size()];
        int i = 0;
        for (String s : this.h_fields.keySet()) {
            names[i] = Vars.getStringFromHex(s);
            i++;
        }
        return names;
    }

    public byte[] getPwdItem() {
        ArrayList<Byte> bItem = new ArrayList<>();
        byte[] nl = GetLengthInBytes(this.h_name.getBytes().length);

        bItem.add(nl[0]);
        bItem.add(nl[1]);
        for (byte b : this.h_name.getBytes()) {
            bItem.add(b);
        }

        for (String fn : this.h_fields.keySet()) {
            byte[] ekl = GetLengthInBytes(fn.getBytes().length);
            bItem.add(ekl[0]);
            bItem.add(ekl[1]);
            for (byte b : fn.getBytes()) {
                bItem.add(b);
            }
            byte[] evl = GetLengthInBytes(this.h_fields.get(fn).getBytes().length);
            bItem.add(evl[0]);
            bItem.add(evl[1]);
            for (byte b : this.h_fields.get(fn).getBytes()) {
                bItem.add(b);
            }
        }

        byte[] baItem = new byte[bItem.size()];
        for (int i = 0; i < bItem.size(); i++) {
            baItem[i] = bItem.get(i);
        }

        return baItem;
    }

    public static byte[] GetLengthInBytes(int length) {
        int h = length / 256;
        int l = length - h * 256;
        byte[] b = new byte[2];
        b[0] = (byte) l;
        b[1] = (byte) h;
        return b;
    }

    public static int GetLengthInInt(byte[] length) {
        int len = (length[0] & 0xFF) + (length[1] & 0xFF) * 256;
        return len;
    }

    public String getName() {
        return Vars.getStringFromHex(this.h_name);
    }

    @Override
    public String toString() {
        return Vars.getStringFromHex(this.h_name);
    }
}
