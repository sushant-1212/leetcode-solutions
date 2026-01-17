class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        for(int i = 0; i<=n; i++){
            dp[i]=-1;
        }
        return recursion(n);
    }
    private int recursion(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int opt1 = recursion(n-1);
        int opt2 = recursion(n-2);
        int ans = opt1 + opt2;
        dp[n] = ans;
        return ans;
    }
}
