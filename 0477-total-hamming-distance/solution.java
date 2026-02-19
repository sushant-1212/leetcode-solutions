class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i<32; i++){
            int count1 = 0;
            for(int x : nums){
                if(((x>>i)&1)==1){
                    count1++;
                }
            }
            ans += count1*(n-count1);
        }
        return ans;
    }
}
