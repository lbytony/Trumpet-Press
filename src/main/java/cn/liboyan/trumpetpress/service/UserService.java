package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:12
 */
public interface UserService {
    /**
     * 验证用户名和密码
     */
    public User checkUser(String username, String password);

}