package com.example.toutiao.aop;

import com.example.toutiao.base.ToutiaoErrorCode;
import com.example.toutiao.base.ToutiaoResponseUtil;
import com.example.toutiao.exception.ToutiaoException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Configuration
@Slf4j
@Aspect
@Component
@Order(Integer.MIN_VALUE)
public class ControllerExceptionHandlerAspect {

    @Pointcut("(execution (* com.example.toutiao.controller.*.*(..))) " )
    public void afterThrowing(){}

    @Around("afterThrowing()")
    public Object handleExc(ProceedingJoinPoint jp){
        Object result;
        try {
            result = jp.proceed();
        } catch (Throwable throwable) {
            log.warn("handleExc,throwable=",throwable);
            if (throwable instanceof ToutiaoException) {
                return ToutiaoResponseUtil.error(((ToutiaoException) throwable));
            }
            return ToutiaoResponseUtil.error(ToutiaoErrorCode.SYSTEM_EXCEPTION);
        }
        return result;
    }
}