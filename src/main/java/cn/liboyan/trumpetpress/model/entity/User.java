package cn.liboyan.trumpetpress.model.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
@Data
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

}