package com.oa.frame.bean;

import com.oa.util.DateTimeUtil;
import com.oa.util.MD5Util;
import com.oa.util.NumberUtil;
import com.oa.util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class FuncCache {

    private Map<String, Object> sMap;
    private Result result;

    public FuncCache() {
    }

    public Map<String, Object> getsMap() {
        return this.sMap;
    }

    public void setsMap(Map<String, Object> sMap) {
        this.sMap = sMap;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isOverdue(Map<String, Object> pMap) throws UnsupportedEncodingException {
        boolean ret = false;
        String currentMapMD5 = MD5Util.getMD5String(pMap.toString());
        String thisMapMD5 = MD5Util.getMD5String(this.sMap.toString());
        int m = NumberUtil.convertToInt(this.result.getResultField("_CACHETIME"));
        String startDate = StringUtil.convertToString(this.result.getResultField("_CACHETIME1"));
        String endDate = DateTimeUtil.getToday("yyyy-MM-dd HH:mm");
        if (startDate.length() > 0 && endDate.length() > 0) {
            int n = DateTimeUtil.havaMinutes(startDate, endDate, "yyyy-MM-dd HH:mm");
            if (!thisMapMD5.equals(currentMapMD5) || n >= m) {
                ret = true;
            }
        }

        return ret;
    }

}
