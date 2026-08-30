class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long maxSum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            maxSum = sum;
        }

        for (int right = k; right < nums.length; right++) {

            int left = right - k;

            sum -= nums[left];
            map.put(nums[left], map.get(nums[left]) - 1);

            if (map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }

            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
