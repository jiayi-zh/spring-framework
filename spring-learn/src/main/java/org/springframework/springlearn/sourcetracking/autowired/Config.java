package org.springframework.springlearn.sourcetracking.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.springlearn.entity.User;

/**
 * User
 *
 * @author ZhengYu
 * @version 1.0 2021/4/23 17:52
 **/
@Configuration
public class Config {

	@Bean
	public User user() {
		User user = new User();
		user.setId(1L);
		user.setName("user");
		return user;
	}
}
