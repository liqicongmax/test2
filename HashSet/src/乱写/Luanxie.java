package 乱写;

import java.io.File;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author lqc
 * @date 2018/10/8 16:18
 */
public class Luanxie {
    public static final int max_vale=100;
    public static void main(String[] args){
        TreeSet<String> set=new TreeSet<>();
        set.add("c");
        set.add("asdsad");
        set.add("a");
        set.add("b");
        for(String s:set){
            System.out.println(s+" ");
        }


    }
}
