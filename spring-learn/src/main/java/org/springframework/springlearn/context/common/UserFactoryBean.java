package org.springframework.springlearn.context.common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.springlearn.entity.User;

/**
 * {@link org.springframework.springlearn.entity.User} 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 *
 * @author ZhengYu
 * @version 1.0 2021/1/16 22:31
 **/
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() {
		User user = new User();
		user.setId(2L);
		user.setName("user_factoryBean");
		user.setAge(0);
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
