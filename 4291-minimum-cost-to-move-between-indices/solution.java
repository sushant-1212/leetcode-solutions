class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] closest = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                closest[i] = 1;
            } else if (i == n - 1) {
                closest[i] = n - 2;
            } else {
                int left = nums[i] - nums[i - 1];
                int right = nums[i + 1] - nums[i];

                if (left <= right) closest[i] = i - 1;
                else closest[i] = i + 1;
            }
        }

        int[] prefR = new int[n];
        for (int i = 1; i < n; i++) {
            if (closest[i - 1] == i) {
                prefR[i] = prefR[i - 1] + 1;
            } else {
                prefR[i] = prefR[i - 1] + (nums[i] - nums[i - 1]);
            }
        }

        int[] prefL = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (closest[i + 1] == i) {
                prefL[i] = prefL[i + 1] + 1;
            } else {
                prefL[i] = prefL[i + 1] + (nums[i + 1] - nums[i]);
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l < r) {
                ans[i] = prefR[r] - prefR[l];
            } else {
                ans[i] = prefL[r] - prefL[l];
            }
        }

        return ans;
    }
}
