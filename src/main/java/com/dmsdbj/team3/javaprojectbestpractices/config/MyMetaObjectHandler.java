package com.dmsdbj.team3.javaprojectbestpractices.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/12 8:46 上午
 * @Version 1.0
 * @Description
 **/

@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createFieldType = getFieldValByName("createTime", metaObject);
        Object updateFieldType = getFieldValByName("updateTime", metaObject);
        if (createFieldType == null) {
            setFieldValByName("createTime", new Date(), metaObject);
        }

        if (updateFieldType==null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateFieldType = getFieldValByName("updateTime", metaObject);

        if (updateFieldType==null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

    }
}
