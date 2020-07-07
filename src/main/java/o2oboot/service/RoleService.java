package o2oboot.service;

import o2oboot.entity.Access;
import o2oboot.entity.Role;

import java.util.List;

public interface RoleService {
    int addRole(Role role);
    int updateRole(Role role);
    int deleteRole(Long roleId);
    Role queryRole(Long roleId);
    int addRoleAccess(Role role, Access access);
    int deleteRoleAccess(Role role, Access access);
    List<Role> queryAllRole();
}
