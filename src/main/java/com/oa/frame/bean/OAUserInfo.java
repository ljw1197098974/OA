package com.oa.frame.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OAUserInfo implements Serializable {
    private String userId;
    private String userName;
    private String loginName;
    private String userType;
    private String userStatus;
    private String deptId;
    private String deptName;
    private String passWord;
    private String passwordErrorDateTime;
    private String passwordErrorNum;
    private String post;
    private String spellIng;
    private String isAddressBook;
    private String qq;
    private String phoneNumber;
    private String eMail;
    private String genDer;
    private String creationDateTime;


    private List<String> deptIds;

    private String root;

    private String ip;

    private Map<String, List<Object>> permissions = new HashMap();
    private Map<String, Object> sessionMap = new HashMap();

    public OAUserInfo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPasswordErrorDateTime() {
        return passwordErrorDateTime;
    }

    public void setPasswordErrorDateTime(String passwordErrorDateTime) {
        this.passwordErrorDateTime = passwordErrorDateTime;
    }

    public String getPasswordErrorNum() {
        return passwordErrorNum;
    }

    public void setPasswordErrorNum(String passwordErrorNum) {
        this.passwordErrorNum = passwordErrorNum;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSpellIng() {
        return spellIng;
    }

    public void setSpellIng(String spellIng) {
        this.spellIng = spellIng;
    }

    public String getIsAddressBook() {
        return isAddressBook;
    }

    public void setIsAddressBook(String isAddressBook) {
        this.isAddressBook = isAddressBook;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGenDer() {
        return genDer;
    }

    public void setGenDer(String genDer) {
        this.genDer = genDer;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public List<String> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
}
