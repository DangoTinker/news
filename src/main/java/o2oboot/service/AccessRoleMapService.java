package o2oboot.service;

import o2oboot.entity.Access;
import o2oboot.entity.Role;

import java.util.List;

public interface AccessRoleMapService {
    int addAccessRoleMap(Access access, Role role);
    int deleteAccessRoleMap(Access access,Role role);
    List<Access> queryAllAccessByRoleId(Long roleId);

}
