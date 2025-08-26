class Solution {
    public int maxProfit(int[] prices) {
        int mp = prices[0];
        int ans = 0;
        int n = prices.length;
        for(int i = 1; i<n; i++){
            if(prices[i]>mp){
                ans = Math.max(ans, (prices[i]-mp));
            } else {
                mp = prices[i]; 
            }
        }
        return ans;
    }
}
          
