package com.dmsdbj.team3.javaprojectbestpractices.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Service
public interface UserMapper extends BaseMapper<User> {
    List<User> selectUserByPhone(String phone);
}
