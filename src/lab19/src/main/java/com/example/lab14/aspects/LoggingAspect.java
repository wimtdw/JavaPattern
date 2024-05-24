package com.example.lab14.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
    @Before("allServiceMethods()")
    public void logParameters(JoinPoint joinPoint) {
        log.info("Параметры: {}", joinPoint.getArgs());
    }

    @Pointcut("within(com.example.lab14.service..*)")
    public void allServiceMethods() {}

    @Before("execution(* com.example.lab14.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Начало выполнения метода: " + joinPoint.getSignature().getName());
    }


}
