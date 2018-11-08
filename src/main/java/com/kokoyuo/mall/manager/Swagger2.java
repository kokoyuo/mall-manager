package com.kokoyuo.mall.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kokoyuo
 * Created on 2018/10/29.
 */
@Configuration
@EnableSwagger2
public class Swagger2
{

    public static final String TOKEN_HEAD = "manager_token";

    @Bean
    public Docket createRestApi()
    {
        //添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name(TOKEN_HEAD).description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kokoyuo.mall.manager"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("mall-manager")
                .description("mall-manager")
                //.termsOfServiceUrl("localhost:8088/")
                .contact(new Contact("kokoyuo","www.kokoyuo.com","li354587806@qq.com"))
                .version("1.0.0")
                .build();
    }
}
