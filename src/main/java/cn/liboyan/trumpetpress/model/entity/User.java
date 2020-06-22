package cn.liboyan.trumpetpress.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
public class User implements Serializable {
    private static final long serialVersionUID = 987178322925872408L;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 用户IP
    */
    private String userIp;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户密码
    */
    private String userPassword;
    /**
    * 用户性别 1男 0女
    */
    private Object userSex;
    /**
    * 用户邮箱
    */
    private String userEmail;
    /**
    * 手机号码
    */
    private String userPhone;
    /**
    * 头像地址
    */
    private String userAvatar;
    /**
    * 是否是管理员 1是 0不是
    */
    private Integer userIsAdmin;
    /**
    * 上一次登录时间
    */
    private Date userLastLogin;
    /**
    * 用户注册时间
    */
    private Date userRegisterTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Object getUserSex() {
        return userSex;
    }

    public void setUserSex(Object userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Integer getUserIsAdmin() {
        return userIsAdmin;
    }

    public void setUserIsAdmin(Integer userIsAdmin) {
        this.userIsAdmin = userIsAdmin;
    }

    public Date getUserLastLogin() {
        return userLastLogin;
    }

    public void setUserLastLogin(Date userLastLogin) {
        this.userLastLogin = userLastLogin;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

}