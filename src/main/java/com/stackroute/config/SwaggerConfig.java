package com.stackroute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket DocketApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors
                        .basePackage("com.stackroute"))
                .paths(regex("/api/v1/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfo("Music","Spring Boot application","1.0","Terms of service",new Contact("Pallavi", "http://google.com","p.pallavi8296@gmail.com"),"Apache License version 2.0","https://www.apache.org/license/LICENSE-2.0") ;
        return apiInfo;
    }

}
