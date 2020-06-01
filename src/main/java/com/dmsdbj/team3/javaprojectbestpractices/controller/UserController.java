package com.dmsdbj.team3.javaprojectbestpractices.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.utils.aspect.Log;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.dmsdbj.team3.javaprojectbestpractices.utils.exception.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	@Value("${MYENGLISHNAME.value}")
	private String myEnglishName;
	@Autowired
	private IUserService userService;


	@Override

	public String getSettingValue() {
		String englishName = myEnglishName;
		log.info("我的英文名字是：[{}]", myEnglishName);
		return myEnglishName;
	}

	@Override
	@Log(description = "根据Id查询用户")
//	public User getUser(int id) {
	public ResultBean<User> getUser(int id) {
		User user = userService.getById(id);
		return ResultBean.success(userService.getById(id));
//		return user;
	}

	@Override
	@Log(description = "查询所有用户")
//	public IPage getUserList(Page page) {
	public ResultBean<IPage> getUserList(Page page) {
//		IPage iPage = userService.page(page);
//		return iPage;
		Page page1 = new Page();
		IPage iPage = userService.page(page1);
		if (iPage.getSize() >= 0) {
			return ResultBean.success(iPage);
		} else {
			return ResultBean.error(1111, "查询所有用户信息失败");
		}
	}

	@Override
	@Log(description = "根据UserId删除一个用户")
//	public String removeUser(int id) {
	public ResultBean<Boolean> removeUser(int id) {
//		userService.removeById(id);
//		return "success remove userId=" + id;
		boolean removeFlag = userService.removeById(id);
		if (removeFlag) {
			return ResultBean.success(removeFlag);
		}else {
			return ResultBean.error(1111, "根据UserId删除一个用户失败");
		}
	}

	@Override
	@Log(description = "新增一个用户")
//	public String saveUser(User user) {
	public ResultBean<Boolean>  saveUser(User user) {
//		userService.save(user);
//		return "success insert user =" +user;
		boolean saveFlag = userService.save(user);
		if (saveFlag) {
			return ResultBean.success(saveFlag);
		}else {
			return ResultBean.error(1111, "新增一个用户失败");
		}
	}

	@Override
	@Log(description = "根据姓名模糊查询")
//	public List<User> getUserByLikeName(String name) {
	public ResultBean<User> getUserByLikeName(String name) {
//		List<User> userList = userService.getUserByLikeName(name);
//		return userList;
		List<User> userByLikeNameList = userService.getUserByLikeName(name);
		if (userByLikeNameList.size()>=0) {
			return ResultBean.success(userByLikeNameList) ;
		}else {
			return ResultBean.error(1111, "根据姓名模糊查询信息失败");
		}
	}






//	@Override
//	@Log(description = "根据邮箱查询用户信息")
//	public ResultBean<User> getUserByEmail(@NotBlank String email) {
//		List<User> userByEmailList = userService.getUserByEmail(email);
//		if (userByEmailList.size() >= 0) {
//			return ResultBean.success(userByEmailList);
//		} else {
//			return ResultBean.error(111, "根据邮箱查询用户信息失败");
//		}
//	}

//	@Override
//	@Log(description = "根据用户的手机号更新用户信息")
//	public ResultBean<Boolean> updateUserByPhone(@NotBlank @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号码格式错误") String oldPhone, @NotBlank @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误") String newPhone) throws Exception {
//		boolean bool = userService.updateUserByPhone(oldPhone, newPhone);
//		if (bool) {
//			return ResultBean.success(bool);
//		} else {
//			return ResultBean.error(111, "根据用户的手机号更新用户信息失败");
//		}
//
//	}






}
