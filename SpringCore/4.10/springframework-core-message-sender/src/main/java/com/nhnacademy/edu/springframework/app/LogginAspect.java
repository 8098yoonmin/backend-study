package com.nhnacademy.edu.springframework.app;

import com.nhnacademy.edu.springframework.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
public class LogginAspect {

    @Around("@annotation(com.nhnacademy.edu.springframework.annotation.ElapsedTimeLog) && args(user,..)" )
    public Object loggingExecutionTime(ProceedingJoinPoint pjp, User user) {
        //throwable을 클래스에 선언하면 stopwatch가 실행을 안함
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object rt =null;

        try {
            System.out.println("annotation을 실행합니다.");
             rt = pjp.proceed();
        } catch(Throwable e) {
            e.printStackTrace();

        } finally {
            stopWatch.stop();
            long totalTimeMillis = stopWatch.getTotalTimeMillis();
            MethodSignature signature = (MethodSignature) pjp.getSignature();

//            stopWatch.prettyPrint();
            String methodName = signature.getMethod().getName();
            System.out.println(user.toString());
            System.out.println("실행메서드: " + methodName + " "+"실행시간: " + totalTimeMillis + "ms");
        }


        return rt;
    }


}
