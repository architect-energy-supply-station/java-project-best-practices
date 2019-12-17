package com.dmsdbj.team3.javaprojectbestpractices.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Repository
public interface UserDao extends BaseMapper<User> {

	User getUserByPhone(String phone);
}
