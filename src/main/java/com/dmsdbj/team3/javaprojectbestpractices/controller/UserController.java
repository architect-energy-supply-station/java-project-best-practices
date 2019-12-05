package com.dmsdbj.team3.javaprojectbestpractices.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.annotation.WebLog;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Api(tags = "用户管理接口")
@RestController
@Slf4j
public class UserController implements IUserController{

	@Autowired
	IUserService userService;



	@Override
	@WebLog(description = "插入一条新的用户")
	public String saveUser(User userEntity) {
		userService.save(userEntity);
		return "success insert user = " + JSON.toJSONString(userEntity);
	}


	@Override
	@WebLog(description = "移除某个用户")
	public String removeUser(int id) {
		userService.removeById(id);
		return "success delete userId = " + id;
	}



	@Override
	@WebLog(description = "获取某个用户信息")
	public User getUser(int id) {
		User userEntity = userService.getById(id);
		return userEntity;
	}


	@Override
	@WebLog(description = "获取全部用户信息")
	public IPage getUserList(Page page) {
		page.setDesc("name");
		IPage iPage = userService.page(page);
		return iPage;
	}
}
