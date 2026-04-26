class Solution {
    char[][] mat;
    int[][]vis;
    int m;
    int n;
    boolean hasCycle;
    public void dfs(int i, int j, int pi, int pj){
        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }
        vis[i][j]=1;
        if(i-1>=0 && mat[i-1][j]==mat[i][j]){
            if(vis[i-1][j]==0){
                dfs(i-1,j,i,j);
            } else if(!(i-1==pi && j==pj)){
                hasCycle = true;
                return;
            }
        }

        if(i+1<m && mat[i+1][j]==mat[i][j]){
            if(vis[i+1][j]==0){
                dfs(i+1,j,i,j);
            } else if(!(i+1==pi && j==pj)){
                hasCycle = true;
                return;
            }
        }
        if(j-1>=0 && mat[i][j-1]==mat[i][j]){
            if(vis[i][j-1]==0){
                dfs(i,j-1,i,j);
            } else if(!(i==pi && j-1==pj)){
                hasCycle = true;
                return;
            }
        }
        if(j+1<n && mat[i][j+1]==mat[i][j]){
            if(vis[i][j+1]==0){
                dfs(i,j+1,i,j);
            } else if(!(i==pi && j+1==pj)){
                hasCycle = true;
                return;
            }
        }
    }

    public boolean containsCycle(char[][] grid) {
        mat = grid;
        m = grid.length;
         n = grid[0].length;
        vis = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]==0){
                    dfs(i,j,-1,-1);
                }
            }
        }
        if(hasCycle){
            return true;
        }
        return false;
        
    }
}
