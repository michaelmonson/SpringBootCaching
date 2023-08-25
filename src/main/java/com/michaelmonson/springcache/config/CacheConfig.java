package com.michaelmonson.springcache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	/**
	 * Cache Manager class Configuration
	 *
	 * Created a ConcurrentMapCacheManager bean, specifying the initial cache name of "student."
	 * As we need more, we can define multiple cache names by adding more strings to the ConcurrentMapCacheManager constructor.
	 *
	 * @return CacheManager interface
	 */
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("student"); // Define cache names here
	}
}
