class Solution {
    int m;
    int n;
    int[][]mat;
    public void dfs(int i , int j){
        if(i<0 || j<0 || i>=m || j>=n || mat[i][j]==0){
            return;
        }
        mat[i][j] = 0;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
    public int numEnclaves(int[][] grid) {
        mat = grid;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i<m; i++){
            if(grid[i][0]==1){
                dfs(i,0);
            }
            if(grid[i][n-1]==1){
                dfs(i,n-1);
            }
        }
        for(int j = 0; j<n; j++){
            if(grid[0][j]==1){
                dfs(0,j);
            }
            if(grid[m-1][j]==1){
                dfs(m-1,j);
            }
        }
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
        
    }
}
