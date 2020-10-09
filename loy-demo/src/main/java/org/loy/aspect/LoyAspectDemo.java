/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Loy切面demo
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/9/4
 */
@Aspect
@Component
@Slf4j
public class LoyAspectDemo {

    @Pointcut("execution( * org.loy.aspect.LoyAspectController.*(..)))")
    public void loyAspect() {}

    @Around("loyAspect()")
    public Object loyBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("进入loy before切面{}", joinPoint.getArgs());
        HttpServletRequest request = null;

        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            request = ((ServletRequestAttributes)requestAttributes).getRequest();
        } catch (Exception var15) {
            return joinPoint.proceed();
        }

        Object proceed = null;

        String queryString = request.getQueryString();
        System.out.println("请求参数：" + queryString);
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;
    }

   /* @Around("loyAspect()")
    public void loyAround(JoinPoint joinPoint) {
        log.info("进入loy around{}", joinPoint.getArgs());
    }*/
}
