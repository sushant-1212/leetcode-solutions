class Solution {
    int[]dp;
    public int recursion(int amount , int[] coins){
        if(amount==0){
            return 0;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<coins.length; i++){
            if(amount>=coins[i]){
                int currops = recursion((amount-coins[i]),coins);
                if(currops!=Integer.MAX_VALUE){
                    ans = Math.min(ans,1+currops);
                }
            }
        }
        dp[amount]=ans;
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[(amount+1)];
        for(int i = 0; i<=amount; i++){
            dp[i]=-1;
        }
        int ans =  recursion(amount,coins);
        if(ans==Integer.MAX_VALUE){
            ans = -1;
        }
        return ans;
    }
}
