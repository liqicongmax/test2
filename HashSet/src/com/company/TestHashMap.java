package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lqc
 * @date 2018/9/18 20:28
 */
public class TestHashMap {
    public static void main(String[] args){
        Map<String,String> map=new HashMap<>();
        map.put("admin", "admin");
        map.put("ytx", "ytx");
        map.put("admin", "admin222");
        for (String s : map.keySet()) {
            System.out.println(s+"=="+map.get(s));
        }
    }
}
