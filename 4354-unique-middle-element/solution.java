class Solution {
    public boolean isMiddleElementUnique(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int mid = nums.length / 2;
        int middle = nums[mid];

        return map.get(middle) == 1;
    }
}
