package com.dmsdbj.team3.javaprojectbestpractices.mapperTest;

import com.dmsdbj.team3.javaprojectbestpractices.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/23 8:41 上午
 * @Version 1.0
 * @Description
 **/

@SpringBootTest
public class mapperTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void getUserByPhoneOneTest() {
        Assert.assertEquals(userDao.getUserByPhone("18624683756").getId(),15);
    }

    @Test
    public void getUserByPhoneTwoTest() {
        Assert.assertTrue(userDao.getUserByPhone("18624683756").getId()==15);
        Assert.assertTrue(userDao.getUserByPhone("18624683756").getName().contentEquals("苏打粉"));
        Assert.assertTrue(userDao.getUserByPhone("18624683756").getAge()==50);
    }
}
