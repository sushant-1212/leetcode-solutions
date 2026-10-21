class Solution {
    public String countAndSay(int n) {
         String s = "1";

        for (int i = 2; i <= n; i++) {
            String ans = "";
            int j = 0;

            while (j < s.length()) {
                int count = 0;
                char ch = s.charAt(j);

                while (j < s.length() && s.charAt(j) == ch) {
                    count++;
                    j++;
                }

                ans += count;
                ans += ch;
            }

            s = ans;
        }

        return s;
        
    }
}
