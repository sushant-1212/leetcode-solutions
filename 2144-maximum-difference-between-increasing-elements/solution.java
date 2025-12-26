class Solution {
    public int maximumDifference(int[] nums) {
        int minSoFar = nums[0];
        int ans = -1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]>minSoFar){
                ans = Math.max(ans , nums[i]-minSoFar);
            }
            minSoFar = Math.min(nums[i],minSoFar);
        }
        return ans;
    }
}


        

