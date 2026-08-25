class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int multi = k; multi<=200; multi+=k){
            if(!set.contains(multi)){
                return multi;
            }
        }
        return 0;
        
    }
}
