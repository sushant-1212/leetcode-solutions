class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char mid = '\0';

        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1) {
                mid = (char) ('a' + i);
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (mid != '\0') {
            ans.append(mid);
        }

        
        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        return ans.toString();
    }
}
