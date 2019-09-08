package com.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static  void main(String[] ages){

        System.out.println("main()...........");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            list.add(i);
        }
        System.out.println(list);
        Map map = new HashMap();
        map.put("a", "1");
        map.put("b", "2");
        System.out.println(map);
    }
}
