class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        for(int i = 0; i<=n; i++){
            dp[i]=-1;
        }
        return recursion(n);
        
    }
    private int recursion(int n){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans = recursion(n-1) + recursion(n-2);
        dp[n] = ans;
        return ans;
    }

}
