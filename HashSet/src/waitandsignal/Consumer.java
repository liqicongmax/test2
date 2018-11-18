package waitandsignal;

import waitandsignal.Person;

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
        try{
            for(int i=0;i<10;i++){
                person.consume();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
