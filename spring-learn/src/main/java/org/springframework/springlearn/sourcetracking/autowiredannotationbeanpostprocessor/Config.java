package org.springframework.springlearn.sourcetracking.autowiredannotationbeanpostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.springlearn.entity.User;
import org.springframework.stereotype.Component;

/**
 * User
 *
 * @author ZhengYu
 * @version 1.0 2021/4/23 17:52
 **/
@Component
public class Config {

	@Bean
	public User user() {
		User user = new User();
		user.setId(1L);
		user.setName("user");
		return user;
	}
}
