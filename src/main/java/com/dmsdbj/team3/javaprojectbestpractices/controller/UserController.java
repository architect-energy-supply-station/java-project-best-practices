package com.dmsdbj.team3.javaprojectbestpractices.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.aspect.Log;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@RestController
public class UserController implements IUserController{
	@Autowired
	private IUserService userService;

	@Override
	@Log(description = "根据Id查询用户")
	public User getUser(int id) {
		User user = userService.getById(id);

		return user;
	}

	@Override
	@Log
	public IPage getUserList(Page page) {
		IPage iPage = userService.page(page);
		return iPage;
	}

	@Override
	@Log(description = "根据UserId删除一个用户")
	public String removeUser(int id) {
		userService.removeById(id);
		return "success remove userId=" + id;
	}

	@Override
	@Log(description = "新增一个用户")
	public String saveUser(@RequestBody  @Valid User user) {
		userService.save(user);
		return "success insert user =" +user;
	}

}
