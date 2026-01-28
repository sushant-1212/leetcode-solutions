class Solution {
    int[]dp;
    public int recursion(int n){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ops1 = recursion(n-1);
        int ops2 = recursion(n-2);
        int ans = ops1+ops2;
        dp[n] = ans;
        return ans;
    }
    public int climbStairs(int n) {
        dp = new int[46];
        for(int i = 0; i<46; i++){
            dp[i] = -1;
        }
        return recursion(n);
    }
}
