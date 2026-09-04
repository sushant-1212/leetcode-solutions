class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0];
        int currentSum = nums[0];
        int maxSum = nums[0];
        int currMin = nums[0];
        int finalMin = nums[0];

        for(int i=1; i<nums.length; i++){
            total+=nums[i];
            currentSum = Math.max(nums[i],currentSum + nums[i]);
            maxSum = Math.max(currentSum,maxSum);
            currMin = Math.min(nums[i] , currMin+nums[i] );
            finalMin = Math.min(currMin,finalMin);

        }
         if(maxSum<0){
            return maxSum;
         }
         int circularSum = total-finalMin;
         int ans = Math.max(maxSum,circularSum);
         return ans;
    }
}
