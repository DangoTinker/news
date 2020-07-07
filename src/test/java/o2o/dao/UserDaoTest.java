package o2o.dao;


import o2o.BaseTest;
import o2oboot.dao.UserDao;
import o2oboot.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryUserTest(){

        List<User> list=userDao.queryAllUser();
        assertEquals(2,list.size());
        System.out.println(list.get(0).getUsername());
    }
    @Test
    public void insertUserTest(){
        userDao.insertUser(new User((long) 3,"3","3","3"));
    }
    @Test
    public void deleteUserTest(){
        System.out.println(
                userDao.queryUserSignIn("3","3"));
    }
//
//    @Test
//    public void tt(){
//        String user="work";
//        String password="123456";
//
//        String res1=DESUtil.getEncryptString(user);
//        String res2=DESUtil.getDecryptString(res1);
//        System.out.println(res1+" "+res2);
//        res1=DESUtil.getEncryptString(password);
//        res2=DESUtil.getDecryptString(res1);
//        System.out.println(res1+" "+res2);
//
//    }

}
