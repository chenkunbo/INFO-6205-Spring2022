package HW03_Maximum_Path_Quality_of_a_Graph_2065;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], (k) -> new LinkedList<>()).add(new int[]{edge[1], edge[2]});
            adjList.computeIfAbsent(edge[1], (k) -> new LinkedList<>()).add(new int[]{edge[0], edge[2]});
        }

        return Math.max(values[0], dfs(values, adjList, maxTime, 0, new int[values.length]));
    }

    public int dfs(int[] values, HashMap<Integer, List<int[]>> adjList, int maxTime, int curr, int[] visited) {
        if (maxTime < 0) return -1;
        int ans = -1;

        visited[curr]++;
        if (adjList.containsKey(curr)) {
            for (int[] edge : adjList.get(curr)) {

                int pathQuality = dfs(values, adjList, maxTime - edge[1], edge[0], visited);

                if (pathQuality != -1) {
                    int valueAddedHere = visited[curr] > 1 ? 0 : values[curr];
                    ans = Math.max(ans, valueAddedHere + pathQuality);
                }
            }
        }

        visited[curr]--;

        if (curr == 0 && visited[curr] > 0) {
            return Math.max(0, ans);
        }

        return ans;
    }
}
