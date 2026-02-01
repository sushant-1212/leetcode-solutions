class Solution {
    int[][]dp;
    int r , c;
    int[][] grid;
    public int recursion(int i , int j){
        if(i>=r || j>=c){
            return 0;
        }
         if(grid[i][j]==1){
            return 0;
        }
        if(i==r-1 && j == c-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ops1 = recursion(i+1,j);
        int ops2 = recursion(i,j+1);
        int ans = ops1+ops2;
        dp[i][j]=ans;
        return ans;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        r = grid.length;
        c = grid[0].length;
         if(grid[0][0]==1){
            return 0;
        }
        dp = new int[101][101];
        for(int i = 0; i<101; i++){
            for(int j = 0; j<101; j++){
                dp[i][j]=-1;
            }
        }
        return recursion(0,0);
        
    }
}
