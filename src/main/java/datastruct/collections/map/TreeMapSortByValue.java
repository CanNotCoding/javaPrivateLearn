package datastruct.collections.map;

import Tools.DataTools;


import java.util.*;

/**
 * 根据value排序的TreeMap,通过List实现
 */
public class TreeMapSortByValue {
    public static void main(String[] args) {
        Map<Integer, Integer> map = DataTools.getRandomHashMap(1,30,15);
        System.out.println("原始数据");
        map.forEach((k,v)-> System.out.println(k+":"+v));
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println("使用List方法，按照value排序后的结果");
        list.forEach(x-> System.out.println(x.getKey() + ":" + x.getValue()));
        System.out.println("使用comparator方法，按照value排序后的结果");
        Map<Integer,Integer> treemap = new TreeMap<Integer,Integer>(new MyCmp(map));
        treemap.putAll(map);
        map.forEach((k,v)-> System.out.println(k+":"+v));
    }
}

class MyCmp implements Comparator<Integer> {

    Map<Integer,Integer> map;
    MyCmp(){    }//无参构造方法
    MyCmp(Map<Integer,Integer> map ){   this.map = map;}

    @Override
    public int compare(Integer o1,Integer o2) {
        return map.get(o2) - map.get(o1);
    }
}
