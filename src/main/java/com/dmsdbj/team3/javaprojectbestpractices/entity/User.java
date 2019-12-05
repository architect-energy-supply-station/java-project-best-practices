package com.dmsdbj.team3.javaprojectbestpractices.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class User {

    /**
     * 表主键 此处需要设置为数据库ID自增
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="主键id",example = "1")
    private long id;
    private String name;

    @ApiModelProperty(value="年龄",example = "22")
    private int age;
    private String email;
    private String phone;
    /**
     * 此处故意用了类字段名和数据库列明不相符
     * 可以用@TableField注解来表示
     */
    @TableField("userEvaluation")
    private String evaluation;
}