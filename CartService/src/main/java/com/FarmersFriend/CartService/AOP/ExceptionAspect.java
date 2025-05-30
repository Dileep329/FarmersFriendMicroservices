package com.FarmersFriend.CartService.AOP;//package com.friend.farmers.AOP;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class ExceptionAspect {
//
//    @AfterThrowing(pointcut = "execution(* com.example..*(..))",
//                  throwing = "ex")
//    public void handleException(JoinPoint jp, Exception ex) {
//
//        errorTracker.track(ex, jp.getSignature().toString());
//    }
//}