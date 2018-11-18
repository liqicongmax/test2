package singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lqc
 * @date 2018/9/25 18:46
 */
public class TestClass {
    public static void main(String[] args){
        HungerSingleton h1=HungerSingleton.getSingleton();
        HungerSingleton h2=HungerSingleton.getSingleton();
        HungerSingleton h3=HungerSingleton.getSingleton();
        System.out.println(h1==h2);
        System.out.println(h1==h3);
        System.out.println(h2==h3);
    }

}
