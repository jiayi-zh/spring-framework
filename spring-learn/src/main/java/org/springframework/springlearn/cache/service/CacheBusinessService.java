package org.springframework.springlearn.cache.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.springlearn.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CacheService
 *
 * @author ZhengYu
 * @version 1.0 2021/6/18 9:30
 **/
@CacheConfig(cacheNames = "businessCache")
@Service
public class CacheBusinessService {

	private static final Map<Long, User> DB = new ConcurrentHashMap<>();

	public void addUser(Long id) {
		User user = new User();
		user.setId(id);
		DB.put(id, user);
	}

	@Cacheable(cacheNames = "userCache", key = "#userId")
	public User getUser(Long userId) {
		System.out.println("走数据库查询");
		return DB.get(userId);
	}

	@Cacheable(cacheNames = "userCache", key = "#user.id", condition = "#user.name != null and #user.name.length() > 0")
	public User putUser(User user) {
		return user;
	}


}
