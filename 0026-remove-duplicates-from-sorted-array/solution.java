class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; // keep track of every unique element so farr..
        for(int j = 1; j<nums.length; j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
        
    }
}
