package com.dmsdbj.team3.javaprojectbestpractices.controllerTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dmsdbj.team3.javaprojectbestpractices.controller.UserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ContextConfiguration(classes = {UserController.class})
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class TestController extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IUserService iuserservice;

    @MockBean
    private User user;


    @BeforeClass
    public void bfTest() {
        System.out.println("UserController BeforTest!");
        user = new User();
        user.setAge(2);
        user.setName("Chris");
        user.setEmail("test@163.com");
        user.setPhone("182838283848");
        user.setEvaluation("234");
        user.setId(2);
        System.out.println("User:" + user);
    }


    @Test
    public void testGetUser() throws Exception {
        when(iuserservice.getById(anyInt())).thenReturn(user);
        this.mvc.perform(get("/user/info").param("id", "2"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Transactional
    @Test
    public void testSaveUser() throws Exception {
        Gson gson = new Gson();
        when(iuserservice.save(user)).thenReturn(true);
        this.mvc.perform(post("/user/save").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(user)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test(dependsOnMethods = "testSaveUser")
    @Transactional
    public void testRemoveUser() throws Exception {
        when(iuserservice.removeById(anyInt())).thenReturn(true);
        this.mvc.perform(delete("/user/remove").param("id", "2"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test()
    public void testGetUserList() throws Exception {
        IPage<User> userIPage = null;
        when(iuserservice.page(any())).thenReturn(userIPage);
        this.mvc.perform(get("/user/list").param("Page", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @AfterClass
    public void afTest() {
        System.out.println("UserController AfterTest!");
    }


}