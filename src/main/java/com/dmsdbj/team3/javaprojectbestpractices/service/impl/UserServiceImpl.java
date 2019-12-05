package com.dmsdbj.team3.javaprojectbestpractices.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.mapper.UserMapper;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
