package org.maxsys.mypwd;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pwd {

    private final String name;
    private final LinkedHashMap<String, byte[]> fields;

    public Pwd(String name) {
        this.name = name;
        this.fields = new LinkedHashMap<>();
    }

    public Pwd(byte[] pwdItem) {
        this.name = "";
        this.fields = new LinkedHashMap<>();
    }

    public void addField(String fieldName, byte[] fieldValue) {
        this.fields.put(fieldName, fieldValue);
    }

    public byte[] getField(String fieldName) {
        return this.fields.get(fieldName);
    }

    public byte[] getPwdItem() {
        ArrayList<Byte> bItem = new ArrayList<>();
        byte[] nl = GetLengthInBytes(this.name.getBytes().length);
        bItem.add(nl[0]);
        bItem.add(nl[1]);
        for (byte b : this.name.getBytes()) {
            bItem.add(b);
        }

        for (Map.Entry<String, byte[]> entry : this.fields.entrySet()) {
            byte[] ekl = GetLengthInBytes(entry.getKey().getBytes().length);
            bItem.add(ekl[0]);
            bItem.add(ekl[1]);
            for (byte b : entry.getKey().getBytes()) {
                bItem.add(b);
            }
            byte[] evl = GetLengthInBytes(entry.getValue().length);
            bItem.add(evl[0]);
            bItem.add(evl[1]);
            for (byte b : entry.getValue()) {
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
}
