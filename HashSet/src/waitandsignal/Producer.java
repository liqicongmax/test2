package waitandsignal;

import waitandsignal.Person;

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
        try {
            for (int i = 0; i < 10; i++) {
                person.produce();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
