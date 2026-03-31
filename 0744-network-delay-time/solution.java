import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

       
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new int[]{v, w});
        }

        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0, k});

      
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            for(int i = 0; i < adj.get(node).size(); i++){
                int[] nei = adj.get(node).get(i);
                int adjNode = nei[0];
                int wt = nei[1];

                if(d + wt < dist[adjNode]){
                    dist[adjNode] = d + wt;
                    pq.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

       
        int maxTime = 0;

        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
