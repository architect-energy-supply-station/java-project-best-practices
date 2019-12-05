package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/3 3:52 下午
 * @Version 1.0
 * @Description
 **/

@Api(tags = "用户管理接口")
public interface IUserController {
    @ApiOperation(value = "新增用户接口", notes = "返回userEntity实体")
    @PostMapping("/user/save")
    String saveUser(@ApiParam(value = "userEntity", required = true) @RequestBody User userEntity);

    @ApiOperation(value = "根据id删除用户",notes = "返回删除id")
    @DeleteMapping("/user/remove/{id}")
    String removeUser(@ApiParam(value = "id",required = true)@PathVariable("id") int id);

    @ApiOperation(value = "根据id显示用户信息",notes = "返回userEntity实体")
    @GetMapping("/user/info/{id}")
    User getUser(@ApiParam(value = "id",required = true)@PathVariable("id") int id);

    @ApiOperation(value = "显示用户信息列表",notes = "返回分页")
    @GetMapping("/user/list")
    IPage getUserList( Page page);
}
