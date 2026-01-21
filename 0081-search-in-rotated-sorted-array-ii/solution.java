class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        Arrays.sort(nums);
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return true;
            } else if(nums[mid]<target){
                low=mid+1;
            } else{
                high=mid-1;
            }
        }
        return false;
        
    }
}
