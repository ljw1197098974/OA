package com.oa.frame.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, String> portalOptions;
    private List<Map<String, Object>> userPortalAlert;
    private String loginName;
    private String passWord;
    private String userId;
    private String userName;
    private String mobile;
    private String deptId;
    private String realDeptId;
    private List<String> deptIds;
    private List<String> roles;
    private List<String> depts = new ArrayList();
    private List<String> deptIdL1 = new ArrayList();
    private List<String> deptIdL2 = new ArrayList();
    private String positionInfo;
    private String deptName;
    private Map<String, List<Object>> permissions = new HashMap();
    private String eKey;
    private String root;
    private String rootName;
    private String server;
    private Map<String, Object> sessionMap = new HashMap();
    private int screenWidth;
    private int screenHeight;
    private int loginCount;
    private String clientinfo;
    private List<String> groups;
    private String groupStrs;
    private String ip;
    private String authorizer;
    private Map<String, Object> extAttr = new HashMap();

    public UserInfo() {
    }

    public String getPositionInfo() {
        return this.positionInfo;
    }

    public void setPositionInfo(String positionInfo) {
        this.positionInfo = positionInfo;
    }

    public List<String> getDeptIdL2() {
        List<String> ret = new ArrayList();
        ret.addAll(this.deptIdL2);
        return ret;
    }

    public void setDeptIdL2(List<String> deptIdL2) {
        this.deptIdL2 = deptIdL2;
    }

    public List<String> getGroups() {
        List<String> ret = new ArrayList();
        if (this.groups != null) {
            ret.addAll(this.groups);
        }

        return ret;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public String getGroupStrs() {
        return this.groupStrs;
    }

    public void setGroupStrs(String groupStrs) {
        this.groupStrs = groupStrs;
    }

    public String getAuthorizer() {
        return this.authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public int getLoginCount() {
        return this.loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, List<Object>> getPermissions() {
        Map<String, List<Object>> ret = new HashMap();
        ret.putAll(this.permissions);
        return ret;
    }

    public void setUserFunc(List<Object> userFunc) {
        this.permissions.put("FUNCLIST", userFunc);
    }

    public void setUserMenu(List<Object> userMenu) {
        this.permissions.put("MENULIST", userMenu);
    }

    public String geteKey() {
        return this.eKey;
    }

    public void seteKey(String eKey) {
        this.eKey = eKey;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return this.deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setExtAttr(String attrName, Object attrValue) {
        this.extAttr.put(attrName, attrValue);
    }

    public Map<String, Object> getExtAttr() {
        Map<String, Object> ret = new HashMap();
        ret.putAll(this.extAttr);
        return ret;
    }

    public void removeExtAttr(String attrName) {
        this.extAttr.remove(attrName);
    }

    public Object getExtAttr(String attrName) {
        return this.extAttr.get(attrName);
    }

    public String getRoot() {
        return this.root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getRootName() {
        return this.rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setSessionMap(String key, Object value) {
        this.sessionMap.put(key, value);
    }

    public Map<String, Object> getSessionMap() throws Exception {
        if (this.userId == null) {
            throw new Exception("Session丢失，请重新登录！");
        } else {
            Map<String, Object> ret = new HashMap();
            ret.putAll(this.sessionMap);
            return ret;
        }
    }

    public Object getSessionMap(String key) {
        return this.sessionMap.get(key);
    }

    public List<String> getDepts() {
        List<String> ret = new ArrayList();
        ret.addAll(this.depts);
        return ret;
    }

    public void setDepts(List<String> depts) {
        this.depts = depts;
    }

    public List<String> getDeptIdL1() {
        List<String> ret = new ArrayList();
        ret.addAll(this.deptIdL1);
        return ret;
    }

    public void setDeptIdL1(List<String> deptIdL1) {
        this.deptIdL1 = deptIdL1;
    }

    public Map<String, String> getPortalOptions() {
        return this.portalOptions;
    }

    public void setPortalOptions(Map<String, String> portalOptions) {
        this.portalOptions = portalOptions;
    }

    public List<Map<String, Object>> getUserPortalAlert() {
        List<Map<String, Object>> ret = new ArrayList();
        ret.addAll(this.userPortalAlert);
        return ret;
    }

    public void setUserPortalAlert(List<Map<String, Object>> userPortalAlert) {
        this.userPortalAlert = userPortalAlert;
    }

    public String getClientinfo() {
        return this.clientinfo;
    }

    public void setClientinfo(String clientinfo) {
        this.clientinfo = clientinfo;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<String> getDeptIds() {
        return this.deptIds;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
    }

    public List<String> getRoles() {
        List<String> ret = new ArrayList();
        ret.addAll(this.roles);
        return ret;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getRealDeptId() {
        return this.realDeptId;
    }

    public void setRealDeptId(String realDeptId) {
        this.realDeptId = realDeptId;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
