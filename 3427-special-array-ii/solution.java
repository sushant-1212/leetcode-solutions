class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int[] bad = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            bad[i] = bad[i - 1];

            if ((nums[i] & 1) == (nums[i - 1] & 1)) {
                bad[i]++;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            if (bad[r] - bad[l] == 0) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }

        return ans;
    }
}
