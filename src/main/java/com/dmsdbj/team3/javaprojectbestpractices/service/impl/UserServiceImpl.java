package com.dmsdbj.team3.javaprojectbestpractices.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.mapper.UserMapper;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Service
@SpringBootTest
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserByLikeName(String name) {
        User user=userMapper.getUserByLikeName(name);
        return user;
    }

    @Override
    public User selectUserByPhone(String phone) {
        User user = userMapper.selectUserByPhone(phone);
        return user;
    }

    @Override
    public boolean updateUserByPhone(String newPhone, String oldPhone) {
        User user = userMapper.selectUserByPhone(oldPhone);
        boolean result ;
        if(String.valueOf(user.getId()).equals("")){
            System.out.println("没有旧号码   "+user.getPhone()+"   的用户，请重新输入旧号码[{}]");
            result = false;
        }else{
            user.setPhone(newPhone);
            int number=userMapper.updateById(user);
            if (number==1) {
                result =true;
            }else {
                result = false;
            }
        }
        return result;
    }
}
