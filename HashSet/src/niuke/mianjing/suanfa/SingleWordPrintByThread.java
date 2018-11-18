package niuke.mianjing.suanfa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lqc
 * @date 2018/10/23 22:13
 */
public class SingleWordPrintByThread {
    public static ReentrantLock lock=new ReentrantLock();
    public static Condition condition=lock.newCondition();
    public static void printA()throws Exception{
        lock.lock();
        try{
            condition.signal();
            condition.await();
            System.out.println("A");
            condition.signal();
            condition.await();
        }finally {
            lock.unlock();
        }
    }
    public static void printB()throws Exception{
        lock.lock();
        try{
            condition.signal();
            condition.await();
            System.out.println("B");
            condition.signal();
            condition.await();
        }finally {
            lock.unlock();
        }
    }
    public static void printC()throws Exception{
        lock.lock();
        try{
            condition.signal();
            condition.await();
            System.out.println("C");
            condition.signal();
            condition.await();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        printA();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        printB();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        printC();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
