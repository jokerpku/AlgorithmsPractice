package inteview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 拓扑排序
 * 输入点的个数n、若干大小为2的数组表示的边，如[1,0]表示从0到1的边
 * 找出一条路径，若有若干条路径则随便输出一种路径
 * 若有环，则输出空数组
 * 点和边的个数均不为空
 * Created by Jokeria on 2017/1/10.
 */
public class DFSTopologicalSort {
    public int[] topologicalSort(int n, int[][] edges) {
        if(n <= 0 || edges == null) {
            return new int[0];
        }


        // 用二维数组记录每个定点的入线的顶点
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        // 初始化graph
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 用一个数组记录定点当前的状态，包括0：未遍历、1：正在遍历、2：已完成
        int[] states = new int[n];
        // 用栈记录走过的路径
        Stack<Integer> path = new Stack<Integer>();
        // 遍历每一个顶点，对每一个顶点进行深度优先遍历
        for(int i = 0; i < n; i++) {
            boolean noCycle = dfs(states, graph, path, i);
            if(!noCycle) {
                return new int[0];
            }
        }

        int[] res = new int[n];
        for(int i = n-1; i >= 0; i--) {
            res[i] = path.pop();
        }

        return res;
    }

    boolean dfs(int[] states, List<List<Integer>> graph, Stack<Integer> path, int cur) {
        if(states[cur] == 2){
            // 已经遍历过
            return true;
        }
        if(states[cur] == 1) {
            // 正在遍历，说明有环
            return false;
        }

        states[cur] = 1;
        for(int i : graph.get(cur)) {
            boolean noCycle = dfs(states, graph, path, i);
            if(!noCycle) {
                return false;
            }
        }

        states[cur] = 2;
        path.push(cur);

        return true;
    }

    public static void main(String[] args) {
        DFSTopologicalSort instance = new DFSTopologicalSort();
        int[][] edges = {{0,1},{2,1},{1,3}};
        int[] res = instance.topologicalSort(4, edges);

        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
