class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currentSeq = new ArrayList<>();
    public void recursion(int index , int nums[]){
        if(index == nums.length){
            answer.add(new ArrayList<Integer>(currentSeq));
            return;
        }
        currentSeq.add(nums[index]);
        recursion(index + 1 , nums);
        currentSeq.remove(currentSeq.size()-1);
        recursion(index + 1 , nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        recursion(0,nums);
        return answer;
        
    }
}
