package org.springframework.springlearn.sourcetracking.beanconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.springlearn.entity.User;
import org.springframework.stereotype.Component;

/**
 * 注解 @Bean 作用于静态方法上
 *
 * @author ZhengYu
 * @version 1.0 2021/5/25 13:37
 **/
@Component
public class StaticBeanConfig {

	@Bean
	public static User user() {
		User user = new User();
		user.setName("static");
		return user;
	}
}
