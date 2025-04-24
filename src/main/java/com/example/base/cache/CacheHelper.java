package com.example.base.cache;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CacheHelper {

    private final CacheManager cacheManager;

    @NotNull
    public Cache getCache(CacheName cacheName) {
        return Objects.requireNonNull(cacheManager.getCache(cacheName.getName()));
    }
}
