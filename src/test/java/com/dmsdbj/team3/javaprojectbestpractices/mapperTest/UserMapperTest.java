package com.dmsdbj.team3.javaprojectbestpractices.mapperTest;

import com.dmsdbj.team3.javaprojectbestpractices.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-16
 */
@SpringBootTest
public class UserMapperTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void selectUserByPhoneOne() {
        Assert.assertTrue(userDao.getUserByPhone("15732677863").getId()==3);
    }

    @Test
    public void selectUserByPhoneTwo() {
        Assert.assertTrue(userDao.getUserByPhone("15732677863").getAge()==2);
    }
}
