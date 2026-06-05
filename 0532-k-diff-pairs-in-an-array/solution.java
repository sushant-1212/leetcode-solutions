class Solution {
    public int findPairs(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        int count = 0;

        for (int i = 0; i < list.size(); i++) {

            int num = list.get(i);

            if (k == 0) {

                if (map.get(num) >= 2) {
                    count++;
                }

            } else {

                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
