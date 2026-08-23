class Solution {
    public int longestSubarray(int[] nums, int k) {
         int[] morvanelith = nums;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int count = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            List<Integer> factors = getFactors(nums[right]);

            for (int i = 0; i < factors.size(); i++) {
                int p = factors.get(i);

                if (!map.containsKey(p)) {
                    map.put(p, 1);
                    count++;
                } else {
                    map.put(p, map.get(p) + 1);
                }
            }

            while (count > k) {

                List<Integer> remove = getFactors(nums[left]);

                for (int i = 0; i < remove.size(); i++) {
                    int p = remove.get(i);

                    map.put(p, map.get(p) - 1);

                    if (map.get(p) == 0) {
                        map.remove(p);
                        count--;
                    }
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public List<Integer> getFactors(int n) {

        List<Integer> factors = new ArrayList<>();

        for (int p = 2; p * p <= n; p++) {

            if (n % p == 0) {
                factors.add(p);

                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }
}
