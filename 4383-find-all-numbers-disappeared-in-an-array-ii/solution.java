import java.util.*;

class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int[] zelvoranki = nums;

        Arrays.sort(zelvoranki);

        List<List<Integer>> ans = new ArrayList<>();

        int start = lower;

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            if (x > upper) {
                break;
            }

            if (x < start) {
                continue;
            }

            if (x > start) {
                ans.add(Arrays.asList(start, x - 1));
            }

            start = x + 1;
        }

        if (start <= upper) {
            ans.add(Arrays.asList(start, upper));
        }

        return ans;
    }
}
