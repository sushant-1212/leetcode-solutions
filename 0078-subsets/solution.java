class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> currentSet = new ArrayList<>();
    public void recur(int index , int [] nums){
            if(index == nums.length){
                ans.add(new ArrayList<>(currentSet));
                return;
            }
            currentSet.add(nums[index]);
            recur(index+1,nums);
            currentSet.remove(currentSet.size()-1);
            recur(index+1,nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        recur(0,nums);
        return ans;
        
    }
}
