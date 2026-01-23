class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            ans.add(nums[i]);
        }
        int ops = 0;
        while(!isSorted(ans)) {
            int minSum = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i<ans.size()-1; i++){
                int sum = ans.get(i) + ans.get(i+1);
                if(sum<minSum){
                    minSum = sum;
                    index = i;
                }
            }
            int mergevalue = ans.get(index) + ans.get(index+1);
            ans.set(index , mergevalue);
            ans.remove(index+1);
            ops++;

        }
        return ops; 
        
    }
    private boolean isSorted(List<Integer>ans){
        for(int i = 1; i<ans.size(); i++){
            if(ans.get(i)<ans.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
