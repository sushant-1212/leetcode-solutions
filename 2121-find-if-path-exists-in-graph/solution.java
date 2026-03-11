class Solution {
    int[] vis;
    List<List<Integer>> adj;
    public boolean dfs(int src, int dest){
        if(src == dest){
            return true;
        }
        vis[src] = 1;
        List<Integer> neighbours = adj.get(src);
        for(int i = 0; i<neighbours.size(); i++){
            int nei = neighbours.get(i);
            if(vis[nei]==0){
                boolean found = dfs(nei,dest);
                    if(found == true){
                        return true;
                    }
                }
            }
            return false;
        }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adj = new ArrayList<>();
        vis = new int[n];
        for(int i = 0; i<n; i++){
            List<Integer> a = new ArrayList<>();
            adj.add(new ArrayList<>(a));
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(source , destination);
    }
}
