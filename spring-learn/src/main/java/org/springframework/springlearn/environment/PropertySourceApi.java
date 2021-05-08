package org.springframework.springlearn.environment;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 资源
 *
 * @author ZhengYu
 * @version 1.0 2021/5/8 9:34
 **/
public class PropertySourceApi {
	public static void main(String[] args) throws IOException {
		// ClassPathResource -> PropertySourceFactory -> PropertySource
		ClassPathResource classPathResource = new ClassPathResource("environment/application.properties");
		PropertySourceFactory propertySourceFactory = new DefaultPropertySourceFactory();
		PropertySource<?> propertySource = propertySourceFactory.createPropertySource(null, new EncodedResource(classPathResource, StandardCharsets.UTF_8));

		// 结构体PropertySource
		Properties properties = new Properties();
		properties.setProperty("user.age", "20");
		PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("custom_property_source", properties);

		// Environment -> getPropertySources -> addLast
		ConfigurableEnvironment environment = new StandardEnvironment();
		environment.getPropertySources().addLast(propertySource);
		environment.getPropertySources().addLast(propertiesPropertySource);

		System.out.println(environment.getProperty("user.name"));
		System.out.println(environment.getProperty("user.age"));
	}
}
