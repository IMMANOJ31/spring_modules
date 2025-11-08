package org.xworkz.springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {

    public AopConfig(){
        System.err.println("AOP invoked");
    }
}
