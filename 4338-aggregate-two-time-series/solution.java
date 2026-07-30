class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0, j = 0;
        int n = series1.length, m = series2.length;

        while (i < n && j < m) {
            if (series1[i][0] < series2[j][0]) {
                ans.add(Arrays.asList(series1[i][0], series1[i][1] + series2[j][1]));
                i++;
            } else if (series1[i][0] > series2[j][0]) {
                ans.add(Arrays.asList(series2[j][0], series1[i][1] + series2[j][1]));
                j++;
            } else {
                ans.add(Arrays.asList(series1[i][0], series1[i][1] + series2[j][1]));
                i++;
                j++;
            }
        }

        while (i < n) {
            ans.add(Arrays.asList(series1[i][0], series1[i][1]));
            i++;
        }

        while (j < m) {
            ans.add(Arrays.asList(series2[j][0], series2[j][1]));
            j++;
        }

        return ans;
    }
}
