package org.springframework.springlearn.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.springlearn.cache.service.CacheBusinessService;
import org.springframework.springlearn.entity.User;

/**
 * Spring Cache 源码分析 https://blog.csdn.net/u012240455/article/details/80844361
 * <p>
 * {@link EnableCaching} 引入配置:
 * {@link org.springframework.context.annotation.AutoProxyRegistrar}: 检测并向Spring容器注入 AbstractAutoProxyCreator Bean
 * {@link org.springframework.cache.annotation.ProxyCachingConfiguration}:
 * 1. {@link org.springframework.cache.annotation.AnnotationCacheOperationSource} 处理注解 Cacheable CachePut CacheEvict
 *
 * 核心处理逻辑: org.springframework.cache.interceptor.CacheAspectSupport#execute(org.springframework.cache.interceptor.CacheOperationInvoker, java.lang.reflect.Method, org.springframework.cache.interceptor.CacheAspectSupport.CacheOperationContexts)
 *
 * 相关注解： @Cacheable, @CacheEvict，@CachePut，@Caching
 * @author ZhengYu
 * @version 1.0 2021/6/18 0:14
 **/
@ComponentScan(basePackages = "org.springframework.springlearn.cache")
public class SpringCacheTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpringCacheTest.class);
		applicationContext.refresh();

		CacheBusinessService cacheBusinessService = applicationContext.getBean("cacheBusinessService", CacheBusinessService.class);
		cacheBusinessService.addUser(1L);

		// 走数据库查询
		User user = cacheBusinessService.getUser(1L);
		System.out.println(user.getId());
		// 走缓存
		cacheBusinessService.getUser(1L);

		// 变更


		// 没有命中数据的情况
		System.out.println(cacheBusinessService.getUser(2L).getId());
		System.out.println(cacheBusinessService.getUser(2L).getId());

		applicationContext.close();
	}
}
