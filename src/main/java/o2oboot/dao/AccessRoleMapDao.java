package o2oboot.dao;

import o2oboot.entity.Access;
import o2oboot.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface AccessRoleMapDao {
    int addAccessRoleMap(@Param("access")Access access, @Param("role")Role role);
    int deleteAccessRoleMap(@Param("access")Access access,@Param("role")Role role);
    List<Access> queryAllAccessByRoleId(Long roleId);
}
