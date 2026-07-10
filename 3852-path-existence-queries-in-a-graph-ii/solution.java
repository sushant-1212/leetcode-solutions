import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] tempOrder = new Integer[n];
        for (int i = 0; i < n; i++) tempOrder[i] = i;
        Arrays.sort(tempOrder, (a, b) -> nums[a] - nums[b]);

        int[] sortedToOriginal = new int[n];
        int[] originalToSorted = new int[n];
        for (int i = 0; i < n; i++) {
            sortedToOriginal[i] = tempOrder[i];
            originalToSorted[sortedToOriginal[i]] = i;
        }

      
        int[] leftmostReach = new int[n];
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (left < i && nums[sortedToOriginal[i]] - nums[sortedToOriginal[left]] > maxDiff) {
                left++;
            }
            leftmostReach[i] = left;
        }

       
        int numLevels = 32 - Integer.numberOfLeadingZeros(Math.max(n, 1));
        int[][] jump = new int[numLevels][n];
        jump[0] = leftmostReach;
        for (int k = 1; k < numLevels; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int a = originalToSorted[queries[q][0]];
            int b = originalToSorted[queries[q][1]];
            int lo = Math.min(a, b);
            int hi = Math.max(a, b);

            if (lo == hi) {
                ans[q] = 0;
                continue;
            }

            int hops = 0;
            int cur = hi;
            for (int k = numLevels - 1; k >= 0; k--) {
                if (jump[k][cur] > lo) {
                    cur = jump[k][cur];
                    hops += (1 << k);
                }
            }

            if (leftmostReach[cur] <= lo) {
                ans[q] = hops + 1;
            } else {
                ans[q] = -1;
            }
        }

        return ans;
    }
}
