package Tools;

import java.util.*;

public class DataTools {
    //返回一个List,start为起点，end为终点，nums为成成数据的数量
    public static List getRandomIntegerList(int start, int end, int nums) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < nums; i++) {
            list.add(random.nextInt(end - start) + start);
        }
        return list;
    }

    //返回一个Hashmap
    public static Map getRandomHashMap(int start,int end,int nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Random random = new Random();
        for(int i = 0;i < nums;i++) {
            map.put(random.nextInt(end - start) + start,random.nextInt(end - start) + start);
        }
        return map;
    }

    public static List getRandomIntegerLinkedList(int start, int end, int nums) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < nums; i++) {
            list.add(random.nextInt(end - start) + start);
        }
        return list;
    }

    public static Integer getRandomInteger() {
        return new Random().nextInt(10);
    }
    public static Integer getRandomInteger(int n) {
        return new Random().nextInt(n);
    }

    public static Integer getRandomInteger(int start, int end) {
        return new Random().nextInt(end - start) + start;
    }
}
