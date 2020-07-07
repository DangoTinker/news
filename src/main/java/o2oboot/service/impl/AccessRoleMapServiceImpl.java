package o2oboot.service.impl;

import o2oboot.dao.AccessRoleMapDao;
import o2oboot.entity.Access;
import o2oboot.entity.Role;
import o2oboot.service.AccessRoleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessRoleMapServiceImpl implements AccessRoleMapService {
    @Autowired
    private AccessRoleMapDao accessRoleMapDao;
    @Override
    public int addAccessRoleMap(Access access, Role role) {

        return accessRoleMapDao.addAccessRoleMap(access,role);
    }

    @Override
    public int deleteAccessRoleMap(Access access, Role role) {
        return accessRoleMapDao.deleteAccessRoleMap(access,role);
    }

    @Override
    public List<Access> queryAllAccessByRoleId(Long roleId) {
        return accessRoleMapDao.queryAllAccessByRoleId(roleId);
    }
}
