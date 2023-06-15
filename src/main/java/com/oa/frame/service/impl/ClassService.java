package com.oa.frame.service.impl;

import com.oa.frame.bean.FuncCache;
import com.oa.frame.bean.Result;
import com.oa.frame.bean.SDObject;
import com.oa.frame.service.Iservice;
import com.oa.frame.service.Iservive.FuncCode;
import com.oa.util.DateTimeUtil;
import com.oa.util.NumberUtil;
import com.oa.util.StringUtil;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class ClassService {

    //private static Logger logger = Logger.getLogger(ClassService.class);
    private static Map<String, FuncCode> classMap = new HashMap();
    private static Map<String, FuncCache> cache = new HashMap();
    private Map<String, String> attr;
    private String filepath;

    public ClassService() {
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void execute(SDObject sdo, Result result) {
        Map<String, Object> pMap = new HashMap();
        pMap.putAll(sdo.getParamMap());
        FuncCode funccode = (FuncCode)classMap.get(sdo.getFuncCode());
        if (null == funccode) {
            result.setErrCode(-1);
            result.setErrMsg("C功能号配置文件里面未能获取到功能号【" + sdo.getFuncCode() + "】");
        } else {
            String sessionId = sdo.getSessionId();
            String cacheKey = sessionId + "_" + sdo.getFuncCode();
            FuncCache funcCache = (FuncCache)cache.get(cacheKey);
            if (null != funcCache) {
                try {
                    if (funcCache.isOverdue(sdo.getParamMap())) {
                        result.setResultField("_CACHETIME1", DateTimeUtil.getToday("yyyy-MM-dd HH:mm"));
                        funcCache.setsMap(pMap);
                        funccode.getService().execute(sdo, result);
                        funcCache.setResult(result);
                    } else {
                        Result cacheResult = funcCache.getResult();
                        result.setBinaryFileName(cacheResult.getBinaryFileName());
                        result.setBinaryKeyName(cacheResult.getBinaryKeyName());
                        result.setErrCode(cacheResult.getErrCode());
                        result.setErrMsg(cacheResult.getErrMsg());
                        result.setForwardUrl(cacheResult.getForwardUrl());
                        result.setFuncCode(cacheResult.getFuncCode());
                        result.setHasException(cacheResult.isHasException());
                        result.setPrintStr(cacheResult.getPrintStr());
                        result.setRedirctUrl(cacheResult.getRedirctUrl());
                        result.setResultMap(cacheResult.getResultMap());
                    }
                } catch (UnsupportedEncodingException var10) {
                    //logger.error("获取MD5失败！", var10);
                    result.setErrMsg("获取MD5失败！");
                }
            } else {
                result.setResultField("_CACHETIME1", DateTimeUtil.getToday("yyyy-MM-dd HH:mm"));
                funccode.getService().execute(sdo, result);
                int isCache = NumberUtil.convertToInt(result.getResultField("_ISCACHE"));
                if (1 == isCache) {
                    FuncCache item = new FuncCache();
                    item.setResult(result);
                    item.setsMap(pMap);
                    cache.put(cacheKey, item);
                }
            }

        }
    }

    public static void cacheDestroyed(String sessionId) {
        Set<String> keys = cache.keySet();
        Iterator var2 = keys.iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            if (key.indexOf(sessionId) != -1) {
                cache.remove(key);
                break;
            }
        }

    }

    public static Iservice getFunObject(String funcCode) {
        return null != classMap.get(funcCode) ? ((FuncCode)classMap.get(funcCode)).getService() : null;
    }

    public FuncCode getFuncCode(String funcCode) throws Exception {
        if (null == classMap.get(funcCode)) {
            throw new Exception("配置文件里面未能获取到功能号【" + funcCode + "】");
        } else {
            return (FuncCode)classMap.get(funcCode);
        }
    }

    public void loadConfig() {
        Properties prop = new Properties();

        try {
            File configFolder = new File(this.getClass().getResource(this.filepath).getPath());
            File[] files = configFolder.listFiles();
            String extension = "";
            String classPath = "";
            File[] var6 = files;
            int var7 = files.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                File itemFile = var6[var8];
                extension = FilenameUtils.getExtension(itemFile.getName());
                if (extension.equals("properties")) {
                    prop.load(new FileInputStream(itemFile));
                    Iterator var10 = prop.keySet().iterator();

                    while(var10.hasNext()) {
                        Object each = var10.next();
                        if (classMap.containsKey(each)) {
                            //logger.warn("功能号" + each + "被重复加载，请查询ClassService的配置文件");
                        }

                        try {
                            boolean isNoRight = false;
                            classPath = StringUtil.convertToString(prop.get(each)).trim();
                            if (classPath.indexOf(":noright") > 0) {
                                isNoRight = true;
                                classPath = classPath.substring(0, classPath.indexOf(":noright"));
                            }

                            FuncCode fn = new FuncCode();
                            fn.setFunccode(StringUtil.convertToString(each));
                            fn.setNoRight(isNoRight);
                            fn.setService((Iservice)((Iservice)Class.forName(classPath).newInstance()));
                            classMap.put((String)each, fn);
                        } catch (ClassNotFoundException var14) {
                            //logger.error("功能号" + each + "对应的class：" + prop.get(each) + "不存在", var14);
                        } catch (InstantiationException var15) {
                            //logger.error("功能号" + each + "对应的class：" + prop.get(each) + "实例化时异常", var15);
                        } catch (IllegalAccessException var16) {
                            //logger.error("访问功能号" + each + "对应的class：" + prop.get(each) + "时出现权限异常", var16);
                        }
                    }

                    prop.clear();
                }
            }
        } catch (IOException var17) {
            //logger.error("加载c资源文件异常！原因：", var17);
        }

    }

    public Map<String, String> getAttr() {
        return this.attr;
    }

    public void setAttr(Map<String, String> attr) {
        this.attr = attr;
    }

}
