package org.springframework.springlearn.sourcetracking.beanconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.springlearn.entity.User;

/**
 * 注解 @Configuration
 *
 * @author ZhengYu
 * @version 1.0 2021/5/25 13:33
 **/
@Configuration
public class ConfigurationFullModeConfig {

	@Bean
	public User user() {
		User user = new User();
		user.setName("configuration full");
		return user;
	}
}
