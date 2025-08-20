class Solution {
    public int maxSubArray(int[] nums) {
        int currentsum = nums[0];
        int maxsum = nums[0];
        int n = nums.length;
        for(int i = 1; i<n; i++){
            int option1 = nums[i];
            int option2 = nums[i] + currentsum;
            currentsum = Math.max(option1,option2);
            if(currentsum>maxsum){
            maxsum = currentsum;
            }
        }
        return maxsum;
    }
}

        
        
        


     
