package com.primeton.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 通过@Configuration注解，表明它是一个配置类， @EnableSwagger2开启swagger2。 apiINfo()配置一些基本的信息。
 * apis()指定扫描的包会生成文档。
 * 
 * @author liuya
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * swagger2的配置文件，这里可以配置swagger2的一些基本的内容
	 * 
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// apiINfo()配置一些基本的信息。
				.apiInfo(apiInfo()).select()
				// apis()指定扫描的包会生成文档。
				.apis(RequestHandlerSelectors.basePackage("com.primetom.umsystem.controller"))
				.paths(PathSelectors.any()).build();
	}

	/**
	 * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 标题
				.title("springboot利用swagger构建api文档")
				// 描述
				.description("restful风格")
				// 创建人
				.contact(new Contact("刘亚威", "", "liuyawei615@163.com"))
				// 个人链接
				.termsOfServiceUrl("链接")
				// 版本
				.version("1.0").build();
	}

}
