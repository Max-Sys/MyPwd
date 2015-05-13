package org.maxsys.mypwd;

import java.util.HashMap;

public class Pwd {

    private final int id;
    private final String name;
    private HashMap<String, byte[]> fields;

    public Pwd(int id, String name, byte[] pwdbody) {
        this.id = id;
        this.name = name;
    }

}
