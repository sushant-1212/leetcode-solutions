class Solution {
    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int parts = 1;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {

                if (sum + nums[i] > mid) {
                    parts++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }

            if (parts <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
