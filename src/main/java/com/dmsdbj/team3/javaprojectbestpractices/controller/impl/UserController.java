package com.dmsdbj.team3.javaprojectbestpractices.controller.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.dmsdbj.team3.javaprojectbestpractices.utils.log.Log;
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
	@Log(description = "新增或修改用户")
	public String saveUser( User user) {
		userService.save(user);
		return "success insert user = " + user;
	}

	@Override
	@Log(description = "根据姓名模糊查询用户")
	public List<User> getUserByLikeName(String name) {
//		List<User> userList = userService.getUserByLikeName(name);
		return null;
	}

	@Override
	@Log(description = "删除用户")
	public String removeUser( int id) {
		userService.removeById(id);
		return "success remove userId = " + id;
	}



	@Override
	@Log(description = "根据ID查询用户")
	public User getUser( int id) {
		User user = userService.getById(id);
		return user;
	}

	@Override
	@Log(description = "查询用户列表")
	public IPage getUserList(Page page) {
		page.setDesc("name");
		IPage iPage = userService.page(page);
		return iPage;
	}

}
