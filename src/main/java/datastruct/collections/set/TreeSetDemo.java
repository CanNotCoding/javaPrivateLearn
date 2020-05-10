package datastruct.collections.set;

import Tools.DataTools;

import java.util.*;

/**
 * TreeSet的基本用法
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        Set<Integer> sortset = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> list = DataTools.getRandomIntegerList(1,30,15);
        System.out.println("原始数据");
        list.forEach(x->{
            System.out.print(x + ", ");
            set.add(x);
            sortset.add(x);
        });
        System.out.println();
        System.out.println("进入SET以后的数据");
        set.forEach(x-> System.out.print(x + ", "));
        System.out.println();
        System.out.println("逆序的TreeSet");

        sortset.forEach(x-> System.out.print(x + ", "));
    }
}
