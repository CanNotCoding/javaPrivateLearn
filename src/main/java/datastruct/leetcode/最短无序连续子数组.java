package datastruct.leetcode;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class 最短无序连续子数组 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 6, 4, 8, 10, 9, 15};
        int[] b = new int[]{1, 2, 3, 4};
        int[] c = new int[]{1, 3, 2, 4, 5};
        System.out.println(findUnsortedSubarrayByDp(c));
    }

    public static int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length == 1) {
            return 0;
        }
        int[] array = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(array);
        int result = nums.length;
        for (int i = 0; i < nums.length && nums[i] == array[i]; i++) {
            result--;
            System.out.println(result);
        }
        for (int j = nums.length - 1; j >= 0 && nums[j] == array[j]; j--) {
            result--;
            System.out.println(result);
        }
        return result <= 0 ? 0 : result;
    }

    public static int findUnsortedSubarrayByDp(int[] nums) {
        int max = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i-1] > nums[i] || nums[i] < max) {
                result++;
                System.out.println(result);

            }
            max = Math.max(max,nums[i]);
        }
        return result;
    }
}
