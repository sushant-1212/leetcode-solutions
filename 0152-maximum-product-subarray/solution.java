class Solution {
    public int maxProduct(int[] nums) {
        int currentPro = nums[0];
        int mincurrentPro = nums[0];
        int maxPro = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i]<0){
                int temp = currentPro;
                currentPro = mincurrentPro;
                mincurrentPro = temp;
            }
            currentPro = Math.max(nums[i] , currentPro*nums[i]);
            mincurrentPro = Math.min(nums[i] , mincurrentPro*nums[i]);
            maxPro = Math.max(currentPro , maxPro);
        }
        return maxPro;
        
    }
}
