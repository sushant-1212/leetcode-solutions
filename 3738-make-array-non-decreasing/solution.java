import java.util.*;

class Solution {
    public int maximumPossibleSize(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < nums.length; i++) {

            int currMax = nums[i];

           
            while(!st.isEmpty() && st.peek() > currMax) {
                currMax = Math.max(currMax, st.pop());
            }

            st.push(currMax);
        }

        return st.size();
    }
}
