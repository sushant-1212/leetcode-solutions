class Solution {
    String S;
    int[]dp;
    public boolean isPalin(int i , int j){
        while(i<j){
            if(S.charAt(i)!=S.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int recursion(int i){
        if(i==S.length()){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int res = Integer.MAX_VALUE;
        for(int j = i; j<S.length(); j++){
            if(isPalin(i,j)){
                int option = 1 + recursion(j+1);
                res = Math.min(res,option);
            }
        }
        dp[i] = res;
        return res;
    }
    public int minCut(String s) {
        S = s;
        dp = new int[2001];
        for(int i = 0; i<2001; i++){
            dp[i]=-1;
        }
        int ans = recursion(0);
        return(ans-1);
        
    }
}
