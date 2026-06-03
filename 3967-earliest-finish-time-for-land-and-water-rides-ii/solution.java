class Solution {

    
    private int upperBound(int[] starts, int target) {

        int left = 0;
        int right = starts.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (starts[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }


   
    private int solve(int[] start1,
                      int[] dur1,
                      int[] start2,
                      int[] dur2) {

        int n = start2.length;

        int[][] rides = new int[n][2];

        for (int i = 0; i < n; i++) {
            rides[i][0] = start2[i];
            rides[i][1] = dur2[i];
        }

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        int[] starts = new int[n];
        int[] prefixMinDur = new int[n];
        int[] suffixMinFinish = new int[n];

        starts[0] = rides[0][0];
        prefixMinDur[0] = rides[0][1];

        for (int i = 1; i < n; i++) {

            starts[i] = rides[i][0];

            prefixMinDur[i] =
                Math.min(prefixMinDur[i - 1],
                         rides[i][1]);
        }

        suffixMinFinish[n - 1] =
            rides[n - 1][0] + rides[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {

            suffixMinFinish[i] =
                Math.min(
                    suffixMinFinish[i + 1],
                    rides[i][0] + rides[i][1]
                );
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {

            int finishFirst =
                start1[i] + dur1[i];

            int p =
                upperBound(starts, finishFirst);

            if (p >= 0) {

                ans = Math.min(
                    ans,
                    finishFirst + prefixMinDur[p]
                );
            }

            if (p + 1 < n) {

                ans = Math.min(
                    ans,
                    suffixMinFinish[p + 1]
                );
            }
        }

        return ans;
    }


   
    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        ans = Math.min(
            ans,
            solve(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration
            )
        );

        ans = Math.min(
            ans,
            solve(
                waterStartTime,
                waterDuration,
                landStartTime,
                landDuration
            )
        );

        return ans;
    }
}
