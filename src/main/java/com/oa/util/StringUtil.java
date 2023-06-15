package com.oa.util;

import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.sql.Clob;
import java.util.*;

public class StringUtil {

    //private static Logger logger = Logger.getLogger(StringUtil.class);

    public StringUtil() {
    }

    public static void clob2Str(List<? extends Object> list) {
        if (null != list && list.size() > 0) {
            Iterator var1 = list.iterator();

            while(true) {
                Object obj;
                do {
                    if (!var1.hasNext()) {
                        return;
                    }

                    obj = var1.next();
                } while(!(obj instanceof Map));

                Map<String, Object> item = (Map)obj;
                Set<String> keys = item.keySet();
                Iterator var5 = keys.iterator();

                while(var5.hasNext()) {
                    String key = (String)var5.next();
                    Object v = item.get(key);
                    if (v instanceof Clob) {
                        item.put(key, convertToString(v));
                    }
                }
            }
        }
    }

    public static void clob2Str(Object obj) {
        if (null != obj) {
            if (obj instanceof Map) {
                Map item = (Map)obj;
                Set<String> keys = item.keySet();
                Iterator var3 = keys.iterator();

                while(var3.hasNext()) {
                    String key = (String)var3.next();
                    Object v = item.get(key);
                    if (v instanceof Clob) {
                        item.put(key, convertToString(v));
                    }
                }
            }

        }
    }

    public static String convertToString(Object obj) {
        String result = "";
        if (obj != null) {
            if (obj instanceof Clob) {
                try {
                    Clob clob = (Clob)obj;
                    result = clob.getSubString(1L, NumberUtil.convertToInt(clob.length()));
                } catch (Exception var3) {
                    result = var3.getMessage();
                }
            } else {
                result = obj.toString();
            }
        }

        return result;
    }

    public static boolean isChineseCharacter(String chineseStr) {
        char[] charArray = chineseStr.toCharArray();

        for(int i = 0; i < charArray.length; ++i) {
            if (charArray[i] >= 19968 && charArray[i] <= '龻') {
                return true;
            }
        }

        return false;
    }

    public static String BASE64DecoderString(String s) {
        byte[] b = BASE64Decoder(s);
        return new String(b);
    }

    public static String BASE64Encoder(String s) throws UnsupportedEncodingException {
        byte[] b = s.getBytes("utf-8");
        return BASE64Encoder(b);
    }

    public static String BASE64Encoder(byte[] b) {
        return b != null && b.length > 0 ? (new BASE64Encoder()).encode(b) : null;
    }

    public static byte[] BASE64Decoder(String s) {
        try {
            if (s != null) {
                return (new BASE64Decoder()).decodeBuffer(s);
            }
        } catch (IOException var2) {
            //logger.error("", var2);
        }

        return null;
    }

    public static String paramList2str(Collection list) {
        return JSONArray.fromObject(list).toString().replaceAll("\"", "'").replace("[", "").replace("]", "");
    }

    public static String list2str(Collection list) {
        return list2str(list, ",");
    }

    public static String dhstrtrim(String str, String splitstr) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(str)) {
            String[] ss = str.split(splitstr);
            String[] var4 = ss;
            int var5 = ss.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String s = var4[var6];
                sb.append(s.trim());
                sb.append(splitstr);
            }

            if (sb.length() > 0) {
                sb.delete(sb.lastIndexOf(splitstr), sb.length());
            }
        }

        return sb.toString();
    }

    public static String dhstrtrim(String str) {
        return dhstrtrim(str, ",");
    }

    public static String list2str(Collection list, String splitstr) {
        StringBuilder sb = new StringBuilder();
        if (null != list && list.size() > 0) {
            Iterator iterator = list.iterator();

            while(iterator.hasNext()) {
                String item = convertToString(iterator.next());
                sb.append(item);
                sb.append(splitstr);
            }

            if (sb.length() > 0) {
                sb.delete(sb.lastIndexOf(splitstr), sb.length());
            }
        }

        return sb.toString();
    }

    public static List<String> str2list(String str) {
        return str2list(str, ",");
    }

    public static List<String> str2list(String str, String splitstr) {
        String[] strs = str.split(splitstr);
        return Arrays.asList(strs);
    }

    public static String html2Text(String html) {
        String ret = html.replaceAll("&[^;]*;", "");
        ret = ret.replaceAll("<[^>]*>", "");
        return ret;
    }

    public static String getLineSeparator() {
        String ret = (String)ValidateUtil.canonicalize(System.getProperty("line.separator"));
        ret = (String)ValidateUtil.validateObject(ret);
        return ret;
    }

    public static String getRandomString(int length) {
        StringBuilder ret = new StringBuilder();
        SecureRandom ran = new SecureRandom();
        if (length > 0) {
            for(int i = 0; i < length; ++i) {
                int num = (int)(ran.nextDouble() * 10.0);
                ret.append(num);
            }
        }

        return ret.toString();
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

}
