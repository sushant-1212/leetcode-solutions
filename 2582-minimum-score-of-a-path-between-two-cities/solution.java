import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
   
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] road : roads) {
            int a = road[0], b = road[1], dist = road[2];
            adj[a].add(new int[]{b, dist});
            adj[b].add(new int[]{a, dist});
        }

        boolean[] visited = new boolean[n + 1];
        int ans = Integer.MAX_VALUE;

       
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int[] edge : adj[city]) {
                int neighbor = edge[0], dist = edge[1];
                ans = Math.min(ans, dist);   
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return ans;
    }
}
