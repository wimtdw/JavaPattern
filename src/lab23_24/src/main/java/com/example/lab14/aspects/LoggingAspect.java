/*
package com.example.lab14.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
        log.info("Parameters: {}", joinPoint.getArgs());
    }
    @Before("execution(* com.example.lab14.config.*.*(..))")
    public void logBefore_(JoinPoint joinPoint) {
        log.info("Starting method: " + joinPoint.getSignature().getName() + "Parameters: {}", joinPoint.getArgs());
    }
    @Pointcut("within(com.example.lab14.service..*)")
    public void allServiceMethods() {}

    @Before("execution(* com.example.lab14.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Starting method: " + joinPoint.getSignature().getName());
    }
    @Around("allServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long executionTime = System.currentTimeMillis() - start;
            log.info("Executed in " + executionTime + "mc " + joinPoint.getSignature().getName());
        }
    }

}
*/
