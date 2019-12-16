package com.dmsdbj.team3.javaprojectbestpractices.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
public interface IUserService extends IService<User> {

    User getUserByLikeName(String name);

    User selectUserByPhone(String phone);

    boolean updateUserByPhone(String newPhone, String oldPhone);

}
