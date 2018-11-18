package produceandconsumer;

/**
 * @author lqc
 * @date 2018/9/18 15:31
 */
public class Consumer implements Runnable {
    private Person person;
    Consumer(Person person){
        this.person=person;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            person.consume();
        }
    }
}
