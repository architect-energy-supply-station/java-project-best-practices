package com.dmsdbj.team3.javaprojectbestpractices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
// 通过@Configuration 注解，让Spring 来加载该配置类
@Configuration
// 通过@EnableSwagger2注解来启动Swagger2
@EnableSwagger2
/**
 * Swagger常用注解使用工具箱
 * @Api：用在类上，说明该类的作用。
 * @ApiOperation：注解来给API增加方法说明。
 * @ApiImplicitParams : 用在方法上包含一组参数说明。
 * @ApiImplicitParam：用来注解来给方法入参增加说明。
 * @ApiResponses：用于表示一组响应
 * @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
 * code：数字，例如400
 * message：信息，例如"请求参数没填好"
 * response：抛出异常的类
 * @ApiModel：描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
 * @ApiModelProperty：描述一个model的属性
 */
public class Swagger2 {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回了一个APiSelectorBuilder实例，用来控制哪些接口暴露给Swagger来展现，
     * 本例采用执行扫描的包路径来定义指定要建立的API的目录
     *   Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
     * @return
     *
     * paths() 这种方式可以通过筛选Api 的url来进行筛选
     */
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("标准接口")
                .apiInfo(apiInfo("Spring Boot 中使用Swagger2构建Restful APIs", "1.0"))
//                .useDefaultResponseMessages(true)
//                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dmsdbj.team3.javaprojectbestpractices.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * @param title
     * @param version
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title("SpringBoot利用 Swagger构建api文档")
                .version("1.0")
                .build();

    }

}
