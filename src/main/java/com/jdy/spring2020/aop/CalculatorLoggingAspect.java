package com.jdy.spring2020.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Aspect：表示是一个切面
 */
/*@Component*/
//@Aspect
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@Order(0)
public class CalculatorLoggingAspect {

    /**
     * 前置通知：
     * @Before("execution( com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl.add(int,int))")
     * 在ArithmeticCalculatorImpl.add方法前之前前置通知
     *
     */
    @Before(value = "execution(* com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl.add(int,int))")
    public void before(){
        System.out.println("AO....前置通知");
    }

    /**
     *
     * @param joinPoint：连接点对象
     */
    @AfterReturning(value = "execution(* com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl.add(int,int))",returning ="result" )
    public void after(JoinPoint joinPoint){
        //方法的名字
        String name = joinPoint.getSignature().getName();
        System.out.println("后置通知方法名字：" + name);
    }

    /**
     * 返回通知：目标方法执行结束后，得到方法的返回值
     * 获取方法的返回值：通过returnning来指定一个名字，必须要与方法的一个参数名成一致。
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(* com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl.add(int,int))",returning ="result" )
    public void afterRunning(JoinPoint joinPoint,Object result){
        //方法的名字
        String name = joinPoint.getSignature().getName();
        System.out.println("返回通知方法名字：" + name);
        System.out.println("返回通知方法返回值：" + result);
    }


   /**
     * 异常通知：目标方法执行结束后，目标方法抛出异常
     * 获取方法的异常：通过Throwing来指定一个名字，必须要与方法的一个参数名一致
     * 可以通过形参中异常的类型来设置抛出指定异常才会执行异常通知
     * @param joinPoint
     */
    @AfterThrowing(value = "execution(public int com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl.sub(int,int))",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        //方法的名字
        String name = joinPoint.getSignature().getName();
        System.out.println("异常通知方法名字：" + name);
        System.out.println("异常通知方法返回异常：" + ex);
    }

    //可以通过形参中异常的类型来设置抛出指定异常才会执行异常通知
    @AfterThrowing(value = "execution(public int com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl.*(int,int))",throwing = "ex")
    public void afterThrowing1(JoinPoint joinPoint,NullPointerException ex){
        //方法的名字
        String name = joinPoint.getSignature().getName();
        System.out.println("异常通知方法名字" + name);
        System.out.println("异常通知方法返回异常" + ex);
    }


    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around(value = "execution(public int com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl.add(int,int))")
    public Object around(ProceedingJoinPoint joinPoint) {
        //方法的名字
        Object obj = null;
        //前置
        try {
            //执行目标方法，相当于动态代理的invoke方法
            System.out.println("环绕通知---->方法名字" + joinPoint.getSignature().getName());
            obj = joinPoint.proceed();
            System.out.println("环绕通知---->方法proceed" + obj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            //后置
        }
        return obj;
    }
}
