package org.maxsys.mypwd;

public class PwdStr {

    private final String pwd;
    private boolean Hided = true;

    public PwdStr(String pwd) {
        this.pwd = pwd;
    }

    public boolean isHided() {
        return Hided;
    }

    public void Hide() {
        this.Hided = true;
    }

    public void Show() {
        this.Hided = false;
    }

    public String getPwd() {
        return this.pwd;
    }

    @Override
    public String toString() {
        if (this.Hided) {
            return "*******";
        } else {
            return this.pwd;
        }
    }
}
