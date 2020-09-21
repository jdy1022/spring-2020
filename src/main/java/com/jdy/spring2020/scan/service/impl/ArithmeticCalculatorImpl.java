package com.jdy.spring2020.scan.service.impl;

import com.jdy.spring2020.scan.service.intf.ArithmeticCalculator;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int n, int m) {
        //System.out.println("日志：The Method add begin ["+n+","+m+"]");
        return n+m;
       // System.out.println("result = " + result);
    }

    @Override
    public int dev(int n, int m) {
        System.out.println("日志：The Method dev begin ["+n+","+m+"]");
        int result = n-m;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int mul(int n, int m) {
        System.out.println("日志：The Method mul begin ["+n+","+m+"]");
        int result = n*m;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int n, int m) {
        //System.out.println("日志：The Method sub begin ["+n+","+m+"]");
        int result = n/m;
        //System.out.println("result = " + result);
        return result;
    }
}
