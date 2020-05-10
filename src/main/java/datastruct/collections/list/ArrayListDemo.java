package datastruct.collections.list;

import Tools.DataTools;
import Tools.MySort;

import java.util.List;

/**
 * ArrayList的基本用法
 */
public class ArrayListDemo {
    public static void main(String[] args) {

    }

    //测试基本使用方法
    public static void testBaseMethod() {
        List<Integer> list = DataTools.getRandomIntegerList(1, 30, 15);
        System.out.println("原始数据");
        list.forEach(x -> System.out.println(x));
        //排序
        list.sort(new MySort());
        System.out.println("排序后的数据");
        list.forEach(x -> System.out.println(x));
        //把list转换成数组
        Integer[] integers = list.toArray(new Integer[list.size()]);
        System.out.println("打印数组内容");
        for (int i : integers) {
            System.out.println(i);
        }
    }


}

