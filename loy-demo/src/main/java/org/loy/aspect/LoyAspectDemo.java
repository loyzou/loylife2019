/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @Before("loyAspect()")
    public void loyBefore(JoinPoint joinPoint) {
        log.info("进入loy before切面{}", joinPoint.getArgs());
    }

    @Around("loyAspect()")
    public void loyAround(JoinPoint joinPoint) {
        log.info("进入loy around{}", joinPoint.getArgs());
    }
}
