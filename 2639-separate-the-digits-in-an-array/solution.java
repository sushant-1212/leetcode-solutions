class Solution {
    public int[] separateDigits(int[] nums) {

        List<Integer> result = new ArrayList<>();
    
        for (int i = 0; i < nums.length; i++) {  

            String s = Integer.toString(nums[i]);        
            for (int j = 0; j < s.length(); j++) {  

                result.add(s.charAt(j) - '0');
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {

            ans[i] = result.get(i);
        }
    return ans;
    }
}

