package com.oa.frame.bean;

import com.oa.util.ValidateUtil;

import java.io.Serializable;
import java.util.*;

public class SDObject implements Serializable {
    private static final long serialVersionUID = 3433482304257237262L;
    private Map<String, Object> paramMap = new HashMap();
    private String funcCode;
    private boolean isLogin;
    private String ipAdress;
    private UserInfo operator;
    private String requestChannel;
    private String path;
    private String basePath;
    private String sessionId;
    private String userAgent;
    private Map<String, Cookie> cookies = new HashMap();
    private int pagesize = 0;
    private int pageindex = 0;

    public SDObject() {
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Cookie getCookie(String cookName) {
        return (Cookie)this.cookies.get(cookName);
    }

    public void setCookies(javax.servlet.http.Cookie... cookies) {
        javax.servlet.http.Cookie[] var2 = cookies;
        int var3 = cookies.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            javax.servlet.http.Cookie cookie = var2[var4];
            String name = cookie.getName();
            name = (String)ValidateUtil.canonicalize(name);
            name = (String)ValidateUtil.validateObject(name);
            String value = cookie.getValue();
            value = (String)ValidateUtil.canonicalize(value);
            value = (String)ValidateUtil.validateObject(value);
            String comment = cookie.getComment();
            comment = (String)ValidateUtil.canonicalize(comment);
            comment = (String)ValidateUtil.validateObject(comment);
            String domain = cookie.getDomain();
            domain = (String)ValidateUtil.canonicalize(domain);
            domain = (String)ValidateUtil.validateObject(domain);
            int maxage = cookie.getMaxAge();
            maxage = (Integer)ValidateUtil.canonicalize(maxage);
            maxage = (Integer)ValidateUtil.validateObject(maxage);
            Cookie item = new Cookie(name, value);
            if (comment != null) {
                item.setComment(comment);
            }

            if (domain != null) {
                item.setDomain(domain);
            }

            item.setMaxAge(maxage);
            if (cookie.getPath() != null) {
                item.setPath(cookie.getPath());
            }

            item.setSecure(cookie.getSecure());
            item.setVersion(cookie.getVersion());
            this.cookies.put(name, item);
        }

    }

    public List<Cookie> getCookies() {
        Set<String> keys = this.cookies.keySet();
        List<Cookie> cookies = new ArrayList();
        Iterator var3 = keys.iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();
            cookies.add(this.cookies.get(key));
        }

        return cookies;
    }

    public Map<String, Object> getParamMap() {
        return this.paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public void setParamValue(String key, Object value) {
        this.paramMap.put(key, value);
    }

    public void putParamMap(Map<String, Object> map) {
        this.paramMap.putAll(map);
    }

    public String getFuncCode() {
        return this.funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getIpAdress() {
        return this.ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public UserInfo getOperator() {
        return this.operator;
    }

    public void setOperator(UserInfo operator) {
        this.operator = operator;
    }

    public String getRequestChannel() {
        return this.requestChannel;
    }

    public void setRequestChannel(String requestChannel) {
        this.requestChannel = requestChannel;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBasePath() {
        return this.basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPageindex() {
        return this.pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
