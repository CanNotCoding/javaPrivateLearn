package newcoder.剑指offer;


/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {
        int[][] array = new int[3][4];
        System.out.println(array.length);
        System.out.println(array[1].length);
    }


    public static boolean FindByViolent(int target, int[][] array) {
        for(int[] row : array) {
            for(int num : row) {
                if( num == target ) return true;
            }
        }
        return false;
    }

    //智力查找
    public static boolean findByWisdom(int target, int[][] array) {
        int rows = array.length, cols = array[0].length;
        int i = rows - 1, j = 0;
        while(i >= 0 && j < cols) {
            if( array[i][j] == target )return true;
            if(array[i][j] < target)
                j++;
            else
                i--;
        }
        return false;
    }

}
