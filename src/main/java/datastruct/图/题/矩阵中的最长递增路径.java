package datastruct.图.题;

/**
 * 329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */
public class 矩阵中的最长递增路径 {
    static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };
        int[][] matrix1 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {19, 18, 17, 16, 15, 14, 13, 12, 11, 10}, {20, 21, 22, 23, 24, 25, 26, 27, 28, 29}, {39, 38, 37, 36, 35, 34, 33, 32, 31, 30}, {40, 41, 42, 43, 44, 45, 46, 47, 48, 49}, {59, 58, 57, 56, 55, 54, 53, 52, 51, 50}, {60, 61, 62, 63, 64, 65, 66, 67, 68, 69}, {79, 78, 77, 76, 75, 74, 73, 72, 71, 70}, {80, 81, 82, 83, 84, 85, 86, 87, 88, 89}, {99, 98, 97, 96, 95, 94, 93, 92, 91, 90}, {100, 101, 102, 103, 104, 105, 106, 107, 108, 109}, {119, 118, 117, 116, 115, 114, 113, 112, 111, 110}, {120, 121, 122, 123, 124, 125, 126, 127, 128, 129}, {139, 138, 137, 136, 135, 134, 133, 132, 131, 130}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(longestIncreasingPath(matrix));

    }

    public static int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, getLongestPathByDfs(i, j, -1, dp, matrix.length, matrix[0].length, matrix));
            }
            System.out.println(max);
        }
        return max;
    }

    public static int getLongestPathByDfs(int x, int y, int path, int[][] visited, int row, int low, int[][] matrix) {
        if (x < 0 || x >= row || y < 0 || y >= low || matrix[x][y] <= path) {
            return 0;
        }
        if (visited[x][y] != 0) {
            return visited[x][y];
        }
        int sum = 0;
        for (int i = 0; i < direction.length; i++) {
            sum = Math.max(sum, getLongestPathByDfs(x + direction[i][0], y + direction[i][1], matrix[x][y], visited, row, low, matrix));
        }
        visited[x][y] = sum + 1;
        return visited[x][y];
    }

}
