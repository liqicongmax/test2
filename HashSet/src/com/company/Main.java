package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Hero> set=new HashSet<>();
        Hero hero1=new Hero("a",1);
        Hero hero2=new Hero("a",1);
        Hero hero3=new Hero("c",3);
        set.add(hero1);
        set.add(hero2);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }


    }
}
