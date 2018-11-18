package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * @author lqc
 * @date 2018/9/13 22:57
 */
public class Reflect {
    public static void main(String[] args){
        try{
            Class heroclass=Class.forName("reflect.Hero");
            String name=heroclass.getName();
            System.out.println(name);
            Constructor c=heroclass.getConstructor();
            Hero hero=(Hero)c.newInstance();
            System.out.println(hero.toString());
            Method method=heroclass.getMethod("setName", String.class);
            Object hero1=method.invoke(hero,"xiaoming");
            System.out.println(hero1.toString());
            Field heroname=heroclass.getDeclaredField("name");
            System.out.println(heroname.get(hero));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
