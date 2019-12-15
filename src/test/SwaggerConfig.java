//package com.dmsdbj.team3.javaprojectbestpractices.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Collections;
//
///**
// * @ClassName java-project-best-practices
// * @Author cookr
// * @Date 2019/12/3 2:34 下午
// * @Version 1.0
// * @Description
// **/
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "最佳实践之Spring Boot 项目集成 Swagger 实例文档",
//                "我的搜索网站：https://baidu.com，欢迎大家访问。",
//                "API V1.0",
//                "Terms of service",
//                new Contact("swagger2集成", "https://baidu.com", "shuai_0303@163.com"),
//                "Apache", "http://www.apache.org/", Collections.emptyList());
//    }
//}
