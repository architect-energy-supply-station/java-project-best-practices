package com.dmsdbj.team3.javaprojectbestpractices.mapperTest;

import com.dmsdbj.team3.javaprojectbestpractices.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest
public class UserMapperTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUserByPhoneOne() {
        Assert.assertTrue(userMapper.selectUserByPhone("15732677863").getId()==3);
    }

    @Test
    public void selectUserByPhoneTwo() {
        Assert.assertTrue(userMapper.selectUserByPhone("15732677863").getAge()==2);
    }
}