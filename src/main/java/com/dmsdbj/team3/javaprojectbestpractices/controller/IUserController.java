package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = {"用户表接口"})
@Validated
public interface IUserController {
    @ApiOperation(value = "根据Id查询用户", notes = "请输入用户ID")
    @GetMapping("/user/info/{id}")
    User getUser(@ApiParam(value = "id", required = true, defaultValue = "4") @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/user/list")

    IPage getUserList(@ApiParam(value = "page", required = true) Page page);

    @ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
    @DeleteMapping("/user/remove/{id}")
    String removeUser(@ApiParam(value = "id", required = true, defaultValue = "2") @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
    @PostMapping("/user/save")
    String saveUser(@ApiParam(value = "user", required = true)@Valid @RequestBody User user);
}
