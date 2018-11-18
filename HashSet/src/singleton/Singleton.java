package singleton;

/**
 * @author lqc
 * @date 2018/9/12 14:44
 */
public class Singleton {
    private static Singleton singleton=null;
    private Singleton(){
    }
    private Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
