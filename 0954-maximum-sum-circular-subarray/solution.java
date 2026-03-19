class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0];
        int currentSum = nums[0];
        int maxSum = nums[0];
        int currentMin = nums[0];
        int minSum = nums[0];
        for(int i = 1; i<nums.length; i++){
            total+=nums[i];
            currentSum = Math.max(nums[i] , currentSum+nums[i]);
            maxSum = Math.max(currentSum , maxSum);
            currentMin = Math.min(nums[i] , currentMin+nums[i]);
            minSum = Math.min(currentMin , minSum);
            }
             if(maxSum<0){
                return maxSum;
        }
        return Math.max(maxSum , total-minSum);
        
    }
}
