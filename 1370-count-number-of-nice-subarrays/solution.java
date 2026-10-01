class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int count = 0;
        int oddCount = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 1) {
                oddCount++;
            }

            if (map.containsKey(oddCount - k)) {
                count += map.get(oddCount - k);
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }
}
