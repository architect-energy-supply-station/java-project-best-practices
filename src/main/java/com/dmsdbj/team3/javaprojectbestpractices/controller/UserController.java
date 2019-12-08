package com.dmsdbj.team3.javaprojectbestpractices.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.annotation.WebLog;
import com.dmsdbj.team3.javaprojectbestpractices.config.ResultBean;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */

@RestController
@Slf4j
public class UserController implements IUserController{

	@Autowired
	IUserService userService;



	@Override
	@WebLog(description = "插入一条新的用户")
	public ResultBean saveUser(User userEntity) {
		userService.save(userEntity);
		return ResultBean.success(userEntity);
	}


	@Override
	@WebLog(description = "移除某个用户")
	public ResultBean removeUser(int id) {
		userService.removeById(id);
		return ResultBean.success(id);
	}



	@Override
	@WebLog(description = "获取某个用户信息")
	public ResultBean getUser(int id) {
		User userEntity = userService.getById(id);
		return ResultBean.success(userEntity);
	}


	@Override
	@WebLog(description = "获取全部用户信息")
	public ResultBean getUserList(Page page) {
		page.setDesc("name");
		IPage iPage = userService.page(page);
		return ResultBean.success(iPage);
	}

	@Override
	@WebLog(description = "获取某个人信息")
	public ResultBean getUserByName(String name) {
		List<User> userByName = userService.getUserByName(name);
		return ResultBean.success(userByName);
	}
}
