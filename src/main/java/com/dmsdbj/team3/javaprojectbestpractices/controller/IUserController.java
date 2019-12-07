package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-02
 */
@Api(tags = {"用户表接口"})
@Validated
public interface IUserController {
    @ApiOperation(value = "根据Id查询用户", notes = "请输入用户ID")
    @GetMapping("/user/info/{id}")
    ResultBean<User> getUser(@ApiParam(value = "id", required = true,defaultValue = "1") @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/user/list")
    ResultBean<IPage> getUserList(@ApiParam(value = "page") @NotNull @Valid Page page);

    @ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
    @DeleteMapping("/user/remove/{id}")
    ResultBean<String> removeUser(@ApiParam(value = "id", required = true,defaultValue = "2") @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
    @PostMapping("/user/save")
    ResultBean<String> saveUser(@ApiParam(value = "user") @Valid @RequestBody User user);

    @ApiOperation(value = "根据姓名模糊查询", notes = "请输入要模糊查询的信息")
    @GetMapping(value = {"/user/getUserByLikeName/{name}"})
    ResultBean<List<User>> getUserByLikeName(@ApiParam(value = "name",required = true,defaultValue ="xiaoli") @NotBlank @NotNull @PathVariable String name);

    @ApiOperation(value = "更新用户手机号")
    @PostMapping("/user/updateUserByPhone/{oldPhone}/{newPhone}")
    ResultBean updateUserByPhone(@NotBlank @PathVariable String oldPhone, @NotBlank @PathVariable String newPhone);
}
