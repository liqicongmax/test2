package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 熟悉下队列的实现
 * @author lqc
 * @date 2018/9/18 19:39
 */
public class QueneDemo {
    public static void main(String[] args) {
        Queue<String> quene = new LinkedList<>();
        quene.offer("a");
        quene.offer("b");
        quene.offer("c");
        String temp=null;
        while((temp=quene.poll())!=null){
            System.out.println(temp);
        }
    }
}
