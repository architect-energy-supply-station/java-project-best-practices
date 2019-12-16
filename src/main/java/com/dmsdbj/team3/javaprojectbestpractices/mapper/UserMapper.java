package com.dmsdbj.team3.javaprojectbestpractices.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User getUserByLikeName(String name);

    User selectUserByPhone(String phone);

}
