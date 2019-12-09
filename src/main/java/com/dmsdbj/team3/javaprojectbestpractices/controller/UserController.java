package com.dmsdbj.team3.javaprojectbestpractices.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
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

@RestController()
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	IUserService userService;


	@PostMapping()
	public String saveUser(@RequestBody User userEntity) {
		userService.save(userEntity);
		return "success insert user = " + JSON.toJSONString(userEntity);
	}

	@DeleteMapping("/{id}")
	public String removeUser(@PathVariable("id") int id) {
		userService.removeById(id);
		return "success delete userId = " + id;
	}


	@GetMapping("{id}")
	public User getUser(@PathVariable("id") int id) {
		User userEntity = userService.getById(id);
		return userEntity;
	}

	@GetMapping()
	public List<User> getUserByName(@RequestParam String name) {
		return userService.getUserByName(name);
	}

	@GetMapping("/actions/paging")
	public IPage getUserList(@RequestParam int page, @RequestParam int pageSize) {
		Page pageModel = new Page();
		pageModel.setDesc("name");
		pageModel.setSize(pageSize);
		pageModel.setCurrent(page);
		IPage iPage = userService.page(pageModel);
		return iPage;
	}
}
