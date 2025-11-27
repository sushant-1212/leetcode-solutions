class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> m = new HashMap<>();
         m.put(0,1);
        for(int i = 0; i<n; i++){
            sum+=nums[i];
            ans+= m.getOrDefault((sum-k),0);
            m.put(sum,(m.getOrDefault(sum,0)+1));
        }
        return ans;
    }
}
