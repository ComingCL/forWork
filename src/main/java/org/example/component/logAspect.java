package org.example.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.annotation.SystemLog;
import org.example.pojo.LogEntity;
import org.example.service.LogService;
import org.example.utils.IpUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Aspect
@Slf4j
@Component
public class logAspect {
    @Resource
    private LogService logService;
    @Pointcut("@annotation(org.example.annotation.SystemLog)")
    public void operaLogPointCut(){// 在注解的位置切入代码
    }
    @Before(value = "operaLogPointCut()")
    public void before(){
        System.out.println("login start");
    }
    @Around(value = "operaLogPointCut()")
    @Transactional(rollbackFor = {Exception.class})
    public Object doAround(ProceedingJoinPoint joinPoint){
        log.info("代理执行, 代理方法{}", ((MethodSignature)joinPoint.getSignature()).getMethod().getName());
        SystemLog systemLog = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(SystemLog.class);
        String name = "";
        if(systemLog != null){
            name = ((MethodSignature) joinPoint.getSignature())
                    .getMethod().toGenericString();
        }
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        String host = IpUtil.getIpAddress(request);
        long id = Thread.currentThread().getId();
        LogEntity entity = new LogEntity();
        entity.setId(null).setIp(host).setOperation_time(new Date());

        logService.save(entity);
        try{
            joinPoint.proceed();
        }catch (Throwable throwable){
            log.error("代理发生异常, 异常信息{}", throwable.getMessage());
        }
        return null;
    }
    @After(value = "operaLogPointCut()")
    public void after(){
        System.out.println("login end");
    }
}
