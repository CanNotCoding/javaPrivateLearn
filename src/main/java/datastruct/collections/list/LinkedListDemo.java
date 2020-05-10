package datastruct.collections.list;

import Tools.DataTools;
import Tools.MySort;

import java.util.List;

/**
 * LinkedList基本用法
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> list = DataTools.getRandomIntegerLinkedList(1,30,15);
        list.forEach(x-> System.out.print(x + ", "));

        list.sort(new MySort());
        System.out.println("排序后的链表");
        list.forEach(x-> System.out.print(x + ", "));
    }
}
