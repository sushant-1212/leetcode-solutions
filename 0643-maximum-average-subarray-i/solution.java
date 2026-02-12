class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int ws = 0;
        for(int i = 0; i<k; i++){
            ws+=nums[i];
        }
        int  maxws = ws;
        for(int i = k; i<n; i++){
            ws = ws-nums[i-k]+nums[i];
            maxws = Math.max(ws,maxws);
        }
        return (double)maxws/k;
    }
}
