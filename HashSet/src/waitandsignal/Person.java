package waitandsignal;

/**
 * @author lqc
 * @date 2018/9/18 15:39
 */
public class Person {
    private int foodNum=0;
    private static final int MAX_FOOD=5;
    public void produce()throws InterruptedException{
        synchronized (this){
            while(foodNum==MAX_FOOD){
                System.out.println("别生产了，已经满了");
                wait();
            }
            foodNum++;
            System.out.println("我现在的物品数量为:"+foodNum);
            notifyAll();
        }
    }
    public void consume()throws InterruptedException{
        synchronized (this){
            while(foodNum==0){
                System.out.println("我都没东西消费了");
                wait();
            }
            foodNum--;
            System.out.println("消费一次后物品还剩："+foodNum);
            notifyAll();
        }
    }

}
