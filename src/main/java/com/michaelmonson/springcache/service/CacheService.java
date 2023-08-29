package com.michaelmonson.springcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {

	private final CacheManager cacheManager;

	@Autowired
	public CacheService(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public List<Object> getAllEntriesFromStudentCache(String cacheName) {

		Cache cache = cacheManager.getCache(cacheName);

		List<Object> entries = new ArrayList<>();
		if (cache != null) {
			//Object nativeCache = cache.getNativeCache();
			//if (cache instanceof ConcurrentMapCache) {
			//	Map<Object, Object> cacheMap = ((ConcurrentMapCache) nativeCache).getNativeCache();
			//	entries.addAll(cacheMap.values());

			Object nativeCache = cache.getNativeCache();
			if (nativeCache instanceof ConcurrentHashMap<?, ?> concurrentHashMap) {
				entries.addAll(concurrentHashMap.values());
			}
				/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-
				 * Unfortunately, the Cache interface itself does not have a forEach method.
				 * To retrieve ALL entries from the cache, I need to use the Cache interface's getNativeCache() method
				 * (if supported by the cache provider) and then use the provider-specific API to access the entries.
				 * -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-
				 */
				// cache.forEach(entry -> entries.add(entry.get())));
//			}
		}
		return entries;
	}

}
