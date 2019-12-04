package com.dmsdbj.team3.javaprojectbestpractices.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author sunshine
 * @since 2019-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)

//@Accessors 注解用来配置lombok如何产生和显示getters和setters的方法。
//chain为一个布尔值，如果为true生成的set方法返回this，为false生成的set方法是void类型。默认为false，除非当fluent为true时，chain默认则为true
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	/**
	 * 姓名
	 */
	@NotBlank(message = "用户名不能为空")
	@Length(min = 6, max = 20, message = "用户名需要为 6 - 20 个字符")
	@Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
	private String name;

	/**
	 * 年龄
	 */
	@NotNull
	public Integer age;


	/**
	 * 邮箱
	 */
	@Email(message = "邮箱格式不正确")
	@NotBlank(message = "邮箱不能为空")
	private String email;

	@NotBlank(message = "手机号码不能为空")
	@Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
	private String phone;


	@TableField("userEvaluation")
	private String userEvaluation;

	@TableLogic
	private Integer deleted = 0;


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField(fill = FieldFill.INSERT)
	@Column(name = "create_time")
	private Date createTime;


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "update_time")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;


	@TableField(typeHandler = FastjsonTypeHandler.class)
	private OtherInfo otherInfo;

}
