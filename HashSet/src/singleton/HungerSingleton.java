package singleton;

/**
 * @author lqc
 * @date 2018/9/25 18:43
 */
public class HungerSingleton {
    private HungerSingleton(){

    }
    private static HungerSingleton singleton;
    public static HungerSingleton getSingleton(){
        if(singleton==null){
            synchronized (HungerSingleton.class){
                if(singleton==null){
                    singleton=new HungerSingleton();
                }
            }
        }
        return singleton;
    }
}
