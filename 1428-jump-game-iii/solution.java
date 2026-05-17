class Solution {
    int[] nums;
    boolean[] vis;
    int n;
    public boolean dfs(int i){
        if(i<0 || i>=n || vis[i]){
            return false;
        }
        if(nums[i]==0){
            return true;
        }
        vis[i]=true;
        return dfs(i+nums[i]) || dfs(i-nums[i]);
    }
    public boolean canReach(int[] arr, int start) {
        
        nums = arr;
        n = arr.length;
        vis = new boolean[n];
        return dfs(start);

    }
}
