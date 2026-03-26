class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxprofit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
                maxprofit = Math.max(maxprofit,profit);
            }
        }

        return profit;
    }
}
