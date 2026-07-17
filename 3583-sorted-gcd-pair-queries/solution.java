class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        long[] cnt = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int m = d; m <= max; m += d) {
                cnt[d] += freq[m];
            }
        }

        long[] exact = new long[max + 1];

        
        for (int d = max; d >= 1; d--) {
            long pairs = cnt[d] * (cnt[d] - 1) / 2;

            for (int m = 2 * d; m <= max; m += d) {
                pairs -= exact[m];
            }

            exact[d] = pairs;
        }

        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1;

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}
