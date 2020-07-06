package o2oboot.service.impl;

import o2oboot.dao.UserDao;
import o2oboot.entity.User;
import o2oboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
;import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int checkUserSingIn(String userId, String password) {
        return userDao.queryUserSignIn(userId,password);
    }

    @Override
    public int checkUserId(String userId) {
        return userDao.queryUserById(userId);
    }

    @Override
    public User getUserDetail(String userId) {
        return userDao.queryUser(userId);
    }

    @Override
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }
}
