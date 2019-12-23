package com.dmsdbj.team3.javaprojectbestpractices.controller.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.annotation.WebLog;
import com.dmsdbj.team3.javaprojectbestpractices.config.ResultBean;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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
public class UserController implements IUserController {

	@Autowired
	IUserService userService;
	@Value("${MYENGLISHNAME.value}")
	private String myEnglishName;


	@Override
	@WebLog(description = "插入一条新的用户")
	public ResultBean saveUser(User userEntity) {
		boolean save = userService.save(userEntity);
		if (save) {
			return ResultBean.success(userEntity);
		} else {
			return ResultBean.error(1111, "新增用户数据失败");
		}


	}


	@Override
	@WebLog(description = "移除某个用户")
	public ResultBean removeUser(int id) {
		boolean b = userService.removeById(id);
		if (b) {
			return ResultBean.success(id);
		} else {
			return ResultBean.error(1111, "删除某个用户失败");
		}
	}



	@Override
	@WebLog(description = "获取某个用户信息")
	public ResultBean getUser(int id) {
		User userEntity = userService.getById(id);
		return ResultBean.success(userEntity);
	}


	@Override
	@WebLog(description = "获取全部用户信息")
	public ResultBean getUserList(Page page) {
		page.setDesc("name");
		IPage iPage = userService.page(page);
		if (iPage.getSize() > 0) {
			return ResultBean.success(iPage);
		} else {
			return ResultBean.error(1111, "获取用户信息失败");
		}



	}

	@Override
	@WebLog(description = "获取某个人信息")
	public ResultBean getUserByName(String name) {
		List<User> userByName = userService.getUserByName(name);
		if (userByName.size() > 0) {
			return ResultBean.success(userByName);
		} else {
			return ResultBean.error(1111, "根据姓名获取信息失败");
		}
	}

	@Override
	public String getSettingValue() {
		String myName = myEnglishName;
		log.info("我的英文名字为： {}",myName);
		return myName;
	}

	@Override
	public ResultBean<Boolean> updateUserByPhone( String oldPhone,  String newPhone) throws Exception {
		boolean b = userService.updateUserByPhone(oldPhone, newPhone);
		if (b) {
			return ResultBean.success(b) ;
		}else {
			return ResultBean.error(1111,"根据用户的手机号更新用户信息失败") ;
		}
	}


}
