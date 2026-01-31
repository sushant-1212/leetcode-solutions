class Solution {
    public int minimumK(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = Integer.MAX_VALUE;
        int ans = right;
        while(left<=right){
            int mid = left+(right-left)/2;
            int ops = 0;
            for(int x : nums){
                ops+=(x+mid-1)/mid;
            }
            if(ops<=(long)mid*mid){
                ans = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return ans;
    }
}
