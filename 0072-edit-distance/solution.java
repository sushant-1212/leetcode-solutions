class Solution {
    String s1;
    String s2;
    int[][]dp;
    public int recursion(int i , int j){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(s1.charAt(i)==s2.charAt(j)){
             dp[i][j] = recursion(i+1,j+1);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        int ops1 = Integer.MAX_VALUE;
        int ops2 = Integer.MAX_VALUE;
        int ops3 = Integer.MAX_VALUE;
        ops1 = 1 + recursion(i ,j+1);
        ops2 = 1 + recursion(i+1 , j+1);
        ops3 = 1 + recursion(i+1,j);
        ans = Math.min(ops1,Math.min(ops2,ops3));
        dp[i][j]=ans;
        return ans;

    }
    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        dp = new int[501][501];
        for(int i = 0; i<501; i++){
            for(int j = 0; j<501; j++){
                dp[i][j]=-1;
            }
        }
        return recursion(0,0);
    }
}
