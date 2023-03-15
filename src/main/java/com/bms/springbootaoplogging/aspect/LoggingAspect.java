package com.bms.springbootaoplogging.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.bms.springbootaoplogging.service.CustomerService.createCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("CustomerService.createCustomer() method before running.");
        logger.info("Enter:{}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After("execution(* com.bms.springbootaoplogging.service.CustomerService.createCustomer(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("CustomerService.createCustomer() method after running.");
        logger.info("Enter:{}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.bms.springbootaoplogging.service.CustomerService.getCustomerById(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("CustomerService.getCustomerById() method after running.");
        logger.info("Enter:{}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), joinPoint.getArgs());
        logger.info("Method returned value is : {}", result);
    }

    @AfterReturning(pointcut = "execution(* com.bms.springbootaoplogging.service.CustomerService.getAllCustomers(..))",
            returning = "result")
    public void logAfterReturningByGetAll(JoinPoint joinPoint, Object result) {
        logger.info("CustomerService.getAllCustomers() method after running.");
        logger.info("Enter:{}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), joinPoint.getArgs());
        logger.info("Method returned value is : {}", result);
    }

    @AfterThrowing(pointcut = "execution(* com.bms.springbootaoplogging.service.CustomerService.*(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.info("CustomerService method : {} after running.", joinPoint.getSignature().getName());
        logger.info("Enter:{}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), joinPoint.getArgs());
        logger.info("An exception has been thrown in {}()", joinPoint.getSignature().getName());
        logger.info("The exception is : ", error);
    }
}
