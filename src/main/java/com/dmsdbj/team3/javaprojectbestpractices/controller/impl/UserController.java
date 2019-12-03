package com.dmsdbj.team3.javaprojectbestpractices.controller.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Slf4j
@RestController
public class UserController implements IUserController {

	@Autowired
	private IUserService userService;


	@Override
	public String saveUser( User user) {
		userService.save(user);
		return "success insert user = " + user;
	}

	@Override
	public List<User> getUserByLikeName(String name) {
//		List<User> userList = userService.getUserByLikeName(name);
		return null;
	}

	@Override
	public String removeUser( int id) {
		userService.removeById(id);
		return "success remove userId = " + id;
	}



	@Override
	public User getUser( int id) {
		User user = userService.getById(id);
		return user;
	}

	@Override
	public IPage getUserList(Page page) {
		page.setDesc("name");
		IPage iPage = userService.page(page);
		return iPage;
	}

}
