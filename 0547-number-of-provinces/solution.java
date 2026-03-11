class Solution {
    int[] vis;
    int[][]mat;
    public void dfs(int src , int[][]mat){
        vis[src] = 1;
        for(int i = 0; i<mat[src].length; i++){
            int neighbour = mat[src][i];
            if(vis[i]==0 && neighbour == 1){
                dfs(i,mat);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n =  isConnected.length;
        mat =  isConnected;
        int count = 0;
        vis = new int[n];
        for(int i = 0; i<n; i++){
            if(vis[i]==0){
                dfs(i, isConnected);
                count++;
            }
        }
        return count;
    }
}
