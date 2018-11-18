package bigdata;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lqc
 * @date 2018/9/18 9:34
 */
public class FindRepeat {
    public static void main(String[] args){
        String s2=new String("programing");
        String s="programing";
        String s1="program"+"ing";
        System.out.println(s2==s);

        System.out.println(s.equals(s1));
        String[] list={"a","b","c","a","d"};
        ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<>();
        for(String str:list){
            if(map.keySet().contains(str)){
                map.put(str,map.get(str)+1);
            }
        }
    }
}
