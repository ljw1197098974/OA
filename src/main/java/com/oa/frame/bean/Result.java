package com.oa.frame.bean;

import com.oa.util.ValidateUtil;

import java.io.Serializable;
import java.util.*;

public class Result implements Serializable {

    private static final long serialVersionUID = 1952221350426744873L;
    public static final int _DEFAULT_ERRCODE_SUCCESS = 0;
    public static final int _DEFAULT_ERRCODE_FAILED = -1000;
    public static final String _DEFAULT_ERRMSG_SUCCESS = "操作成功!";
    public static final String _DEFAULT_ERRMSG_FAILED = "操作失败!";
    private Map<String, Object> resultMap = new HashMap();
    private String errMsg = "操作失败!";
    private int errCode = -1000;
    private String funcCode;
    private boolean hasException = false;
    private String exceptionMessage;
    private String binaryKeyName;
    private String redirctUrl;
    private String forwardUrl;
    private boolean viewPdf = false;
    private Map<String, Cookie> cookies = new HashMap();
    private String binaryFileName;
    private String printStr;

    public Result() {
    }

    public boolean getViewPdf() {
        return this.viewPdf;
    }

    public void setViewPdf(boolean viewPdf) {
        this.viewPdf = viewPdf;
    }

    public void setCookies(Cookie... cookies) {
        Cookie[] var2 = cookies;
        int var3 = cookies.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Cookie cookie = var2[var4];
            String name = cookie.getName();
            name = (String) ValidateUtil.canonicalize(name);
            name = (String)ValidateUtil.validateObject(name);
            this.cookies.put(name, cookie);
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

    public String getBinaryKeyName() {
        return this.binaryKeyName;
    }

    public void setBinaryKeyName(String binaryKeyName) {
        this.binaryKeyName = binaryKeyName;
    }

    public String getBinaryFileName() {
        return this.binaryFileName;
    }

    public String getPrintStr() {
        return this.printStr;
    }

    public void setPrintStr(String printStr) {
        this.printStr = printStr;
    }

    public void setBinaryFileName(String binaryFileName) {
        this.binaryFileName = binaryFileName;
    }

    public boolean isHasException() {
        return this.hasException;
    }

    public void setHasException(boolean hasException) {
        this.hasException = hasException;
        if (hasException) {
            this.errCode = -1000;
        }

    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.hasException = true;
        this.errCode = -1000;
        this.exceptionMessage = exceptionMessage;
    }

    public void setResultField(String key, Object value) {
        this.resultMap.put(key, value);
    }

    public Map<String, Object> getResultMap() {
        return this.resultMap;
    }

    public Object getResultField(String key) {
        return this.resultMap.get(key);
    }

    public void setResultMap(Map<String, Object> resultMap) {
        if (resultMap != null) {
            this.resultMap.putAll(resultMap);
        }

    }

    public String getErrMsg() {
        if (this.errMsg.indexOf("bad SQL") > 0 || this.errMsg.indexOf("java.sql.SQLException") != -1) {
            this.errMsg = "操作失败!";
        }

        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getFuncCode() {
        return this.funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public boolean isSuccess() {
        return this.errCode == 0;
    }

    public String getRedirctUrl() {
        return this.redirctUrl;
    }

    public void setRedirctUrl(String redirctUrl) {
        this.redirctUrl = redirctUrl;
    }

    public String getForwardUrl() {
        return this.forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

}
