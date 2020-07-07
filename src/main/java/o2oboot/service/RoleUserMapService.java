package o2oboot.service;

import o2oboot.entity.Access;
import o2oboot.entity.User;
import o2oboot.entity.Role;

import java.util.List;

public interface RoleUserMapService {
    int addRoleUserMap(Role role, User user);
    int deleteRoleUserMap(Role role,User user);
    int updateRoleUserMap(Role role, User user);
    Role queryRoleByUserId(Long userId);

}
