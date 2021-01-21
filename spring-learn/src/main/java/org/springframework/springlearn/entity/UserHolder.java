package org.springframework.springlearn.entity;

/**
 * UserHolder
 *
 * @author ZhengYu
 * @version 1.0 2021/1/21 19:17
 **/
public class UserHolder {

	private final User user;

	public UserHolder(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"user=" + user +
				'}';
	}
}
