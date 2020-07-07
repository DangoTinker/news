package o2oboot.dao;

import o2oboot.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper

public interface RoleDao {
    int insertRole(Role role);
    //TODO 增删改查role
    Role queryRoleById(Long roleId);
    int deleteRoleById(Long roleId);
    int updateRole(Role role);

    List<Role> queryAllRole();
    //返回role表中的List<Access> accesses中的值
}
