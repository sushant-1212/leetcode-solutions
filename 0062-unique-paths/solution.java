class Solution {
    int[][]dp;
    int r , c;
    public int recursion(int i , int j){
        if(i==r-1 && j==c-1){
            return 1;
        }
        if(i>=r || j>=c){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ops1 = recursion(i+1,j);
        int ops2 = recursion(i,j+1);
        int ans = ops1+ ops2;
        dp[i][j] = ans;
        return ans;
    }
    public int uniquePaths(int m, int n) {
        r = m;
        c = n;
        dp = new int[101][101];
        for(int i = 0; i<101; i++){
            for(int j = 0; j<101; j++){
                dp[i][j]=-1;
            }
        }
        return recursion(0,0);
        
    }
}
