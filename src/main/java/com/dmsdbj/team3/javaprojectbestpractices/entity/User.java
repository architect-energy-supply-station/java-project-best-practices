package com.dmsdbj.team3.javaprojectbestpractices.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private long id;
    private String name;
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