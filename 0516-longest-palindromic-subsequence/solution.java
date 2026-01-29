class Solution {
    String s, rev;
    int[][] dp;
    int n;

    public int rec(int i, int j) {
     
        if (i == n || j == n) {
            return 0;
        }

      
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == rev.charAt(j)) {
            dp[i][j] = 1 + rec(i + 1, j + 1);
        } 
      
        else {
            dp[i][j] = Math.max(
                rec(i + 1, j),
                rec(i, j + 1)
            );
        }

        return dp[i][j];
    }

    public int longestPalindromeSubseq(String str) {
        s = str;
        rev = new StringBuilder(str).reverse().toString();
        n = s.length();

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return rec(0, 0);
    }
}

