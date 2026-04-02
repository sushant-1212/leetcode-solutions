class Solution {

    int[][] coins;
    int m, n;
    Integer[][][] dp;

    public int recursion(int i, int j, int k) {

        if (i >= m || j >= n) return -(int)1e9;

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && k > 0) return 0;
            return coins[i][j];
        }

        if (dp[i][j][k] != null) return dp[i][j][k];

        int val = coins[i][j];

        int ops1 = recursion(i + 1, j, k);
        int ops2 = recursion(i, j + 1, k);

        int next = Math.max(ops1, ops2);

        int take = val + next;

        int skip = -(int)1e9;
        if (val < 0 && k > 0) {
            int s1 = recursion(i + 1, j, k - 1);
            int s2 = recursion(i, j + 1, k - 1);
            skip = Math.max(s1, s2);
        }

        int ans = Math.max(take, skip);
        dp[i][j][k] = ans;

        return ans;
    }

    public int maximumAmount(int[][] coins) {
        this.coins = coins;
        m = coins.length;
        n = coins[0].length;

        dp = new Integer[m][n][3];

        return recursion(0, 0, 2);
    }
}
