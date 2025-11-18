class Solution {
    public int[] nextSmallerLeft(int[] heights){
        int n = heights.length;
        int ans[] = new int[n];
        for(int i = 0; i<n; i++){
            ans[i]=-1;
        }
        Stack<Integer>st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmallerRight(int[] heights){
          int n = heights.length;
            int ans[] = new int[n];
            for(int i = 0; i<n; i++){
                ans[i]=n;
            }
            Stack<Integer>st = new Stack<>();
            for(int i = 0; i<n; i++){
                while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                    ans[st.peek()] = i;
                    st.pop();
                }
                st.push(i);
            }
            return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] =  nextSmallerLeft(heights);
        int right[] = nextSmallerRight(heights);
        int max = 0;
        for(int i = 0; i<n; i++){
            int width = right[i]-left[i]-1;
            int area = width * heights[i];
            max = Math.max(max,area);

        }
        return max;
        
    }
}
