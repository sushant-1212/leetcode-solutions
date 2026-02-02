class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int x : nums){
            totalSum+=x;
        }
        int leftSum = 0;
        for(int i = 0; i<n; i++){
            int rightSum = totalSum-leftSum-nums[i];
            if(leftSum==rightSum){
                return i;
            } else{
                leftSum+=nums[i];
            }
        }
        return -1;
        
    }
}
