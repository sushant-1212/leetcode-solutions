class Solution {
    public int firstPos(int[]nums, int target){
        int low = 0;
        int ans = -1;
        int high = nums.length -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                high = mid-1;
            } else if(nums[mid]<target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
          return ans;
    }
    public int lastPos(int[]nums, int target){
        int low = 0;
        int ans = -1;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                low = mid+1;
            } else if(nums[mid]>target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstPos(nums,target);
        int last = lastPos(nums,target);
        return new int[]{first,last};
        
    }
}
