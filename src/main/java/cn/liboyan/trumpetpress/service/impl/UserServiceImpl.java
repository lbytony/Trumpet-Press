package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.model.entity.User;
import cn.liboyan.trumpetpress.model.dao.UserDao;
import cn.liboyan.trumpetpress.service.UserService;
import cn.liboyan.trumpetpress.utils.Md5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:13
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        return userDao.queryByUsernameAndPassword(username, Md5Utils.md5(password));
    }
}