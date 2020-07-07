package o2oboot.service;

import o2oboot.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    int checkUserSingIn(String userId, String password);

    int checkUserId(String userName);

    User getUserDetail(String userId);

    int modifyUser(User user);

    List<User> queryAllUser();

    Long getUserIdByUsername(String username);
}
