class Solution {
    String a;
    String b;
    int[][]dp;
    public int recursion(int i , int j){
        if(i==a.length() || j == b.length()){
            return 0;
        }
        int ops1 = Integer.MIN_VALUE;
        int ops2 = Integer.MIN_VALUE;
        int ops3 = Integer.MIN_VALUE;
        int ans = 0;
          if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(a.charAt(i)==b.charAt(j)){
            ops1 = 1+recursion(i+1,j+1);
        }
        ops2 = recursion(i+1,j);
        ops3 = recursion(i,j+1);
        ans = Math.max(ops1,Math.max(ops2,ops3));
        dp[i][j] = ans;
        return ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        a = text1;
        b = text2;
        dp = new int[1001][1001];
        for(int i = 0; i<1001; i++){
            for(int j = 0; j<1001; j++){
                dp[i][j] = -1;
            }
        }
        return recursion(0,0);
        
    }
}
