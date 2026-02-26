class Solution {
    int n;
    int m;
     int[][] vis;
     char[][] mat;
     boolean hasCycle;
     public void dfs(int i , int j , int pi ,int pj){
        vis[i][j] = 1;
        if(i-1>=0 && mat[i-1][j]==mat[i][j]){
            if(vis[i-1][j]==0){
                dfs(i-1,j,i,j);
            } else if(!(i-1 == pi && j == pj)){
                hasCycle = true;
                return;
            }
        }
        if(i+1<n && mat[i+1][j]==mat[i][j]){
            if(vis[i+1][j]==0){
                dfs(i+1,j,i,j);
            } else if(!(i+1 == pi && j == pj)){
                hasCycle = true;
                return;
            }
        }
        if(j-1>=0 && mat[i][j-1]==mat[i][j]){
            if(vis[i][j-1]==0){
                dfs(i,j-1,i,j);
            } else if(!(i == pi && j-1 == pj)){
                hasCycle = true;
                return;
            }
        }
        if(j+1<m && mat[i][j+1]==mat[i][j]){
            if(vis[i][j+1]==0){
                dfs(i,j+1,i,j);
            } else if(!(i == pi && j+1 == pj)){
                hasCycle = true;
                return;
            }
        }
     }
    public boolean containsCycle(char[][] grid) {
        mat = grid;
         n = grid.length;
         m = grid[0].length;
         vis = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j]==0){
                    dfs(i,j,-1,-1);
                    if(hasCycle){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
