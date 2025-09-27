class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(nums[i]<mn){
                mn = nums[i];
            }
            if(nums[i]>mx){
                mx = nums[i];
            }
        }
        long range = (long)mx - (long)mn;
        return range * (long)k;
        
    }
}
