package datastruct.图.题;

import java.util.*;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class 课程表 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{
                {0, 3},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 2},
                {0, 1}
        };
        int[][] prerequisites1 = new int[][]{
                {1, 0}
        };

        System.out.println(canFinish(2, prerequisites1));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //return getResultByTopologySort(numCourses,prerequisites);
        return getResultByDfs(numCourses,prerequisites);
    }

    public static boolean getResultByTopologySort(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] G = new List[numCourses];
        int number = numCourses;
        getAgraph(numCourses, prerequisites, G, indegree);
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int vex = que.poll();
            number--;
            for (int i = 0; G[vex] != null && i < G[vex].size(); i++) {
                int adjvex = (int) G[vex].get(i);
                indegree[adjvex]--;
                if (indegree[adjvex] <= 0) {
                    que.add(adjvex);
                }
            }
        }
        return number == 0;
    }

    public static boolean getResultByDfs(int numCourses, int[][] prerequisites) {
        List[] G = new List[numCourses];
        getAgraph(numCourses, prerequisites, G, new int[numCourses]);
        int i = 0;
        for ( ;i <G.length;i++) {
            if (G[i] != null && isCircuit(G,i)) {
                break;
            }
        }
        return i != G.length;
    }


    public static boolean isCircuit(List[]G,int vex) {
        int[] hash = new int[G.length];
        return dfsAgraph(G,vex,hash);
    }

    public static boolean dfsAgraph(List[] G,int vex,int[] hash) {
        if (hash[vex] == 1)return true;

        hash[vex] = 1;
        boolean bool = false;
        for (int i = 0; G[vex] != null && i < G[vex].size();i++) {
            int adjvex = (int)G[vex].get(i);
            //if (hash[adjvex] == 0) {
                bool = bool || dfsAgraph(G,adjvex,hash);
            //}
            if (bool) {
                return true;
            }
        }
        hash[vex] = 0;
        return bool;
    }



    public static void getAgraph(int numCourses, int[][] prerequisites, List[] G, int[] indegree) {
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            if (G[start] == null) {
                G[start] = new ArrayList();
            }
            G[start].add(end);
            indegree[end]++;
        }
    }

}
