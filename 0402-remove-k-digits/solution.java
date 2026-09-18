class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            char c = num.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }

            st.push(c);
        }

        for (int i = 0; i < k; i++) {
            st.pop();
        }

        String ans = "";

        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }

        int i = 0;

        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }

        ans = ans.substring(i);

        if (ans.length() == 0) {
            return "0";
        }

        return ans;
    }
}
