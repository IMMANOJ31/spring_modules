package org.xworkz.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public LoggingAspect(){
        System.err.println("Invoking logging aspect");
    }
}
