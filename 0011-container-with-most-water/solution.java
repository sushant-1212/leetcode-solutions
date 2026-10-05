class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int low = 0;
        int high = height.length-1;
        while(low<high){
            int width = high - low;
            int h = Math.min(height[low],height[high]);
            int area = width * h;
            maxArea = Math.max(area,maxArea);
            if(height[low]<height[high]){
                low++;
            } else{
                high--;
            }
        }
        return maxArea;
    }
}
