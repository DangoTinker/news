package o2o.dao;

import o2o.BaseTest;
import o2oboot.dao.AccessDao;
import o2oboot.entity.Access;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccessDaoTest extends BaseTest {
    @Autowired
    public AccessDao accessDao;

    @Test
    public void insertAccessTest(){
        accessDao.insertAccess(new Access((long)1,"1","/sss"));
    }

    @Test
    public void queryAccessTest(){
        System.out.println(accessDao.queryAccessByUrl("/sss").getAccessName());
        System.out.println(accessDao.queryAccessById((long)1).getAccessName());
    }
}
