import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }

      
        boolean[] present = new boolean[max + 1];

        for (int i = 0; i < nums.length; i++) {
            present[nums[i]] = true;
        }

        
        List<Integer> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!present[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
