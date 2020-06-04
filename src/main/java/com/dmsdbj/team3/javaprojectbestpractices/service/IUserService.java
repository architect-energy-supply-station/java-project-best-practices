package com.dmsdbj.team3.javaprojectbestpractices.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
public interface IUserService extends IService<User> {
    List<User> getUserByLikeName(String name);

    List<User> getUserByName(String name);

    //根据用户的手机号更新用户信息
    boolean updateUserByPhone(String oldPhone,String newPhone) throws Exception;


    boolean updateUserByName(String oldName, String newName);
//
    List<User> getUserByEmail(String email);
//

}
