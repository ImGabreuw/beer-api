package me.gabreuw.bearapi.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${application.api.base-package}")
    private String apiBasePackage;

    @Value("${application.api.title}")
    private String apiTitle;

    @Value("${application.api.description}")
    private String apiDescription;

    @Value("${application.api.version}")
    private String apiVersion;

    @Value("${application.contact.name}")
    private String contactName;

    @Value("${application.contact.github}")
    private String contactGithub;

    @Value("${application.contact.email}")
    private String contactEmail;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(apiBasePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiTitle)
                .description(apiDescription)
                .version(apiVersion)
                .contact(new Contact(contactName, contactGithub, contactEmail))
                .build();
    }

}
