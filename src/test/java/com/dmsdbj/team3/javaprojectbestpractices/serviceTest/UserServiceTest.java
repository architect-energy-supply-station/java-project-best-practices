package com.dmsdbj.team3.javaprojectbestpractices.serviceTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmsdbj.team3.javaprojectbestpractices.dao.UserDao;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.impl.UserServiceImpl;
import com.sun.xml.internal.bind.v2.TODO;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/16 1:46 上午
 * @Version 1.0
 * @Description
 **/

@SpringBootTest
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class UserServiceTest extends AbstractTestNGSpringContextTests {
    @Mock
    UserDao userDao;

    private User user;


    private List<User> list;

    @InjectMocks
    UserServiceImpl userServiceimpl;

    @BeforeSuite
    public void initUser() {
        user = new User();
        list = new ArrayList<>();
        user.setId(15)
                .setAge(50)
                .setPhone("18624683756")
                .setEmail("string@qq.com")
                .setUserEvaluation("string");
        list.add(user);
    }

    @Test
    public void updateUserByPhoneTest() {
        when(userDao.getUserByPhone("18624683756")).thenReturn(user);
        when(userDao.updateById(user)).thenReturn(1);
        boolean bool = userServiceimpl.updateUserByPhone("18624683756", "18519734141");
        Assert.assertTrue(bool==true);
    }



    // TODO: 2019/12/23   测试wrapper
    @Test
    public void getUserByNameTest(String name) {

//        when(userServiceimpl.getUserByName("张")).thenReturn(list);
//        Assert.assertEquals(list.size(),3);

    }
}
