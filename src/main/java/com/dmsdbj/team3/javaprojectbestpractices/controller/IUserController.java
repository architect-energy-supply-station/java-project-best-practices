package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.utils.exception.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname SwaggerController
 * @Auther sunshinezhang
 * @Date 2019/11/1 20:19
 */
@Api(tags = {"用户表接口"})
public interface IUserController {

	@ApiOperation(value = "根据Id查询用户", notes = "请输入用户ID")
	@GetMapping("/user/info/{id}")
	ResultBean<User> getUser(@ApiParam(value = "id", required = true, defaultValue = "4") @PathVariable("id") int id);

	@ApiOperation(value = "查询所有用户")
	@GetMapping("/user/list")
	ResultBean<User> getUserList(@ApiParam(value = "page", required = true) Page page);

	@ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
	@DeleteMapping("/user/remove/{id}")
	ResultBean<Boolean> removeUser(@ApiParam(value = "id", required = true, defaultValue = "2") @PathVariable("id") int id);

	@ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
	@PostMapping("/user/save")
	ResultBean<Boolean> saveUser(@ApiParam(value = "user", required = true) @RequestBody User user);

	@ApiOperation(value = "根据姓名模糊查询", notes = "请输入要模糊查询的信息")
	@GetMapping(value = {"/user/getUserByLikeName/{name}"})
	ResultBean<User> getUserByLikeName(@ApiParam(value = "name", required = true) @PathVariable String name);

	@ApiOperation(value = "根据用户的手机号更新用户信息", notes = "请输入用户的新旧手机号")
	@PostMapping("/user/updateUserByPhone/{oldPhone}/{newPhone}")
	ResultBean<Boolean> updateUserByPhone(@ApiParam(value = "oldPhone", required = true) @PathVariable("oldPhone") String oldPhone,@ApiParam(value = "newPhone", required = true) @PathVariable("newPhone") String newPhone);
}
