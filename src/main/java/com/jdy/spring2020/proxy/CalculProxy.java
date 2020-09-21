package com.jdy.spring2020.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 *
 */

public class CalculProxy {
    //第一步：目标对象
    private Object target;

    public CalculProxy(Object target) {
        this.target = target;
    }

    //第二步：获取代理对象

    public Object getObject(Object obj){
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
           //第三步：代理对象要做什么
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                System.out.println("日志：The Method "+name+" begin "+ Arrays.toString(args));
                Object result = method.invoke(target, args);//相当于执行目标类中的方法（add sub 方法）
                System.out.println(name+":result = " + result);
                return result;
            }
        });
    }
}
