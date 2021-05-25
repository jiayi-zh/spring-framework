package org.springframework.springlearn.sourcetracking.beanconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.springlearn.entity.User;

/**
 * 注解 @Configuration Lite
 *
 * @author ZhengYu
 * @version 1.0 2021/5/25 13:33
 **/
@Configuration(proxyBeanMethods = false)
public class ConfigurationLiteModeConfig {

	@Bean
	public User user() {
		User user = new User();
		user.setName("configuration lite");
		return user;
	}
}
