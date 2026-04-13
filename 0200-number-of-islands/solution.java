class Solution {
    int m;
    int n;
    char[][]mat;
    int[][]vis;
    public void dfs(int i , int j){
        if(i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if(vis[i][j]==1 && mat[i][j]=='1'){
            return;
        }
        if(mat[i][j]=='0'){
            return;
        }
        vis[i][j]=1;
        if(i+1<m && j<n && vis[i+1][j]==0){
            dfs(i+1,j);
        }
         if(i-1>=0 && j<n && vis[i-1][j]==0){
            dfs(i-1,j);
        }
         if(i<m && j+1<n && vis[i][j+1]==0){
            dfs(i,j+1);
        }
         if(i<m && j-1>=0 && vis[i][j-1]==0){
            dfs(i,j-1);
        }
    }
    public int numIslands(char[][] grid) {
        mat = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new int[m][n];
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
}
