package org.xworkz.springboot.health;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

@SpringBootTest
public class CustomHealthCheckUpTest {

    @Autowired
    private CacheManager cacheManager;

    @Test
    void testPrintCacheContents() {
        Cache cache = cacheManager.getCache("bootCache");
        if (cache != null) {
            Object nativeCache = cache.getNativeCache();
            System.out.println("Cache contents: " + nativeCache);
        }
    }
}
