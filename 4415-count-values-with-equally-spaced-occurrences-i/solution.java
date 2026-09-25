class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int ans = 0;
        for(int x : map.keySet()){
            if(map.get(x)==3){
                int first = -1;
                int second = -1;
                int third = -1;
                
                for(int i=0; i<nums.length; i++){
                    if(nums[i] == x){
                        if(first == -1){
                            first = i;
                        } else if(second == -1){
                            second = i;
                        } else if(third == -1){
                            third = i;
                        }
                    }
                }
                if(second-first == third-second){
                    ans++;
                }
            }
        }
        return ans;
    }
}
