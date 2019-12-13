package com.dmsdbj.team3.javaprojectbestpractices.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmsdbj.team3.javaprojectbestpractices.dao.UserDao;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {


    @Autowired
    UserDao userDao;




    @Override
    public boolean updateUserByPhone(String oldPhone, String newPhone) {
        User userByPhone = userDao.getUserByPhone(oldPhone);
        return true;
    }

    @Override
    public List<User> getUserByName(String name) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().like(User::getName, name);
        List<User> userList = list(userQueryWrapper);

        return userList;
    }
}
