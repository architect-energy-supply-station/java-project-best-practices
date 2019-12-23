package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.config.ResultBean;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/3 3:52 下午
 * @Version 1.0
 * @Description
 **/

@Api(tags = "用户管理接口")
@RequestMapping("v1/users/")
public interface IUserController {
    @ApiOperation(value = "新增用户接口", notes = "返回userEntity实体")
    @PostMapping("save")
    ResultBean saveUser(@ApiParam(value = "userEntity", required = true) @RequestBody @Valid User userEntity);

    @ApiOperation(value = "根据id删除用户", notes = "返回删除id")
    @DeleteMapping("remove/{id}")
    ResultBean removeUser(@ApiParam(value = "id", required = true) @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "根据id显示用户信息", notes = "返回userEntity实体")
    @GetMapping("info/{id}")
    ResultBean getUser(@ApiParam(value = "id", required = true) @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "显示用户信息列表", notes = "返回分页")
    @GetMapping("getUserList")
    ResultBean getUserList(@ApiParam(value = "page") @NotNull @Valid Page page);

    @ApiOperation(value = "根据姓名查询用户信息", notes = "返回实体")
    @GetMapping("getUserByName/{name}")
    ResultBean getUserByName(@ApiParam(value = "name", required = true) @NotBlank @PathVariable("name") String name);

    @ApiOperation(value = "查询配置文件中自定义属性的值")
    @GetMapping("getSettingValue")
    String getSettingValue();

    @ApiOperation(value = "根据用户的手机号更新用户信息", notes = "请输入用户的新旧手机号")
    @GetMapping("updateUserByPhone/{oldPhone}/{newPhone}")
    ResultBean<Boolean> updateUserByPhone(@ApiParam(value = "oldPhone", required = true) @NotBlank @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号码格式错误") @RequestParam("oldPhone") String oldPhone, @ApiParam(value = "newPhone", required = true) @NotBlank @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误") @RequestParam("newPhone") String newPhone) throws Exception;

}
