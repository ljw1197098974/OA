package com.oa.frame.service;

import com.oa.frame.bean.Result;
import com.oa.frame.bean.SDObject;
import com.oa.frame.service.Iservive.FuncCode;

public interface Iservice {
    String _ISCACHE = "_ISCACHE";
    String _CACHETIME = "_CACHETIME";

    void execute(SDObject var1, Result var2);

    void loadConfig();

    FuncCode getFuncCode(String var1) throws Exception;
}
