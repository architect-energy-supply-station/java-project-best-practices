package com.dmsdbj.team3.javaprojectbestpractices.entity;

import com.dmsdbj.team3.javaprojectbestpractices.service.IUserService;
import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserTest {


    @Autowired
    private IUserService iUserService;
    @Test
    void getEmail() {
    }

    @Test
    void setEmail() {
        User user=new User();
        user.setEmail("fdasfadsfadsfasdf");
        Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(false)
                .buildValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> result = validator.validate(user);

        // 输出错误消息
        result.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
                .forEach(System.out::println);
    }
}