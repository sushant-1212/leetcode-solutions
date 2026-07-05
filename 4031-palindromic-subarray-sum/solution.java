class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long best = Long.MIN_VALUE;

       
        int SEP = -1; 
        int m = 2 * n + 1;
        int[] t = new int[m];
        for (int i = 0; i < n; i++) {
            t[2 * i] = SEP;
            t[2 * i + 1] = nums[i];
        }
        t[2 * n] = SEP;

        int[] radius = new int[m];
        int center = 0, right = 0;

        for (int i = 0; i < m; i++) {

            
            if (i < right) {
                radius[i] = Math.min(right - i, radius[2 * center - i]);
            }

         
            int l = i - radius[i] - 1;
            int r = i + radius[i] + 1;
            while (l >= 0 && r < m && t[l] == t[r]) {
                radius[i]++;
                l--;
                r++;
            }

           
            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }

          
            int len = radius[i];
            if (len > 0) {
                int start = (i - len) / 2;
                int end = start + len - 1;
                long sum = prefix[end + 1] - prefix[start];
                best = Math.max(best, sum);
            }
        }

        return best;
    }
}
