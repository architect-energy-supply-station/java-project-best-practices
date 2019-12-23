package com.dmsdbj.team3.javaprojectbestpractices.controllerTest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.controller.impl.UserController;
import com.dmsdbj.team3.javaprojectbestpractices.dao.UserDao;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.dmsdbj.team3.javaprojectbestpractices.service.impl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/23 11:12 上午
 * @Version 1.0
 * @Description
 **/


//@RunWith(SpringRunner.class)
@WebMvcTest(IUserController.class)
//@ContextConfiguration(classes = {IUserController.class})
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class controllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDao userDao;

    User user=new User();


    List<User> userList = new ArrayList<>();

    @MockBean
    private IUserService UserService;

    @BeforeClass
    public void initUser() {
        user.setId(15)
                .setAge(50)
                .setPhone("18624683756")
                .setEmail("string@qq.com")
                .setUserEvaluation("string")
                .setEmail("adfq@163.com");
        userList.add(user);

    }


    @Transactional
    @Test
    public void saveUserTest() throws Exception {
        when(UserService.save(user)).thenReturn(true);
        this.mockMvc.perform(post("/v1/users/save").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(user)))
        .andDo(print())
        .andExpect(status().isOk());

    }

    @Test
    public void getUserTest() throws Exception {
        when(UserService.getById("15")).thenReturn(user);
        this.mockMvc.perform(get("/v1/users/info/{id}","15"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn()
        .getResponse();
    }

    @Test
    @Transactional
    public void removeUserTest() throws Exception {
        when(UserService.removeById("15")).thenReturn(true);
        this.mockMvc.perform(delete("/v1/users/remove/{id}","15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void getUserByNameTest() throws Exception {
        when(UserService.getUserByName("苏打粉")).thenReturn(userList);
        this.mockMvc.perform(get("/v1/users/getUserByName/{name}","苏打粉"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void updateUserByPhoneTest() throws  Exception {
        when(UserService.updateUserByPhone("18624683756", "28624683756")).thenReturn(true);
        mockMvc.perform(get("/v1/users/updateUserByPhone/{oldPhone}/{newPhone}", "18624683756", "28624683756"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getRequest();
    }

    @Test
    // TODO: 2019/12/23 mybatisPlus的分页，测试 
    public void getUserListTest() throws  Exception {
//        when(UserService.page(page))
    }
}
