package org.maxsys.mypwd;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public final class Pwd {

    private final String name;
    private final LinkedHashMap<String, byte[]> fields;

    public Pwd(String name) {
        this.name = name;
        this.fields = new LinkedHashMap<>();
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
        this.name = ns;

        this.fields = new LinkedHashMap<>();

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
            byte[] fi = new byte[li];
            while (ic < nic) {
                fi[ic + li - nic] = pwdItem[ic];
                ic++;
            }
            setField(fn, fi);
        }
    }

    public void setField(String fieldName, byte[] fieldValue) {
        this.fields.put(fieldName, fieldValue);
    }

    public byte[] getField(String fieldName) {
        return this.fields.get(fieldName);
    }

    public String[] getFieldNames() {
        String[] names = new String[this.fields.size()];
        int i = 0;
        for (String s : this.fields.keySet()) {
            names[i] = s;
            i++;
        }
        return names;
    }

    public byte[] getPwdItem() {
        ArrayList<Byte> bItem = new ArrayList<>();
        byte[] nl = GetLengthInBytes(this.name.getBytes().length);
        bItem.add(nl[0]);
        bItem.add(nl[1]);
        for (byte b : this.name.getBytes()) {
            bItem.add(b);
        }

        for (String fn : this.fields.keySet()) {
            byte[] ekl = GetLengthInBytes(fn.getBytes().length);
            bItem.add(ekl[0]);
            bItem.add(ekl[1]);
            for (byte b : fn.getBytes()) {
                bItem.add(b);
            }
            byte[] evl = GetLengthInBytes(getField(fn).length);
            bItem.add(evl[0]);
            bItem.add(evl[1]);
            for (byte b : getField(fn)) {
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

    @Override
    public String toString() {
        return this.name;
    }
}
