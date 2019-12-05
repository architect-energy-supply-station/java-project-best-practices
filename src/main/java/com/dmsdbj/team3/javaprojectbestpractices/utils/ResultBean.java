package com.dmsdbj.team3.javaprojectbestpractices.utils;
import	java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Collection;
import java.util.Collections;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBean<T> {

    private int code;
    private String message;
    private Collection<T> data;

    public ResultBean() {
    }

    public ResultBean(int code, String message, Collection<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultBean error(int code, String message) {
        ResultBean resultBean = new ResultBean(code, message);
        return resultBean;
    }

    public static <T> ResultBean<T> sucess(Collection<T> data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }

    public static <T> ResultBean<T> success(T data) {
        ResultBean resultBean = new ResultBean();
        Collection<T> collection = new ArrayList<T>();
        collection.add(data);
        resultBean.setCode(0);
        resultBean.setMessage("success");
        resultBean.setData(collection);
        return resultBean;
    }
}
