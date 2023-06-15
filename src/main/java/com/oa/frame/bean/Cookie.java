package com.oa.frame.bean;

import com.oa.util.DateTimeUtil;
import com.oa.util.ValidateUtil;

import java.util.Locale;

public class Cookie extends javax.servlet.http.Cookie {

    private boolean httpOnly;

    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public Cookie(String name, String value) {
        super(name, value);
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        String name = (String) ValidateUtil.canonicalize(this.getName());
        name = (String) ValidateUtil.validateObject(name);
        String value = (String) ValidateUtil.canonicalize(this.getValue());
        value = (String) ValidateUtil.validateObject(value);
        String path = (String) ValidateUtil.canonicalize(this.getPath());
        path = (String) ValidateUtil.validateObject(path);
        int maxAge = (Integer) ValidateUtil.canonicalize(this.getMaxAge());
        maxAge = (Integer) ValidateUtil.validateObject(maxAge);
        ret.append(name);
        ret.append("=");
        ret.append(value);
        ret.append("; ");
        ret.append("Path=");
        ret.append(path);
        ret.append("; ");
        if (maxAge > 0) {
            ret.append("Max-Age=");
            ret.append(maxAge);
            ret.append("; ");
            ret.append("Expires=" + DateTimeUtil.addSecondsByNow(maxAge, "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US) + "; ");
        }

        if (this.httpOnly) {
            ret.append("HttpOnly");
        }

        return ret.toString();
    }

}
