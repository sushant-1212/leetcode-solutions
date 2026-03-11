class Solution {
    int m;
    int n;
    int[][]vis;
    char[][] mat;
    public void dfs(int i , int j){
        if(i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if(mat[i][j]=='0'){
            return;
        }
        if(mat[i][j]=='1' && vis[i][j]==1){
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
        m = grid.length;
        n = grid[0].length;
        vis = new int[m][n];
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
}
