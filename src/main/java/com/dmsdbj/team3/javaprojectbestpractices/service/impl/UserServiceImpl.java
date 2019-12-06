package com.dmsdbj.team3.javaprojectbestpractices.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.mapper.UserMapper;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean updateUserByPhone(String oldPhone, String newPhone) {
        boolean debugEnabled = log.isDebugEnabled();
        if (debugEnabled) {
            log.debug("用户输入的手机号，args[oldphone=[{}],newphone=[{}]]", oldPhone, newPhone);
        }

        List<User> userList = userMapper.selectUserByPhone(oldPhone);
        try{
            if (userList != null && !userList.equals("")) {
                log.info("根据手机号查询到用户信息. phone=[{}],user=[{}]" , oldPhone, JSON.toJSONString(userList));
                for (User user : userList) {
                    user.setPhone(newPhone);
                    int i = userMapper.updateById(user);
                }
            }
        }catch (Exception e) {
            log.info("用户更新手机号失败，phnone=[{}]" , oldPhone);
        }
        return true;
    }
}
