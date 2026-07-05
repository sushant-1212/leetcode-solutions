class Solution {

    public int maxDigitRange(int[] nums) {

        int maxRange = -1;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int range = getRange(nums[i]);

            if (range > maxRange) {
                maxRange = range;
                ans = nums[i];
            }
            else if (range == maxRange) {
                ans += nums[i];
            }
        }

        return ans;
    }

    public int getRange(int num) {

        int max = -1;
        int min = 9;

        while (num > 0) {

            int digit = num % 10;

            max = Math.max(max, digit);
            min = Math.min(min, digit);

            num /= 10;
        }

        return max - min;
    }
}
