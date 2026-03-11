class Solution {
    int m;
    int n;
    int[][]vis;
    int[][] mat;
    public int dfs(int i , int j){
        if(i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        if(vis[i][j]==1 || mat[i][j]==0){
            return 0;
        }
        vis[i][j]=1;
        int area = 1;
        area += dfs(i+1,j);
        area += dfs(i-1,j);
        area += dfs(i,j+1);
        area += dfs(i,j-1);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        mat = grid;
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        vis = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    int area = dfs(i,j);
                    max = Math.max(max,area);
                }
            }
        }
        return max;
        
    }
}
