class Solution {
    int n;
    int m;
    int[][]vis;
    char[][] mat;
    public void dfs(int i , int j){
        if(i<0 || j<0 || i>=n || j>=m){
            return;
        }
        if(mat[i][j]=='0'){
            return;
        }
        if(vis[i][j]==1){
            return;
        }
        vis[i][j] = 1;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);

    }
    public int numIslands(char[][] grid) {
        mat = grid;
        n = grid.length;
        m = grid[0].length;
        vis = new int[n][m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j]== 0 && mat[i][j]=='1'){
                    count++;
                    dfs(i,j);
                }
            }
        }
        return count;
        
    }
}
