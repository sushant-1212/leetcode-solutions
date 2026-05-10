class Solution {
    int[][]dp;
    int[][] mat;
    int m;
    int n;
    public int  dfs(int i, int j){
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int bestSoFar = 1;
        if(i-1>=0 && mat[i-1][j]>mat[i][j]){
            bestSoFar = Math.max(bestSoFar , 1+dfs(i-1,j));

        }
        if(i+1<m && mat[i+1][j]>mat[i][j]){
            bestSoFar = Math.max(bestSoFar , 1+dfs(i+1,j));

        }
        if(j+1<n && mat[i][j+1]>mat[i][j]){
            bestSoFar = Math.max(bestSoFar , 1+dfs(i,j+1));

        }
        if(j-1>=0 && mat[i][j-1]>mat[i][j]){
            bestSoFar = Math.max(bestSoFar , 1+dfs(i,j-1));

        }
        return dp[i][j] = bestSoFar;
    }
    public int longestIncreasingPath(int[][] matrix) {
        mat = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans=Math.max(ans,dfs(i,j));
            }
        }

        return ans;
        
    }
}
