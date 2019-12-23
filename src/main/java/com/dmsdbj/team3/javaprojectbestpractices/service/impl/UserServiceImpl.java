package com.dmsdbj.team3.javaprojectbestpractices.service.impl;

import com.alibaba.fastjson.JSON;
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
        boolean debugEnabled = log.isDebugEnabled();
        if (debugEnabled) {

            log.debug("用户输入的新旧手机号. args[oldPhone=[{}],newPhone=[{}]]", oldPhone, newPhone);
        }
        try {
            User userByPhone = userDao.getUserByPhone(oldPhone);
            if (userByPhone != null && !userByPhone.equals("")) {
                log.info("根据手机号查询到用户信息. phone=[{}],user=[{}]" , oldPhone, JSON.toJSONString(userByPhone));
                userByPhone.setPhone(newPhone);
            }
            userDao.updateById(userByPhone);
            return true;
        }catch(Exception e){
            log.error("用户更新手机号失败. phone=[{}]",oldPhone);
            return false;
        }
    }

    @Override
    public List<User> getUserByName(String name) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().like(User::getName, name);
        List<User> userList = list(userQueryWrapper);
        return userList;
    }


}
