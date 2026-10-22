class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int[] count = new int[n+1];

        int finalAns = 1;

        dp[0] = 1;
        count[0] = 1;

        for(int i = 1; i < n; i++) {
            int currentAns = 1;
            count[i] = 1;

            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 > currentAns) {
                        currentAns = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[j] + 1 == currentAns) {
                        count[i] += count[j];
                    }
                }
            }

            dp[i] = currentAns;
            finalAns = Math.max(finalAns, dp[i]);
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(dp[i] == finalAns) {
                ans += count[i];
            }
        }

        return ans;
    }
}
