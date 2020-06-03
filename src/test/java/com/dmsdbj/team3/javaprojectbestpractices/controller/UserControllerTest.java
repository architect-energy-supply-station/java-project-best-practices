package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.google.common.reflect.TypeToken;
import javafx.beans.binding.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@WebMvcTest
@ContextConfiguration(classes = {UserController.class})
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
class UserControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private MockMvc mvc;
//    @Autowired
//    private User user;
@BeforeEach
    @Test
    void setUp() {
//        user = new User();
//        user.setId(2);
//        user.setName("lei");
//        user.setEmail("ww@163.com");
//        user.setPhone("18831645429");
//        user.setAge(12);
//        System.out.println("User:"+user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        userController.getUser(4);
        System.out.println(userController.getUser(4));

    }

    @Test
    void getSettingValue() {
        userController.getSettingValue();
    }

    @Test
    void testGetUser() {
        userController.getUser(5);
//        Assert.assertNotNull( userController.getUser(5));
        Assert.assertNotNull(userController.getUser(5), "根据Id查询成功");
        System.out.println(userController.getUser(5));


    }

    @Test
    void getUserList() throws UnsupportedEncodingException {


    }

    @Test
    void removeUser() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void getUserByLikeName() {
    }

    @Test
    void getUserByName() {
    }
}