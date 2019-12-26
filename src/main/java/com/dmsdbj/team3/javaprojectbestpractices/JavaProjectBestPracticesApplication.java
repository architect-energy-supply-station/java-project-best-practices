package com.dmsdbj.team3.javaprojectbestpractices;

import com.github.itmanito.swaggerspringbootautoconfigure.EnableAngelSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//自定义starter：swagger
@EnableAngelSwagger2
public class JavaProjectBestPracticesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectBestPracticesApplication.class, args);
	}

}
