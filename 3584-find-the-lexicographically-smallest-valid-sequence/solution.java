class Solution {
    public int[] validSequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[] suf = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];

            if (j >= 0 && s.charAt(i) == t.charAt(j)) {
                suf[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        j = 0;
        boolean used = false;

        for (int i = 0; i < n && j < m; i++) {

            if (s.charAt(i) == t.charAt(j)) {
                ans[j] = i;
                j++;
            }
            else if (!used && suf[i + 1] >= m - j - 1) {
                ans[j] = i;
                j++;
                used = true;
            }
        }

        if (j == m) {
            return ans;
        }

        return new int[0];
    }
}
