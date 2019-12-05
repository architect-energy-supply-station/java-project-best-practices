package com.dmsdbj.team3.javaprojectbestpractices.controller.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.Aop.Log;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-03
 */
@Slf4j
@RestController
public class UserController implements IUserController {

    @Autowired
    IUserService userService;

    @Override
    @Log(description = "保存用户")
    public String saveUser(User userEntity) {
        userService.save(userEntity);
        return "success insert user = " + JSON.toJSONString(userEntity);
    }

    @Override
    @Log(description = "根据姓名查询用户")
    public List<User> getUserByLikeName(String name) {
        return null;
    }

    @Override
    @Log(description = "删除用户")
    public String removeUser(int id) {
        userService.removeById(id);
        return "success delete userId = " + id;
    }

    @Override
    @Log(description = "根据id获取用户")
    public User getUser(int id) {
        User userEntity = userService.getById(id);
        return userEntity;
    }

    @Override
    @Log(description = "分页查询用户")
    public IPage getUserList(Page page) {
        page.setDesc("name");
        IPage iPage = userService.page(page);
        return iPage;
    }
}
