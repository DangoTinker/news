package o2oboot.service.impl;

import o2oboot.dao.RoleUserMapDao;
import o2oboot.entity.User;
import o2oboot.entity.Role;
import o2oboot.service.RoleUserMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleUserMapServiceImpl implements RoleUserMapService {
    @Autowired
    private RoleUserMapDao roleUserMapDao;
    @Override
    public int addRoleUserMap(Role role, User user) {
        return roleUserMapDao.addRoleUserMap(role,user);
    }

    @Override
    public int deleteRoleUserMap(Role role, User user) {
        return roleUserMapDao.deleteRoleUserMap(role,user);
    }

    @Override
    public int updateRoleUserMap(Role role, User user) {
        return roleUserMapDao.updateRoleUserMap(role,user);
    }

    @Override
    public Role queryRoleByUserId(Long userId) {
        return roleUserMapDao.queryRoleByUserId(userId);
    }
}
