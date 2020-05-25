package com.dmsdbj.team3.javaprojectbestpractices.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.aspect.WebLog;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class UserController {

	@Autowired
	IUserService userService;


	@PostMapping("/user/save")
	@WebLog(description = "请求用户登陆接口")
	public String saveUser(@RequestBody User userEntity) {
		userService.save(userEntity);
		return "success insert user = " + JSON.toJSONString(userEntity);
	}

	@RequestMapping("/user/remove")
	public String removeUser(@RequestParam("id") int id) {
		userService.removeById(id);
		return "success delete userId = " + id;
	}



	@RequestMapping("/user/info")
	public User getUser(@RequestParam("id") int id) {
		User userEntity = userService.getById(id);
		return userEntity;
	}

	@RequestMapping("/user/list")
	public IPage getUserList(Page page) {
		page.setDesc("name");
		IPage iPage = userService.page(page);
		return iPage;
	}
}
