package produceandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lqc
 * @date 2018/9/18 15:17
 */
public class Person {
    private int foodNum=0;
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private static final int MAX_NUM=5;
    public void produce(){
        lock.lock();
        try{
            while (foodNum == MAX_NUM) {
                System.out.println("别生产了，箱子满了,数量为："+foodNum);
                condition.await();
            }
            foodNum++;
            System.out.println("成功生产物品，当前数量："+foodNum);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void consume(){
        lock.lock();
        try{
            while(foodNum==0){
                System.out.println("快生产啊，我都没得消费了,当前物品："+foodNum+"件");
                condition.await();
            }
            foodNum--;
            System.out.println("成功吃掉一件，当前数量："+foodNum);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
