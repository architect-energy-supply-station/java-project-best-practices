package com.dmsdbj.team3.javaprojectbestpractices.controller.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.dmsdbj.team3.javaprojectbestpractices.utils.exception.ResultBean;
import com.dmsdbj.team3.javaprojectbestpractices.utils.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RestController
@Slf4j
public class UserController implements IUserController {


	@Value("${MYENGLISHNAME.value}")
	private String myEnglishName;


	@Autowired
	private IUserService userService;

	@Override
	@Log(description = "根据Id查询用户")
	public ResultBean<User> getUser(int id) {
		userService.getById(id);
		return ResultBean.success(userService.getById(id));
	}

	@Override
	@Log(description = "查询所有用户")
	public ResultBean<IPage> getUserList(Page page) {
		IPage iPage = userService.page(page);
		if (iPage.getSize()>=0) {
			return ResultBean.success(iPage);
		}else {
			return ResultBean.error(1111, "查询所有用户信息失败");
		}
	}

	@Override
	@Log(description = "根据UserId删除一个用户")
	public ResultBean<Boolean> removeUser(int id) {
		if (userService.removeById(id)) {
			return ResultBean.success(userService.removeById(id));
		}else {
			return ResultBean.error(1111, "根据UserId删除一个用户失败");
		}
	}

	@Override
	@Log(description = "新增一个用户")
	public ResultBean<Boolean> saveUser(User user) {
		if (userService.save(user)) {
			return ResultBean.success(userService.save(user));
		}else {
			return ResultBean.error(1111, "新增一个用户失败");
		}
	}

	@Override
	@Log(description = "根据姓名模糊查询")
	public ResultBean<User> getUserByLikeName(String name) {
		List<User> userByLikeNameList = userService.getUserByLikeName(name);
		if (userByLikeNameList.size()>=0) {
			return ResultBean.success(userService.getUserByLikeName(name)) ;
		}else {
			return ResultBean.error(1111, "根据姓名模糊查询信息失败");
		}
	}

	@Override
	@Log(description = "根据用户的手机号更新用户信息")
	public ResultBean<Boolean> updateUserByPhone(String oldPhone,String newPhone) throws Exception {
		boolean b = userService.updateUserByPhone(oldPhone, newPhone);
		if (b) {
			return ResultBean.success(userService.updateUserByPhone(oldPhone, newPhone)) ;
		}else {
			return ResultBean.error(1111,"根据用户的手机号更新用户信息失败") ;
		}
	}

	@Override
	public String getSettingValue() {
		String englishName=myEnglishName;
		log.info("我的英文名称是:[{}]",myEnglishName);
		return englishName;
	}
}
