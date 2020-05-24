package newcoder;


import java.util.TreeSet;

public class 第三大的数 {
    public static void main(String[] args) {
        int[] n = new int[]{-2147483648,1,2};
        System.out.println(thirdMax2(n));
    }

    public static int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>((o1, o2)->(o2 - o1));
        for(int n :nums) {
            set.add(n);
        }
        if (set.size() < 3)return set.first();

        int i = 0;
        int res = 0;
        for (Integer n :set) {
            i++;
            res = n;
            if (i == 3)break;

        }

        return res;
    }

    public static int thirdMax2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max1 = Math.max(max1, nums[i]);
        }
        //   System.out.println(max1);
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max2 && nums[i] < max1) {
                max2 = nums[i];
            }
        }
        //   System.out.println(max2);
        if (max2 == Integer.MAX_VALUE) {
            return max1;
        }

        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
        }

        if (max3 == Integer.MIN_VALUE) {
            return max1;
        }
        //   System.out.println(max3);


        return max3;
    }
}
