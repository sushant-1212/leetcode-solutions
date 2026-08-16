class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] % 3 == 0) {
                cnt0++;
            } else if (stones[i] % 3 == 1) {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        if (cnt1 == 0 || cnt2 == 0) {
            return Math.max(cnt1, cnt2) > 2 && cnt0 % 2 == 1;
        }

        return Math.abs(cnt1 - cnt2) > 2 || cnt0 % 2 == 0;
    }
}
