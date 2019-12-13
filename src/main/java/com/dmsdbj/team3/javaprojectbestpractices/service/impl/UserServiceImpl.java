package com.dmsdbj.team3.javaprojectbestpractices.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmsdbj.team3.javaprojectbestpractices.dao.UserDao;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

	@Autowired
	UserDao userDao;

	/**
	 * 根据姓名模糊查询信息
	 * @param
	 * @return
	 * @auther sunshinezhang
	 * @date 2019/12/9 8:43 下午
	 */
	@Override
	public List<User> getUserByLikeName(String queryName) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("name", queryName);
		log.info("用户输入的模糊查询的内容:[{}]", queryName);
		List<User> userList = userDao.selectList(queryWrapper);
		return userList;
	}

	/**
	 * 用户更新手机号
	 * @param  oldPhone,newPhone
	 * @return
	 * @auther sunshinezhang
	 * @date 2019/12/3 4:21 下午
	 */
	@Override
	@Transactional
	public boolean updateUserByPhone(String oldPhone,String newPhone) throws Exception {
		boolean debug = log.isDebugEnabled();
		if(debug){
			log.debug("用户输入的新旧手机号. args[oldPhone=[{}],newPhone=[{}]]", oldPhone, newPhone);
		}
		try {
			User userByPhone = userDao.getUserByPhone(oldPhone);
			if (userByPhone != null && !userByPhone.equals("")) {
				log.info("根据手机号查询到用户信息. phone=[{}],user=[{}]" , oldPhone,JSON.toJSONString(userByPhone));
				userByPhone.setPhone(newPhone);
			}
			userDao.updateById(userByPhone);
			return true;
		}catch(Exception e){
			log.error("用户更新手机号失败. phone=[{}]",oldPhone);
			return false;
		}
	}

	/**
	 *
	 * @param
	 * @return
	 * @auther sunshinezhang
	 * @date 2019/12/9 8:42 下午
	 */
	@Override
	public List<User> getUserByEmail(String email){
		return this.baseMapper.selectList(new QueryWrapper<User>()
				.lambda()
				.eq(User::getEmail, email));
	}

}
