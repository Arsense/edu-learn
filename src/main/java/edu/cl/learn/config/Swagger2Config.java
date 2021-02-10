package edu.cl.learn.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: Clay
 * @Date: 2021/2/10 11:40 下午
 */
public class Swagger2Config {

    /**
     * 注入swagger基础配置对象
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("edu.cl.learn.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();

    }


    /**
     * 页面基础info
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口测试管理端")
                .description("demo")
                .version("1.0")
                .build();
    }

}
