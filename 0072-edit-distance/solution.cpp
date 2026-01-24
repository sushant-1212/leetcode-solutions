class Solution {
public:
    vector<vector<int>> dp;
    string s1, s2;

    int recursion(int i, int j) {
        // base cases
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;

        if (dp[i][j] != -1) return dp[i][j];

        // if characters match
        if (s1[i] == s2[j]) {
            return dp[i][j] = recursion(i + 1, j + 1);
        }

        // operations
        int insertOp  = 1 + recursion(i, j + 1);     // insert
        int deleteOp  = 1 + recursion(i + 1, j);     // delete
        int replaceOp = 1 + recursion(i + 1, j + 1); // replace

        return dp[i][j] = min(insertOp, min(deleteOp, replaceOp));
    }

    int minDistance(string word1, string word2) {
        s1 = word1;
        s2 = word2;

        dp.assign(s1.length(), vector<int>(s2.length(), -1));
        return recursion(0, 0);
    }
};

