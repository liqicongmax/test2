package produceandconsumer;

/**
 * @author lqc
 * @date 2018/9/18 15:32
 */
public class AwaitAndSignal {
    public static void main(String[] args){
        Person person=new Person();
        new Thread(new Consumer(person),"消费者1").start();
        new Thread(new Consumer(person),"消费者2").start();
        new Thread(new Consumer(person),"消费者3").start();
        new Thread(new Producer(person),"生产者1").start();
        new Thread(new Producer(person),"生产者2").start();
        new Thread(new Producer(person),"生产者3").start();
    }
}
