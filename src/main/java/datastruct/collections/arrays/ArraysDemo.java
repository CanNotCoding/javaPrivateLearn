package datastruct.collections.arrays;

import Tools.DataTools;
import entity.Person;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Arrays工具类的基本用法
 */
public class ArraysDemo {
    public static void main(String[] args) {

        testArraysSearch();
    }


    //Arrays提供的基本功能
    public static void testArraysTools() {
        Integer[] array = new Integer[]{1, 6, 3, 7, 5};
        List<Integer> list = DataTools.getRandomIntegerList(1, 30, 20);
        System.out.println(list);
        //把所有元素用0填充
        Arrays.fill(array,0);
        //排序
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(array));
        System.out.println("-----------------------");
        //数组转list
        List<Integer> l = Arrays.asList(array);
    }

    //测试Arrays的二分查找功能
    public static void testArraysSearch() {

        List<Integer> list = DataTools.getRandomIntegerList(1, 15, 20);
        System.out.println(list);
        //排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);
        //另外的一种写法，java8
        list.sort((o1,o2) -> o1 - o2);

        System.out.println(list);
        Integer[] integers = list.toArray(new Integer[list.size()]);
        //返回找到的元素的位置，如果返回的是负数则元素不存在
        int bool = Arrays.binarySearch(integers, 6);
        System.out.println(bool);

    }
    //使用Bean对象排序
    public static void testArraysSortByBean() {

        List<Person> list = new ArrayList<Person>();
        for(int i = 0; i < 10; i++) {//放10个人进去，年龄用随机数
            list.add(new Person("p" + String.valueOf(i),DataTools.getRandomInteger(10)));
        }
        //把list变成数组
        Person[] p = list.toArray(new Person[list.size()]);
        //调用Arrays的排序方法
        Arrays.sort(p);
        for (Person person:p) {
            System.out.println("name = " + person.getName() + ", age =  " + person.getAge());
        }
    }

    public static void testArraysSortByJava8() {
        List<Person> list = new ArrayList<Person>();
        for(int i = 0; i < 10; i++) {//放10个人进去，年龄用随机数
            list.add(new Person("p" + String.valueOf(i),DataTools.getRandomInteger(10)));
        }
    }


}
