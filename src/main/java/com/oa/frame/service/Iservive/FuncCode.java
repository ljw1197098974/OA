package com.oa.frame.service.Iservive;

import com.oa.frame.service.Iservice;

public class FuncCode {
    private String funccode;
    private boolean isNoRight;
    private Iservice service;
    private String sqlKey;

    public FuncCode() {
    }

    public String getFunccode() {
        return this.funccode;
    }

    public void setFunccode(String funccode) {
        this.funccode = funccode;
    }

    public boolean isNoRight() {
        return this.isNoRight;
    }

    public void setNoRight(boolean isNoRight) {
        this.isNoRight = isNoRight;
    }

    public Iservice getService() {
        return this.service;
    }

    public void setService(Iservice service) {
        this.service = service;
    }

    public String getSqlKey() {
        return this.sqlKey;
    }

    public void setSqlKey(String sqlKey) {
        this.sqlKey = sqlKey;
    }
}
