package com.dmsdbj.team3.javaprojectbestpractices.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
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
@RestController
public class UserController {



	@Autowired
	IUserService userService;


	@PostMapping("/user/save")
	public String saveUser(@RequestBody User userEntity) {
		userService.save(userEntity);
		return "success insert user = " + JSON.toJSONString(userEntity);
	}

	@RequestMapping("/user/selectUserByPhone")
	public User selectUserByPhone(String phone) {
		User user=userService.selectUserByPhone(phone);
		return user;
	}

	@PostMapping("/user/updateUserByPhone")
	public boolean updateUserByPhone(@RequestParam("newPhone")String newPhone,@RequestParam("oldPhone") String oldPhone) {
		boolean result = userService.updateUserByPhone(newPhone, oldPhone);
		return result;
	}

	@DeleteMapping("/user/remove")
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

	@RequestMapping("/user/getUserByLikeName")
	public User getUserByLikeName(@RequestParam("name") String name) {
		User user=userService.getUserByLikeName(name);
		return user;
	}
}
