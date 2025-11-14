package org.xworkz.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public LoggingAspect() {
        System.err.println("Invoking logging aspect...");
    }

    //@Pointcut

    @Before("execution(* com.xworkz.springboot.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        joinPoint.getSignature();

        System.err.println("Logging BEFORE: " + joinPoint.getSignature());
    }

    @AfterReturning("execution(* com.xworkz.springboot.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.err.println("Logging AFTER: " + joinPoint.getSignature());
    }
}
