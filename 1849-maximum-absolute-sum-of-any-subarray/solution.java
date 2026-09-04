class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        int currentMin = nums[0];
        int finalMin = nums[0];
        for(int i=1; i<nums.length; i++){
            currentSum = Math.max(nums[i],currentSum + nums[i]);
            maxSum = Math.max(currentSum,maxSum);
            currentMin = Math.min(nums[i] , currentMin + nums[i]);
            finalMin = Math.min(currentMin,finalMin);
        }

        return Math.max(maxSum,-finalMin);
        
    }
}
