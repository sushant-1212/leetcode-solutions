class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n+1];
        int finalAns = 1;
        dp[0]=1;
        for(int i = 1; i<n; i++){
              int currentAns = 1;
            for(int j = 0; j<i; j++){
                if(nums[i]>nums[j]){
                    currentAns = Math.max(currentAns,1+dp[j]);
                }
            }
            dp[i]=currentAns;
            finalAns = Math.max(finalAns,dp[i]);
        }
        return finalAns;
        
    }
}
