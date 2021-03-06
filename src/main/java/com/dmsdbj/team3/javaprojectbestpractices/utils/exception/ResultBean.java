package com.dmsdbj.team3.javaprojectbestpractices.utils.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Classname ResultBean
 * @Auther sunshinezhang
 * @Date 2019/12/3 14:28
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResultBean<T> {

	private int code;
	private String message;
	private Collection<T> data;

	private ResultBean() {

	}

	private ResultBean(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private ResultBean(int code, String message, Collection<T> data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}


	public static ResultBean error(int code, String message) {
		ResultBean resultBean = new ResultBean();
		resultBean.setCode(code);
		resultBean.setMessage(message);
		return resultBean;
	}


	public static <V> ResultBean<V> success(Collection<V> data) {
		ResultBean resultBean = new ResultBean();
		resultBean.setMessage("success");
		resultBean.setData(data);
		resultBean.setCode(0000);
		return resultBean;
	}

	public static <V> ResultBean<V> success(V data) {
		ResultBean resultBean = new ResultBean();
		Collection<V> temp = new ArrayList<V>();
		temp.add(data);
		resultBean.setMessage("success");
		resultBean.setData(temp);
		resultBean.setCode(0000);
		return resultBean;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.springboot.demo.springboottest.utils.ResultBean{");
		sb.append("code=").append(code);
		sb.append(", message='").append(message).append('\'');
		sb.append(", data=").append(data);
		sb.append('}');
		return sb.toString();
	}
}
