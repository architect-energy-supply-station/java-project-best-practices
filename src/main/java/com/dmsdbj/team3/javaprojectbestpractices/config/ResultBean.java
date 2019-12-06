package com.dmsdbj.team3.javaprojectbestpractices.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/5 5:53 下午
 * @Version 1.0
 * @Description
 **/
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
        ResultBean resultBean = new ResultBean(code, message);
        return resultBean;
    }

    public static <T> ResultBean<T> success(Collection<T> data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0000);
        resultBean.setData(data);
        resultBean.setMessage("success");
        return resultBean;
    }


    public static <T> ResultBean<T> success(T data) {
        ResultBean resultBean = new ResultBean();
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.add(data);
        resultBean.setMessage("success");
        resultBean.setData(arrayList);
        resultBean.setCode(0000);
        return resultBean;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("\"com.springboot.demo.springboottest.utils.ResultBean{\")");
        stringBuffer.append("code=").append(code);
        stringBuffer.append(",message=").append(message);
        stringBuffer.append(",data=").append(data);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

}
