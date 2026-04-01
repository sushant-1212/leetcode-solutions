class Solution {

    public boolean canReach(int[] dist, double hour, int speed) {
        double time = 0.0;

        for (int i = 0; i < dist.length; i++) {
            if (i != dist.length - 1) {
                time += Math.ceil((double) dist[i] / speed);
            } else {
                time += (double) dist[i] / speed;
            }
        }

        return time <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = (int) 1e7;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, hour, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
