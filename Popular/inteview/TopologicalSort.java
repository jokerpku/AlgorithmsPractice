package inteview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jokeria on 2017/1/10.
 */
public class TopologicalSort {
    boolean impossible = false; // I like this way of storing the possibility of impossiblity :P

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(i, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(adj, i, stack, visited, new boolean[numCourses])) return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private boolean topologicalSort(List<List<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop) {
        if (visited[v]) return true;
        if (isLoop[v]) return false;
        isLoop[v] = true;
        for (Integer u : adj.get(v)) {
            if (!topologicalSort(adj, u, stack, visited, isLoop)) return false;
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] path = new int[numCourses];
        for (int i = 0; i < numCourses; i++) // building the base.
            graph.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) { // Building graph.
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) { // Actual DFS calls.
            dfs(stack, graph, path, i);
            if (impossible)
                return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) // Build result.
            res[i] = stack.pop();
        return res;
    }


    private void dfs(Stack<Integer> stack, List<List<Integer>> graph, int[] path, int course) {
        if (path[course] == 2 || impossible) {
            return;
        }
        if (path[course] == 1) { // cycle exists.
            impossible = true;
            return;
        }
        path[course] = 1; // '1' means being explored.
        for (int nextCourse : graph.get(course)) {
            dfs(stack, graph, path, nextCourse);
            if (impossible)
                return;
        }
        stack.push(course); // done exploring.
        path[course] = 2; // '2' means Exploration complete.
    }
}


