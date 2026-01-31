import java.util.*;

class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;

        for (int bit = 0; bit <= 30; bit++) {
            ArrayList<Integer> arr = new ArrayList<>();

          
            for (int x : nums) {
                if ((x & (1 << bit)) != 0) {
                    arr.add(x);
                }
            }


            ArrayList<Integer> tails = new ArrayList<>();

            for (int x : arr) {
                int pos = Collections.binarySearch(tails, x);
                if (pos < 0) pos = -(pos + 1);

                if (pos == tails.size()) {
                    tails.add(x);
                } else {
                    tails.set(pos, x);
                }
            }

            ans = Math.max(ans, tails.size());
        }
        return ans;
    }
}

