class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int leftheight = 0;
        int rightheight = 0;
        int water = 0;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=leftheight){
                    leftheight = height[l];
                } else{
                    water += leftheight-height[l];
                }
                l++;
            } else{
                if(height[r]>=rightheight){
                    rightheight = height[r];
                } else{
                    water += rightheight-height[r];
                }
                r--;
            }
        }
        return water;
    }
}
