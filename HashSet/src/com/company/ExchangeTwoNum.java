package com.company;

/**
 * @author lqc
 * @date 2018/9/13 9:20
 */
public class ExchangeTwoNum {
    private static int a=1;
    private static int b=2;
    public static void main(String[] args){
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("a:"+a+","+"b:"+b);
    }
}
