class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int prev2 = nums[0];                       
        int prev1 = Math.max(nums[0], nums[1]);   

        for(int i = 2; i < nums.length; i++){
            int pick = nums[i] + prev2;
            int skip = prev1;
            int curr = Math.max(pick, skip);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

