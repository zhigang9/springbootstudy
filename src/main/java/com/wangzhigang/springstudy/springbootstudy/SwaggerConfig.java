package com.wangzhigang.springstudy.springbootstudy;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

    @Bean
    public Docket createApi(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wangzhigang.springstudy.springbootstudy.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

    private ApiInfo apiInfo(){

        ApiInfo apiInfoBuilder = new ApiInfoBuilder()
                .title("springbootstudydocument")
                .description("文档描述")
                .termsOfServiceUrl("http://jd.com")
                .contact("wangzhigang")
                .version("1.0")
                .build();

        return apiInfoBuilder;
    }
}
