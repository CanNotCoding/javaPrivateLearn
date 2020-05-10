package datastruct.collections.set;

import Tools.DataTools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * HashSet的基本使用方法
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = DataTools.getRandomIntegerList(1,10,15);//一定有重复的
        System.out.println("原始数据");
        list.forEach(x-> {
            System.out.print(x + " , ");
            set.add(x);
        });
        System.out.println("进入set以后的数据");
        set.forEach(x-> System.out.print(x+", "));
    }
}
