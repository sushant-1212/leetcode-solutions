class Solution {
    public int firstorr(int[] nums, int target){
        int st = 0;
        int end = nums.length-1;
        int ans = -1;
        while(st<=end){
            int mid = (st+end)/2;
            if(nums[mid]==target){
                ans = mid;
                end = mid-1;
            } else if(nums[mid]<target){
                st = mid+1;
            } else{
                end = mid-1;
            }
        }
        return ans;
    }
     public int lastorr(int[] nums, int target){
        int st = 0;
        int end = nums.length-1;
        int ans = -1;
        while(st<=end){
            int mid = (st+end)/2;
            if(nums[mid]==target){
                ans = mid;
                st = mid+1;
            } else if(nums[mid]<target){
                st = mid+1;
            } else{
                end = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int fo = firstorr(nums,target);
        int lo = lastorr(nums,target);
        int ans[] = {fo,lo};
         return ans;
    }
}
