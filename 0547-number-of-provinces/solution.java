class Solution {
    int[]vis;
    public void dfs(int src , int[][] isConnected){
        vis[src] = 1;
        for(int i = 0; i<isConnected[src].length; i++){
            int val = isConnected[src][i];
            if(val==1 && vis[i]==0){
                dfs(i,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        vis = new int[n];
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(vis[i]==0){
                ans++;
                dfs(i,isConnected);
            }
        }
        return ans;
    }
}
