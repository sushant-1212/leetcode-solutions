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
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] arr = new int[n][m];
        for(int i = 0; i<m; i++){
            int sum = 0;
            for(int j = 0; j<n; j++){
                if(matrix[j][i]=='1'){
                    sum++;
                } else{
                    sum = 0;
                }
                arr[j][i]=sum;
            }
        }
        int maxArea = 0;
        for(int i = 0; i<n; i++){
            int area = largestRectangleArea(arr[i]);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
        
    }
}
