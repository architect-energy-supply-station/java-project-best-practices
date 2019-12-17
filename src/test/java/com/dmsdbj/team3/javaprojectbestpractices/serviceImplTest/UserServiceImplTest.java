package com.dmsdbj.team3.javaprojectbestpractices.serviceImplTest;

import com.dmsdbj.team3.javaprojectbestpractices.dao.UserDao;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.impl.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.mockito.Mockito.when;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-16
 */
@SpringBootTest
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class UserServiceImplTest extends AbstractTestNGSpringContextTests {
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void updateUserByPhone() throws Exception {
        User user = new User();
        user.setPhone("15732677863");
        user.setId(3);
        user.setName("chris");
        user.setEmail("123@163.com");
        user.setAge(2);

        when(userDao.getUserByPhone("15732677863")).thenReturn((user));
        when(userDao.updateById(user)).thenReturn(1);
        boolean update = this.userService.updateUserByPhone("15732677864", "15732677863");
        Assert.assertTrue(update==true);
    }
}
