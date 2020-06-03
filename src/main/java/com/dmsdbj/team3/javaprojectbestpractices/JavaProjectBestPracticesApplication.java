package com.dmsdbj.team3.javaprojectbestpractices;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.dmsdbj.team3.javaprojectbestpractices.mapper")
public class JavaProjectBestPracticesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectBestPracticesApplication.class, args);
	}

}
