package com.dmsdbj.team3.javaprojectbestpractices.controller.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.Aop.Log;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.dmsdbj.team3.javaprojectbestpractices.utils.ResultBean;
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
    public ResultBean<String> saveUser(User userEntity) {
        boolean saveFlag = userService.save(userEntity);
        if (saveFlag) {
            return ResultBean.success("success insert user = " + JSON.toJSONString(userEntity));
        } else {
            return ResultBean.error(111, "保存用户失败");
        }
    }

    @Override
    @Log(description = "根据姓名查询用户")
    public ResultBean<List<User>> getUserByLikeName(String name) {
        return null;
    }

    @Override
    @Log(description = "删除用户")
    public ResultBean<String> removeUser(int id) {
        userService.removeById(id);
        if (userService.removeById(id)) {
            return ResultBean.success("success delete userId = " + id);
        } else {
            return ResultBean.error(111,"failed delete userId = " + id);
        }
    }

    @Override
    @Log(description = "根据id获取用户")
    public ResultBean<User> getUser(int id) {
        User userEntity = userService.getById(id);
        if (userEntity != null) {
            return ResultBean.success(userEntity);
        } else {
            return ResultBean.error(111, "根据id"+id+"查询用户失败");
        }
    }

    @Override
    @Log(description = "分页查询用户")
    public ResultBean<IPage> getUserList(Page page) {
        page.setDesc("name");
        IPage iPage = userService.page(page);
        if (iPage != null) {
            return ResultBean.success(iPage);
        } else {
            return ResultBean.error(111, "分页查询用户失败");
        }
    }
}

