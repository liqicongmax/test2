package niuke.mianjing.suanfa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用两个线程
 * 两个任意数组，如A{1,2,3}，B{A,B,C,D}，循环输出格式如{1A2B3C1D2A3B1C}
 * @author lqc
 * @date 2018/9/23 8:00
 */
public class ArrayPrintByThread {
    private static ReentrantLock lock=new ReentrantLock();
    private static Condition condition=lock.newCondition();
    public static volatile String sign="a";
    private static int a=0;
    private static int b=0;
    public static void main(String[] args){
        int[] arr=new int[]{1,2,3};
        String[] brr=new String[]{"A","B","C","D"};;
        Thread t1=new Thread(new Runnable()  {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    try {
                        printarr(arr);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable()  {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        printbrr(brr);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
    public static void printarr(int[] arr)throws Exception{
        lock.lock();
        try {
            condition.signal();
            condition.await();
            sign="a";
            System.out.println(arr[a]);
            if(a==(arr.length-1)){
                a=0;
            }else {
                ++a;
            }
            condition.signal();
            condition.await();
        }finally {
            lock.unlock();
        }
    }
    public static void printbrr(String[] brr) throws Exception{
        lock.lock();
        try {
            condition.signal();
            condition.await();
            System.out.println(brr[b]);
            if(b==(brr.length-1)){
                b=0;
            }else {
                ++b;
            }
            condition.signal();
            condition.await();
        }finally {
            lock.unlock();
        }
    }
}
