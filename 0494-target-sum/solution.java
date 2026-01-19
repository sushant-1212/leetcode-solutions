class Solution {
    int dp[][];
    public int recursion(int index , int sum , int target , int[] nums){
        if(index==nums.length){
            if(sum==target){
            return 1;
        } else{
            return 0;
        }
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum];
        }
        int ops1 = recursion(index + 1 , sum+nums[index] , target , nums);
        int ops2 = recursion(index + 1 , sum-nums[index] , target , nums);
        int ans = ops1 + ops2;
        dp[index][sum]=ans;
        return ans;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n][2001];
        for(int i = 0; i<n; i++){
            for(int j =0; j<2001; j++){
                dp[i][j]=-1;
            }
        }
        return recursion(0,1000,target+1000,nums);
    }
}
