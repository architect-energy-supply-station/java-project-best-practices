package com.dmsdbj.team3.javaprojectbestpractices.controller.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.controller.IUserController;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import com.dmsdbj.team3.javaprojectbestpractices.utils.exception.ResultBean;
import com.dmsdbj.team3.javaprojectbestpractices.utils.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@RestController
public class UserController implements IUserController {

	@Autowired
	private IUserService userService;

	@Override
	@Log(description = "根据Id查询用户")
	public ResultBean<User> getUser(int id) {
		return ResultBean.success(userService.getById(id));
	}

	@Override
	@Log(description = "查询所有用户")
	public ResultBean<User> getUserList(Page page) {
		IPage iPage = userService.page(page);
		return ResultBean.success(iPage);
	}

	@Override
	@Log(description = "根据UserId删除一个用户")
	public ResultBean<Boolean> removeUser(int id) {
		return ResultBean.success(userService.removeById(id));
	}

	@Override
	@Log(description = "新增一个用户")
	public ResultBean<Boolean> saveUser(User user) {
		return ResultBean.success(userService.save(user));
	}

	@Override
	@Log(description = "根据姓名模糊查询")
	public ResultBean<User> getUserByLikeName(String name) {
		return ResultBean.success(userService.getUserByLikeName(name)) ;
	}
}
