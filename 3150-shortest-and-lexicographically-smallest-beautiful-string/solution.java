class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();
        String best = "";
        int ones = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones == k) {
                int length = right - left + 1;
                String candidate = s.substring(left, right + 1);

                if (best.isEmpty() 
                    || length < best.length() 
                    || (length == best.length() && candidate.compareTo(best) < 0)) {
                    best = candidate;
                }

                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
        }

        return best;
        
    }
}
