package org.xworkz.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public LoggingAspect() {
        System.err.println("Invoking logging aspect...");
    }

    @Pointcut("execution(* com.xworkz.springboot.service.*.*(..))")
    public void allService(){
        //marker method
    }

    @Before("allService()")
    public void logBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        Object target = joinPoint.getTarget();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        String longString = joinPoint.toLongString();
        String shortString = joinPoint.toShortString();
        String string = joinPoint.toString();

        System.out.println("Signature: "+signature);
        System.out.println("Args: "+args);
        System.out.println("Kind "+kind);
        System.out.println("Source location: "+sourceLocation);
        System.out.println("Target: "+target);
        System.out.println("Static part: "+staticPart);
        System.out.println("Long String: "+longString);
        System.out.println("Short String: "+shortString);
        System.out.println("String: "+string);
    }

    @AfterReturning("allService()")
    public void logAfter(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        Object target = joinPoint.getTarget();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        String longString = joinPoint.toLongString();
        String shortString = joinPoint.toShortString();
        String string = joinPoint.toString();

        System.err.println("Signature: "+signature);
        System.err.println("Args: "+args);
        System.err.println("Kind "+kind);
        System.err.println("Source location: "+sourceLocation);
        System.err.println("Target: "+target);
        System.err.println("Static part: "+staticPart);
        System.err.println("Long String: "+longString);
        System.err.println("Short String: "+shortString);
        System.err.println("String: "+string);
    }

    @AfterThrowing("allService()")
    public void logAfterThrowing(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        Object target = joinPoint.getTarget();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        String longString = joinPoint.toLongString();
        String shortString = joinPoint.toShortString();
        String string = joinPoint.toString();

        System.err.println("Signature: "+signature);
        System.err.println("Args: "+args);
        System.err.println("Kind "+kind);
        System.err.println("Source location: "+sourceLocation);
        System.err.println("Target: "+target);
        System.err.println("Static part: "+staticPart);
        System.err.println("Long String: "+longString);
        System.err.println("Short String: "+shortString);
        System.err.println("String: "+string);
    }
}
