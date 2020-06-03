package com.dmsdbj.team3.javaprojectbestpractices.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team3.javaprojectbestpractices.entity.User;
import com.dmsdbj.team3.javaprojectbestpractices.utils.exception.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Api(tags = {"用户表接口"})
@Validated
public interface IUserController {
    @ApiOperation(value = "根据Id查询用户", notes = "请输入用户ID")
    @GetMapping("/user/info/{id}")
//    User getUser(@ApiParam(value = "id", required = true, defaultValue = "4") @NotNull @PathVariable("id") int id);
    ResultBean<User> getUser(@ApiParam(value = "id", required = true, defaultValue = "4") @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/user/list")
    ResultBean<IPage> getUserList(@ApiParam(value = "page", required = true) @NotNull @Valid Page page);

    @ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
    @DeleteMapping("/user/remove/{id}")
//    String removeUser(@ApiParam(value = "id", required = true, defaultValue = "2") @NotNull @PathVariable("id") int id);
    ResultBean<Boolean> removeUser(@ApiParam(value = "id", required = true, defaultValue = "2") @NotNull @PathVariable("id") int id);

    @ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
    @PostMapping("/user/save")
//    String saveUser(@ApiParam(value = "user", required = true) @Valid @RequestBody User user);
     ResultBean<Boolean>  saveUser(@ApiParam(value = "user", required = true) @Valid @RequestBody User user);

    @ApiOperation(value = "根据姓名模糊查询", notes = "请输入要模糊查询的信息")
    @GetMapping(value = {"/user/getUserByLikeName/{name}"})
//    List<User> getUserByLikeName(@ApiParam(value = "name", required = true)@NotBlank @PathVariable String name);
    ResultBean<User> getUserByLikeName(@ApiParam(value = "name", required = true)@NotBlank @PathVariable String name);

    @ApiOperation(value = "查询得到配置文件中自定义属性的值")
    @GetMapping("/user/getSettingValue")
    String getSettingValue();

    @ApiOperation(value = "根据用户姓名查询用户信息",notes = "请输入用户姓名")
    @GetMapping("/user/getUserByName/{name}")
    ResultBean<User> getUserByName(@ApiParam(value = "name", required = true)@NotBlank @PathVariable String name);



//    @ApiOperation(value = "根据Id查询用户", notes = "请输入用户ID")
//    @GetMapping("/user/info/{id}")
//    ResultBean<User> getUser(@ApiParam(value = "id", required = true, defaultValue = "4") @NotNull @PathVariable("id") int id);
//
//    @ApiOperation(value = "查询所有用户")
//    @GetMapping("/user/list")
//    ResultBean<IPage> getUserList(@ApiParam(value = "page", required = true,defaultValue = "1")@NotNull @RequestParam int page,@ApiParam(value = "pageSize",required = true,defaultValue = "10")@NotNull @RequestParam int pagesize);
//
//    @ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
//    @DeleteMapping("/user/remove/{id}")
//    ResultBean<Boolean> removeUser(@ApiParam(value = "id", required = true, defaultValue = "2") @NotNull @PathVariable("id") int id);
//
//    @ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
//    @PostMapping("/user/save")
//    ResultBean<Boolean> saveUser(@ApiParam(value = "user", required = true) @RequestBody User user);

//    @ApiOperation(value = "根据姓名模糊查询", notes = "请输入要模糊查询的信息")
//    @GetMapping(params = "name")
//    ResultBean<User> getUserByLikeName(@ApiParam(value = "name", required = true) @NotBlank @RequestParam String name);

//    @ApiOperation(value = "根据邮箱查询用户信息", notes = "请输入要查询的邮箱")
//    @GetMapping(params = "email")
//    ResultBean<User> getUserByEmail(@ApiParam(value = "email", required = true) @NotBlank @RequestParam String email);

//    @ApiOperation(value = "更新用户手机号", notes = "请输入用户的新旧手机号")
//    @GetMapping("{oldPhone}/{newPhone}")
//    ResultBean<Boolean> updateUserByPhone(@ApiParam(value = "oldPhone", required = true) @NotBlank @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号码格式错误") @RequestParam("oldPhone") String oldPhone, @ApiParam(value = "newPhone", required = true) @NotBlank @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误") @RequestParam("newPhone") String newPhone) throws Exception;



//    @ApiOperation(value = "更新用户名", notes = "请输入用户的新旧姓名")
//    @GetMapping("{oldName}/{newName}")
//    ResultBean<Boolean> updateUserByName(@ApiParam(value = "oldName", required = true) @RequestParam("oldName") String oldName, @NotBlank  @RequestParam("newName") String newName) throws Exception;

}
