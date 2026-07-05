class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];


        int j = 0;
        boolean failed = false;
        for (int i = 0; i < n; i++) {
            if (failed) { left[i + 1] = m + 1; continue; }
            char c = s.charAt(i);
            while (j < m && t.charAt(j) != c) j++;
            if (j == m) { failed = true; left[i + 1] = m + 1; }
            else { j++; left[i + 1] = j; }
        }


        right[n] = m;
        j = m - 1;
        failed = false;
        for (int i = n - 1; i >= 0; i--) {
            if (failed) { right[i] = -1; continue; }
            char c = s.charAt(i);
            while (j >= 0 && t.charAt(j) != c) j--;
            if (j < 0) { failed = true; right[i] = -1; }
            else { right[i] = j; j--; }
        }

       
        if (left[n] <= m) return true;

       
        for (int i = 0; i < n; i++) {
            if (left[i] <= m && right[i + 1] >= 0 && left[i] < right[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
