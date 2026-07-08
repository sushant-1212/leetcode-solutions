class Solution {

    public int[] sumAndMultiply(String s, int[][] queries) {

        int mod = 1000000007;
        int n = s.length();

        long[] power = new long[n + 1];
        power[0] = 1;

        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * 10) % mod;
        }

        int[] sum = new int[n + 1];
        int[] count = new int[n + 1];
        long[] num = new long[n + 1];

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            sum[i + 1] = sum[i] + digit;

            count[i + 1] = count[i];

            num[i + 1] = num[i];

            if (digit != 0) {

                count[i + 1]++;

                num[i + 1] = (num[i] * 10 + digit) % mod;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1] + 1;

            int digitCount = count[r] - count[l];

            long value = (num[r] - (num[l] * power[digitCount]) % mod + mod) % mod;

            long digitSum = sum[r] - sum[l];

            ans[i] = (int) ((value * digitSum) % mod);
        }

        return ans;
    }
}
