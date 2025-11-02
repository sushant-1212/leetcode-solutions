class Solution {
    List<List<Integer>> ans;
    List<Integer> currentSeq;
    public void recur(int target , int index , int[]candidates){
        if(target == 0){
            ans.add(new ArrayList<>(currentSeq));
            return;
        }
        for(int i = index; i<candidates.length; i++){
            if(target>=candidates[i]){
                currentSeq.add(candidates[i]);
                recur(target-candidates[i],i,candidates);
                currentSeq.remove(currentSeq.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        currentSeq = new ArrayList<>();
        recur(target,0,candidates);
        return ans;
    }
}
