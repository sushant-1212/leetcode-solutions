class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> m = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        m.put(0,-1);
        for(int i = 0; i<n; i++){
            if(nums[i]==0){
                sum-=1;
            } else{
                sum+=1;
            }
            if(m.containsKey(sum)){
                maxLen = Math.max(maxLen , i-m.get(sum));
            } else{
                m.put(sum,i);
            }
        }
        return maxLen;
        
    }
}
