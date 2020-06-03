package com.dmsdbj.team3.javaprojectbestpractices.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 填充字段createTime 和updateTime
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        Object createFieldType = getFieldValByName("createTime", metaObject);
        Object updateFieldType = getFieldValByName("updateTimee", metaObject);
        if (createFieldType == null) {
            setFieldValByName("createTime", new Date(), metaObject);

        }
        if (updateFieldType == null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        Object updateFieldType = getFieldValByName("updateTime", metaObject);
        if (updateFieldType == null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

    }
}
