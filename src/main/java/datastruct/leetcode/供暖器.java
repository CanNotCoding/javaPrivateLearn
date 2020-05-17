package datastruct.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class 供暖器 {
    public static void main(String[] args) {
        int[] house = new int[]{1, 5};
        int[] heaters = new int[]{10};
        System.out.println(findRadius(house, heaters));
    }

    public static int findRadius(int[] house, int[] heaters) {
        if (house.length == 1) {
            return 0;
        }

        Deque<Integer> deque = new LinkedList<>();

        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int m : house) {
            max = Math.max(max, m);
            min = Math.min(min, m);
        }

        for (int m : heaters) {
            max = Math.max(max, m);
            min = Math.min(min, m);
        }

        int n = 0;
        int[] houses = new int[max - min + 1];


        for (int i = 0; i < heaters.length; i++) {
            deque.addLast(heaters[i] - min);
            n++;
            houses[heaters[i] - min] = -1;
        }
        int s = 0;
        
        for (int i = 0; i < 10 && s < houses.length; i++) {
            n++;
            for (int j = deque.size(); j > 0; j--) {
                int post = deque.pollFirst();
                //    System.out.println("post = " + post);
                if (post >= 0 && post < houses.length && houses[post] != -1) {
                    houses[post] = -1;
                    s++;
                }
                //      System.out.println("s = " + s);
                if (post - 1 >= 0 && houses[post - 1] != -1) {
                    houses[post - 1] = -1;
                    s++;
                    deque.addLast(post - 1);
                }
                //     System.out.println("s = " + s);
                if (post + 1 < houses.length && houses[post + 1] != -1) {
                    houses[post + 1] = -1;
                    s++;
                    deque.addLast(post + 1);
                }
                //   System.out.println("s = " + s);
            }
            // System.out.println("------------" + n + "--------------");
        }
        return n;
    }
}
