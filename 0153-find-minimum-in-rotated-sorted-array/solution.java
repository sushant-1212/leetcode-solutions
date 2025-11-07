class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int st = 0;
        int end = n-1;
        while(st<=end){
            int mid = (st+end)/2;
            if(nums[(mid-1+n)%n]>nums[mid]&&nums[mid]<nums[(mid+1)%n]){
                return nums[mid];
            }
            else if(nums[st]<=nums[mid]&&nums[mid]<=nums[end]){
                return nums[st];
            } else if(nums[st]<=nums[mid]){
                st=mid+1;
            } else{
                end = mid-1;
            }
        }
        return nums[0];
    }
}
