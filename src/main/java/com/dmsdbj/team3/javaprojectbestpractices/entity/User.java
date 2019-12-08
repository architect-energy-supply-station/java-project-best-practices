package com.dmsdbj.team3.javaprojectbestpractices.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Profile;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 *
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@TableName("user")
@Data
@ApiModel("用户实体")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class User {

    /**
     * 表主键 此处需要设置为数据库ID自增
     */
    @ApiModelProperty("用户id")
    @TableId(type = IdType.AUTO)
    @NotNull
    private long id;
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty("姓名")
    private String name;

    @NotNull
    @ApiModelProperty("年龄")
    private int age;

    @NotBlank(message = "邮箱不为空")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty("邮箱")
    private String email;


    @NotBlank(message = "手机号不为空")
    @Pattern(regexp = "[1][3,4,5,6,7,8,9][0-9]{9}$",message = "手机格式有误")
    @ApiModelProperty("电话")
    private String phone;

    /**
     * 此处故意用了类字段名和数据库列明不相符
     * 可以用@TableField注解来表示
     */

    @ApiModelProperty("评价")
    @TableField("userEvaluation")
    private String userEvaluation;

    @ApiModelProperty("是否删除")
    private int deleted;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Data createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    private Data updateTime;

//    @ApiModelProperty("附加")
//    private String otherInfo;

}