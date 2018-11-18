package produceandconsumer;

/**
 * @author lqc
 * @date 2018/9/18 15:27
 */
public class Producer implements Runnable {
    private Person person;
    Producer(Person person){
        this.person=person;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            person.produce();
        }
    }
}
