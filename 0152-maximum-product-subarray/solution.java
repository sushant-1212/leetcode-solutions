class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = nums[0];
        int minPro = nums[0];
        int n = nums.length;
        int ans = nums[0];
        for(int i = 1; i<n; i++){
            int curr = nums[i]; 
            if(curr<0){

                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }

            maxPro = Math.max(curr,maxPro*curr);
            minPro = Math.min(curr,minPro*curr);
            ans = Math.max(ans,maxPro);
        }
        return ans;
    }
}

