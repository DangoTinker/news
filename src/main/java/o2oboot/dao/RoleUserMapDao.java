package o2oboot.dao;

import o2oboot.entity.Access;
import o2oboot.entity.Role;
import o2oboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface RoleUserMapDao {
    int addRoleUserMap(@Param("role") Role role, @Param("user") User user);
    int deleteRoleUserMap(@Param("role")Role role,@Param("user")User user);
    int updateRoleUserMap(@Param("role")Role role, @Param("user")User user);
    Role queryRoleByUserId(Long userId);

}

