package com.company;

/**
 * @author lqc
 * @date 2018/9/21 9:37
 */
public class Iiiiiii {
    public static void main(String[] args){
        //总的开始时间
        long start=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            int a=1;
            ++a;
        }
        long end=System.currentTimeMillis();
        System.out.println("++a的时间："+(end-start));
        start=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            int a=1;
            a++;
        }
        end=System.currentTimeMillis();
        System.out.println("a++的时间："+(end-start));
    }
}
