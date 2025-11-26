class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();

        // Step 1 → sirf even number ki frequency count karo
        for (int x : nums) {
            if (x % 2 == 0) {
                m.put(x, m.getOrDefault(x, 0) + 1);
            }
        }

        // Step 2 → koi even hi nahi mila
        if (m.size() == 0) return -1;

        int ans = -1;
        int maxFreq = -1;

        // Step 3 → max frequency + smallest number choose karo
        for (int key : m.keySet()) {
            int freq = m.get(key);

            if (freq > maxFreq || (freq == maxFreq && key < ans)) {
                maxFreq = freq;
                ans = key;
            }
        }

        return ans;
    }
}

