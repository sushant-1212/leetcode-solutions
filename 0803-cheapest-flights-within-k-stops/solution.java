class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int INF = (int)1e9;
        int[] dist = new int[n];
        
        for(int i = 0; i < n; i++){
            dist[i] = INF;
        }

        dist[src] = 0;

      
        for(int i = 0; i <= k; i++){
            
            int[] temp = dist.clone();

            for(int j = 0; j < flights.length; j++){
                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];

                if(dist[u] != INF && dist[u] + w < temp[v]){
                    temp[v] = dist[u] + w;
                }
            }

            dist = temp;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}
