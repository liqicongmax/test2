package firstchar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lqc
 * @date 2018/9/18 15:56
 */
public class FisrtChar {
    public static String findFirstChar(String str){
        Map<String,Integer> map=new LinkedHashMap<>();
        char[] arr=str.toCharArray();
        for(char c:arr){
            String temp=String.valueOf(c);
            if(map.keySet().contains(temp)){
                map.put(temp,map.get(temp)+1);
            }else {
                map.put(temp,1);
            }
        }
        for(String s:map.keySet()){
            if(map.get(s)==1){
                return s;
            }
        }
        return null;
    }
    public static void main(String[] args){
        String s="ascdasdbaaae";
        System.out.println(findFirstChar(s));
    }
}
