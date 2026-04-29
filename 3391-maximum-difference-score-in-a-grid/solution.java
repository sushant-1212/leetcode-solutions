class Solution {
    public int maxScore(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dp = new int[m][n];
        int ans = Integer.MIN_VALUE;

        dp[0][0] = grid.get(0).get(0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                int minVal = Integer.MAX_VALUE;

                if (i > 0) minVal = Math.min(minVal, dp[i - 1][j]);
                if (j > 0) minVal = Math.min(minVal, dp[i][j - 1]);

                int curr = grid.get(i).get(j);

                ans = Math.max(ans, curr - minVal);

                dp[i][j] = Math.min(curr, minVal);
            }
        }

        return ans;
    }
}
