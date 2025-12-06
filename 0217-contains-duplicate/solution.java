class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i:nums){
            if(m.containsKey(i)){
                return true;
            }
            m.put(i,1);
        }
        return false;
    }
}
