class Solution {

    int[][] dp;
    int[] nums;
    int n;

    public int minCost(int[] nums) {
        this.nums = nums;
        n = nums.length;

        if (n <= 2)
            return Math.max(nums[0], nums[n - 1]);

        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 1);
    }

    int solve(int last, int i) {

        if (i == n)
            return nums[last];

        if (i == n - 1)
            return Math.max(nums[last], nums[i]);

        if (dp[last][i] != -1)
            return dp[last][i];

        int op1 = Math.max(nums[last], nums[i]) + solve(i + 1, i + 2);

        int op2 = Math.max(nums[last], nums[i + 1]) + solve(i, i + 2);

        int op3 = Math.max(nums[i], nums[i + 1]) + solve(last, i + 2);

        return dp[last][i] = Math.min(op1, Math.min(op2, op3));
    }
}
