package threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author lqc
 * @date 2018/9/20 11:56
 */
public class Profiles {
    private static final ThreadLocal<Long> TIME_THREAD_LOCAL=new ThreadLocal<>();
    public static final void begin(){
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis()-TIME_THREAD_LOCAL.get();
    }
    public static void main(String[] args)throws Exception{
        Profiles.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("cost:"+Profiles.end()+"mills");

    }

}
