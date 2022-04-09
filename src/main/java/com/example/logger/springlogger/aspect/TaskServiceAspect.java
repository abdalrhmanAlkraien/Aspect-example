package com.example.logger.springlogger.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Log4j2
@Component
public class TaskServiceAspect {

    private final String apiPointcut="execution(* com.example.logger.springlogger.controller.*.*(..))";
    private final String exceptionPointcut ="execution(* com.example.logger.springlogger.*.*.*(..))";

    @Pointcut(apiPointcut)
    public void APIPointCut(){}


    @Before("APIPointCut()")
    public void logEnteringAPI(JoinPoint joinPoint){
        log.info("The API method will executing {}",joinPoint.getSignature().getName());
        if(joinPoint.getArgs().length>0){
            Object[] args=joinPoint.getArgs();
            log.info("the Api argument is ".concat(args[0].toString()));
        }
    }

    @After("APIPointCut()")
    public void logExitingAPI(JoinPoint joinPoint){
        log.info("The API method finished execute {}",joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = exceptionPointcut ,throwing = "exception")
    public void logsExceptionsFromAnyLocations(JoinPoint joinPoint,Throwable exception) throws Throwable {
        log.error("We have error in this method {}",joinPoint.getSignature().getName());
        log.error("The exception message: ".concat(exception.getMessage()));
    }

    @AfterReturning(value = "@annotation(com.example.logger.springlogger.aspect.TaskServiceAspect.Loggable)",returning = "returnValue")
    public void logEachReturningValue(JoinPoint joinPoint,Object returnValue){
        log.info("the value from method: ".concat(joinPoint.getSignature().getName()).concat(returnValue.toString()));
    }

    public @interface Loggable {
    }
}
