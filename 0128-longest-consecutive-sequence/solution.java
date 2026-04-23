class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int longest=0;
        ArrayList<Integer> ans = new ArrayList<>(set);
        for(int i=0; i<ans.size(); i++){
            int num=ans.get(i);
            if(!set.contains(num-1)){
                int curr = num;
                int count = 1;
                while(set.contains(curr+1)){
                    curr=curr+1;
                    count+=1;
                }
                if(count>longest){
                    longest = count;
                }
            }
        }
        return longest;
        
    }
}
