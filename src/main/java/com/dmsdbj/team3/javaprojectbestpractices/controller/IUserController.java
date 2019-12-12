package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.utils.exception.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Classname SwaggerController
 * @Auther sunshinezhang
 * @Date 2019/11/1 20:19
 */
@Api(tags = {"用户表接口"})
@Validated
@RequestMapping("/v1/users")
public interface IUserController {

	@ApiOperation(value = "根据Id查询用户", notes = "请输入用户ID")
	@GetMapping("{id}")
	ResultBean<User> getUser(@ApiParam(value = "id", required = true, defaultValue = "4") @NotNull @PathVariable("id") int id);

	@ApiOperation(value = "查询所有用户")
	@GetMapping("/actions/paging")
	ResultBean<IPage> getUserList(@ApiParam(value = "page", required = true,defaultValue = "1") @NotNull @RequestParam int page,@ApiParam(value = "pageSize",required = true,defaultValue = "10") @NotNull @RequestParam int pagesize);

	@ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
	@DeleteMapping("{id}")
	ResultBean<Boolean> removeUser(@ApiParam(value = "id", required = true, defaultValue = "2")@NotNull @PathVariable("id") int id);

	@ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
	@PostMapping()
	ResultBean<Boolean> saveUser(@ApiParam(value = "user", required = true) @Valid @RequestBody User user);

	@ApiOperation(value = "根据姓名模糊查询", notes = "请输入要模糊查询的信息")
	@GetMapping(params = "name")
	ResultBean<User> getUserByLikeName(@ApiParam(value = "name", required = true) @NotBlank @RequestParam String name);

	@ApiOperation(value = "根据邮箱查询用户信息", notes = "请输入要查询的邮箱")
	@GetMapping(params = "email")
	ResultBean<User> getUserByEmail(@ApiParam(value = "email", required = true) @NotBlank @RequestParam String email);

	@ApiOperation(value = "根据用户的手机号更新用户信息", notes = "请输入用户的新旧手机号")
	@GetMapping("{oldPhone}/{newPhone}")
	ResultBean<Boolean> updateUserByPhone(@ApiParam(value = "oldPhone", required = true) @NotBlank @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号码格式错误") @RequestParam("oldPhone") String oldPhone,@ApiParam(value = "newPhone", required = true) @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误") @RequestParam("newPhone") String newPhone) throws Exception;

	@ApiOperation(value = "查询得到配置文件中自定义属性的值")
	@GetMapping("/user/getSettingValue")
	String getSettingValue();
}
