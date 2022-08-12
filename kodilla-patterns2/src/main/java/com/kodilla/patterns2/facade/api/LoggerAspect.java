package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.aop.calculator.Watcher;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logFacadeEvent(OrderDto order, long userId, Object object) {
        LOGGER.info("\nClass: \n" + object.getClass().getName() + "\ncalled processOrder with args: \nUserID: " + userId + "\nItems\n" + order);
    }
}
