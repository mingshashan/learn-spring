package com.mingshashan.learn.es.config;


import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.*;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * SwaggerConfig.
 *
 * @author xufj (mailto: xufj@primeton.com)
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * @return
     */
    @Bean
    public ObjectMapper ymlObjectMapper() {
        ObjectMapper ymlObjectMapper = new ObjectMapper(new YAMLFactory());
        //Enable or disable features
        return ymlObjectMapper;
    }

    /**
     * @return
     */
    @Bean
    public Docket coreApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("learn-es Service").select()
                // .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mingshashan.learn.es")).paths(PathSelectors.any()).build();
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("learn-es API文档").description(
                "This is a sample server learn-es server. You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the controller key `special-key` to test the authorization filters.")
                .version("1.0.0").termsOfServiceUrl("http://swagger.io/terms/")
                .contact(new Contact("mingshashan", "", "mingshashan@gmail.com")).build();
    }

    /**
     * @param resolver
     * @return
     */
    @Bean
    public AlternateTypeRuleConvention pageableConvention(final TypeResolver resolver) {
        return new AlternateTypeRuleConvention() {

            @Override
            public int getOrder() {
                return Ordered.HIGHEST_PRECEDENCE;
            }

            @Override
            public List<AlternateTypeRule> rules() {
                return newArrayList(newRule(resolver.resolve(Pageable.class), resolver.resolve(pageableMixin())),
                        newRule(resolver.resolve(Page.class), resolver.resolve(pageMixin())));
            }
        };
    }

    /**
     * @return
     */
    private Type pageMixin() {
        return new AlternateTypeBuilder()
                .fullyQualifiedClassName(
                        String.format("%s.generated.%s", Page.class.getPackage().getName(), Page.class.getSimpleName()))
                .withProperties(newArrayList(property(Array.class, "content"), property(boolean.class, "last"),
                        property(Integer.class, "totalPages"), property(Integer.class, "totalElements"),
                        property(Integer.class, "number"), property(boolean.class, "first"),
                        property(Integer.class, "numberOfElements")))
                .build();
    }
    // tag::alternate-type-rule-convention[]

    // tag::alternate-type-builder[]

    /**
     * @return
     */
    private Type pageableMixin() {
        return new AlternateTypeBuilder()
                .fullyQualifiedClassName(String.format("%s.generated.%s", Pageable.class.getPackage().getName(),
                        Pageable.class.getSimpleName()))
                .withProperties(newArrayList(property(Integer.class, "page"), property(Integer.class, "size"),
                        property(String.class, "sort")))
                .build();
    }

    private AlternateTypePropertyBuilder property(Class<?> type, String name) {
        return new AlternateTypePropertyBuilder().withName(name).withType(type).withCanRead(true).withCanWrite(true);
    }
}