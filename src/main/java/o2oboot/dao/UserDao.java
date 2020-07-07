package o2oboot.dao;

import o2oboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

public interface UserDao {
    int insertUser(User user);
    int queryUserSignIn(@Param("userName") String userId, @Param("password")String password);
    int queryUserById(@Param("userName") String userId);
    User queryUser(@Param("userName") String userId);
    int updateUser(User user);

    List<User> queryAllUser();
    Long queryUserIdByUsername(String username);


}
