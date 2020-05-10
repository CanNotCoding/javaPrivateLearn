package datastruct.collections.map;

import Tools.DataTools;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * LinkedHashMap的基本使用
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        //LinkedHashMap是按照key的先后顺序存储的，使用链表结构

        Map map1 = new LinkedHashMap<Integer,Integer>();
        Map map2 = new HashMap<Integer,Integer>();
        //打印原始数据
        List<Integer> list = DataTools.getRandomIntegerList(1,30,10);
        System.out.println("原始数据");
        list.forEach(x->{
            System.out.print(x + " , ");
            map1.put(x,x);
            map2.put(x,x);
        });
        System.out.println("普通HashMap");
        map2.forEach((k,v)-> System.out.print(k + ":" + v + " , "));
        System.out.println("LinkedHashMap");
        map1.forEach((k,v)-> System.out.print(k + ":" + v + " , "));

        //对value排序

    }
}
