class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
                
            int maxans=0;
            for(int j=0; j<n; j++){
                maxans+=accounts[i][j];
                ans = Math.max(maxans,ans);
            }
        }
        return ans;
        
    }
}
