package com.FarmersFriend.CartService.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.friend.farmers.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {

        System.out.println("Before method: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.friend.farmers.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After method: " + joinPoint.getSignature() + " returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.friend.farmers.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Exception in: " + joinPoint.getSignature() + " with message: " + ex.getMessage());
    }
}
