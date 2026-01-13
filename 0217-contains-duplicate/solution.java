class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int x : nums){
            if(m.containsKey(x)){
                return true;
            } else{
                m.put(x,1);
            }
        }
        return false;
        
    }
}
