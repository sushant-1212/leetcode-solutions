class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<int[]> st = new Stack<>();

        // NORMAL FOR LOOP (NO SHORTCUTS)
        for (int idx = 0; idx < s.length(); idx++) {

            char c = s.charAt(idx);   // get character at index

            // If stack is not empty and top char == current char
            if (!st.isEmpty() && st.peek()[0] == c) {

                // increase the count of top
                st.peek()[1]++;

                // if count becomes k, pop
                if (st.peek()[1] == k) {
                    st.pop();
                }

            } else {
                // Push new element [char, 1]
                st.push(new int[]{c, 1});
            }
        }

        // Build answer
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            int[] pair = st.get(i);
            char ch = (char) pair[0];
            int cnt = pair[1];

            for (int j = 0; j < cnt; j++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

