class Solution {

    int[][] dp;
    int m, n;

    public int solve(int i, int j, int[][] grid) {

        if(i >= m || j >= n) {
            return (int)1e9;
        }

       
        if(i == m-1 && j == n-1) {
            return grid[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j+1, grid);
        int down  = solve(i+1, j, grid);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0,0,grid);
    }
}
