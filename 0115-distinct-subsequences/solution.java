class Solution {
    String a;
    String b;
    int[][] dp;
    public int recursion(int i , int j){
        if(j==b.length()){
            return 1;
        }
        if(i==a.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ops1 = 0;
        int ops2 = 0;
        if(a.charAt(i) == b.charAt(j)){
            ops1 = recursion(i+1,j+1);
        }
        ops2 = recursion(i+1,j);
        
        dp[i][j] = ops1 + ops2;
        return dp[i][j];
        
    }
    public int numDistinct(String s, String t) {
        a = s;
        b = t;
        dp = new int[1001][1001];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<t.length(); j++){
                dp[i][j] = -1;
            }
        }
        return recursion(0,0);
    }
}
