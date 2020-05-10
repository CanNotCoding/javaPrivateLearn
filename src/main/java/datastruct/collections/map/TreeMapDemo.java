package datastruct.collections.map;

import Tools.DataTools;

import java.util.*;

import static Tools.DataTools.getRandomIntegerList;

public class TreeMapDemo {
    public static void main(String[] args) {
        //TreeMap会对key进行排序
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        List<Integer> list = getRandomIntegerList(1, 30, 10);
        System.out.println("原始数据");
        for (int i : list) {
            map.put(i, i);
            System.out.println(i);
        }
        System.out.println("TreeMap处理后的数据");
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            System.out.println("key:" + kv.getKey() + " , value:" + kv.getValue());
        }
        System.out.println("使用forEach的数据");
        map.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));
        System.out.println("更高级的用法");
        map.forEach((k, v) -> {
            if (k == v) {
                System.out.println("k == v");
            }
        });

//        控制顺序的TreeMap,这个方法可以
//        Map sortmap = new TreeMap(new MyCmp());
        Map sortmap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        list.forEach(x -> {
            sortmap.put(x, x);
            System.out.println(x);
        });

        sortmap.forEach((k, v) -> System.out.println(k + ":" + v));


        map.clear();


        //对value排序
        //Map m = new TreeMap<Integer, Integer>(new SortByValue(map));
        List<Integer> l = DataTools.getRandomIntegerList(1,40,20);

        Random random = new Random();
        System.out.println("--------------------------------------");
        l.forEach(x->{
            int n = random.nextInt(39);
            map.put(x,n);
            System.out.print(x+":"+n + ",");
        });
        System.out.println();
        System.out.println("---------------------------------------");

        map.forEach((k,v)-> System.out.print(k+":"+v +","));
        System.out.println();
        System.out.println("---------------------------------------");
        //m.forEach((k,v)-> System.out.print(k+":"+v +","));


    }





}

//class MyCmp implements Comparator<Object> {
//    // 实现倒序
//    @Override
//    public int compare(Object o1, Object o2) {
//        return -(Integer) o1 + (Integer) o2;
//    }
//}

//class SortByValue implements Comparator<Integer> {
//
//    Map<Integer,Integer> map;
//    SortByValue(){  }//无参构造方法
//    //传入map结构
//    SortByValue(Map<Integer,Integer> map) {    this.map = map;   }
//
//    @Override
//    public int compare(Integer o1,Integer o2) {
//        return - map.get(o1) + map.get(o2);
//    }
//}