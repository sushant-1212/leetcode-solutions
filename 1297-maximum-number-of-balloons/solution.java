class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, freq['b' - 'a']);
        ans = Math.min(ans, freq['a' - 'a']);
        ans = Math.min(ans, freq['l' - 'a'] / 2);
        ans = Math.min(ans, freq['o' - 'a'] / 2);
        ans = Math.min(ans, freq['n' - 'a']);

        return ans;
    }
}
