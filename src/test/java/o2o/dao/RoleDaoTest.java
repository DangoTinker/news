package o2o.dao;

import o2o.BaseTest;
import o2oboot.dao.RoleDao;
import o2oboot.dao.UserDao;
import o2oboot.entity.Role;
import o2oboot.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoleDaoTest extends BaseTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void queryRoleTest(){

        List<Role> list=roleDao.queryAllRole();
        assertEquals(2,list.size());
        System.out.println(list.get(0).getRoleName());
    }
    @Test
    public void insertRoleTest(){
        roleDao.insertRole(new Role((long)3,"3",null));
    }

    @Test
    public void deleteRoleTest(){
        roleDao.deleteRoleById((long)3);
    }


}
