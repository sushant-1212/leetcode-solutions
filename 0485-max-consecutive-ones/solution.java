class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int left = 0;
        int ans = Integer.MIN_VALUE;
        for(int right = 0; right<nums.length; right++){
            if(nums[right] == 0){
                left = right + 1;
            }
            ans = Math.max(ans,right-left + 1);
        }
        return ans;
    }
}
