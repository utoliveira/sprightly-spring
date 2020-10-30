package com.sprightly.roomservice.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RoomLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(RoomLoggingAspect.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerPointCut(){}

    @Pointcut("execution(public * *(..))")
    public void endpoints(){}

    @Pointcut("endpoints() && restControllerPointCut()")
    public void restEndPoints(){}

    @Before("restEndPoints()")
    public void logBefore(JoinPoint joinPoint){
        logger.info("Entering method: " + joinPoint.getSignature().getName());
        logger.debug("Arguments: " + joinPoint.getArgs());
    }

    @AfterReturning
    public void logAfterReturn(JoinPoint joinPoint, Object result){
        logger.info("Exiting Method: " + joinPoint.getSignature().getName());
        if(logger.isDebugEnabled()){
            try{
                logger.debug("Response: "+  mapper.writeValueAsString(result));
            }catch (JsonProcessingException e){
                logger.error("Trying to unmarshalling the massage has thrown an  exception");
            }
        }
    }
}
