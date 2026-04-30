class Solution {

    int[][] grid;
    int n, m;
    int[][][] memo;

    
    private int dfs(int r, int c, int k) {

        if (r >= n || c >= m) return -1;

        int val = grid[r][c];

        int cost;
        if (val == 0) cost = 0;
        else cost = 1;

        if (k < cost) return -1;

       
        if (r == n - 1 && c == m - 1) {
            return val;
        }

        
        if (memo[r][c][k] != -2) {
            return memo[r][c][k];
        }

        int right = dfs(r, c + 1, k - cost);
        int down  = dfs(r + 1, c, k - cost);

        int best = Math.max(right, down);

        if (best == -1) {
            memo[r][c][k] = -1;
        } else {
            memo[r][c][k] = val + best;
        }

        return memo[r][c][k];
    }

    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        memo = new int[n][m][k + 1];

     
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c <= k; c++) {
                    memo[i][j][c] = -2; 
                }
            }
        }

        int ans = dfs(0, 0, k);

        if (ans < 0) return -1;
        return ans;
    }
}
