//package com.FarmersFriend.ProductService.AOP;//package com.friend.farmers.AOP;
////
////import org.aspectj.lang.ProceedingJoinPoint;
////import org.aspectj.lang.annotation.Around;
////import org.aspectj.lang.annotation.Aspect;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.cache.Cache;
////import org.springframework.cache.CacheManager;
////import org.springframework.cache.annotation.Cacheable;
//////import org.aspectj.lang.ProceedingJoinPoint;
//////import org.aspectj.lang.annotation.Around;
//////import org.aspectj.lang.annotation.Aspect;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.cache.CacheManager;
//////import org.springframework.cache.annotation.Cacheable;
////import org.springframework.stereotype.Component;
//
//import jakarta.persistence.Cacheable;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//
//import org.springframework.stereotype.Component;
//
//import static org.springframework.cache.interceptor.SimpleKeyGenerator.generateKey;
//
////
////import static org.springframework.cache.interceptor.SimpleKeyGenerator.generateKey;
////
//@Aspect
//@Component
//public class CacheAspect {
//
//    @Autowired
//    private CacheManager cacheManager;
//
//    @Around("@annotation(cacheable)")
//    public Object cacheResult(ProceedingJoinPoint pjp,
//                              Cacheable cacheable) throws Throwable {
//        String key = (String) generateKey(pjp, cacheable);
//        Cache cache = cacheManager.getCache(cacheable.value());
//
//        Cache.ValueWrapper cached = cache.get(key);
//        if (cached != null) return cached.get();
//
//        Object result = pjp.proceed();
//        cache.put(key, result);
//        return result;
//    }
//}