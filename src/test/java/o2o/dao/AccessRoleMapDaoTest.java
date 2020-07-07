package o2o.dao;

import o2o.BaseTest;
import o2oboot.dao.AccessRoleMapDao;
import o2oboot.dao.RoleUserMapDao;
import o2oboot.entity.Access;
import o2oboot.entity.Role;
import o2oboot.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccessRoleMapDaoTest extends BaseTest {

    @Autowired
    private AccessRoleMapDao accessRoleMapDao;
    @Autowired
    private RoleUserMapDao roleUserMapDao;


    @Test
    public void test(){
        Access access=new Access();
        access.setAccessId((long)1);
        Role role=new Role();
        role.setRoleId((long)1);
        User user=new User();
        user.setUserId((long)2);

        accessRoleMapDao.addAccessRoleMap(access,role);
        roleUserMapDao.addRoleUserMap(role,user);


    }

    @Test
    public void t(){
        List<Access> list=accessRoleMapDao.queryAllAccessByRoleId((long)1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAccessId());
        }

    }

    @Test
    public void tt(){
        Role role=roleUserMapDao.queryRoleByUserId((long)2);
        System.out.println(role.getRoleId());
        System.out.println(role.getRoleName());
    }

}
