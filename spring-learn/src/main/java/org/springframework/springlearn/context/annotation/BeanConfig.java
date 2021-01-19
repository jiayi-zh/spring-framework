package org.springframework.springlearn.context.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.springlearn.context.common.UserFactoryBean;
import org.springframework.springlearn.entity.User;

/**
 * 注解方式的IOC容器Bean配置
 *
 * @author ZhengYu
 * @version 1.0 2021/1/16 22:20
 **/
public class BeanConfig {

	/**
	 * 注解方式配置Bean
	 * <p>
	 * 扫描: {@link }
	 */
	@Bean
	public User annotationUser() {
		User user = new User();
		user.setId(1L);
		user.setName("user_annotation");
		user.setAge(0);
		return user;
	}

	@Bean
	public UserFactoryBean factoryBeanUser() {
		return new UserFactoryBean();
	}
}
