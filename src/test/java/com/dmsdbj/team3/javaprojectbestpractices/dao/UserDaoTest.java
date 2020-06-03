package com.dmsdbj.team3.javaprojectbestpractices.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    void getUserByPhone() {
        Assert.assertTrue(userDao.getUserByPhone("18831645427").getId()==5);



    }

    @Test
    void testGetUserByPhone() {
        Assert.assertTrue(userDao.getUserByPhone("18831645427").getId()==5);
    }

    @Test
    void updateUserByPhone() {
    }
}