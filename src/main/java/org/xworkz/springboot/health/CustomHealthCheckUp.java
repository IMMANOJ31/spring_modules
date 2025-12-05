package org.xworkz.springboot.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheckUp implements HealthIndicator {


    @Override
    public Health health() {
        System.out.println("CustomHealthCheckUp.health");
        if (isHealthy()){
            return Health.up().withDetail("healthCheck","Working!!").build();
        }
        return Health.down().withDetail("healthCheck","Issue").build();
    }
    private boolean isHealthy(){
        return false;
    }

    @Autowired
    private CacheManager cacheManager;

    public void printCacheContents() {
        Cache cache = cacheManager.getCache("bootCache");
        if (cache != null) {
            Object nativeCache = cache.getNativeCache();
            System.out.println(nativeCache);
        }
    }

}
