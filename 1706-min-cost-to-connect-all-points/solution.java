
import java.util.*;

class Solution {

    class DSU {

        int[] parent;

        DSU(int n) {

            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {

            if (parent[x] == x)
                return x;

            return parent[x] = find(parent[x]);
        }

        boolean union(int a, int b) {

            int pa = find(a);
            int pb = find(b);

            // cycle
            if (pa == pb)
                return false;

            parent[pa] = pb;

            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

    
    
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);


        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int dist =
                    Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1]);

                pq.offer(new int[]{dist, i, j});
            }
        }

        DSU dsu = new DSU(n);

        int ans = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty()) {

            int[] edge = pq.poll();

            int dist = edge[0];
            int u = edge[1];
            int v = edge[2];

           
           
            if (dsu.union(u, v)) {

                ans += dist;

                edgesUsed++;

               
                if (edgesUsed == n - 1)
                    break;
            }
        }

        return ans;
    }
}
