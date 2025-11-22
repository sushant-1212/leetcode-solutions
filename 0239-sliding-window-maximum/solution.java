class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        int i = 0;
        int ans[] = new int[(n-k+1)];
        while(i<k){
            while(!q.isEmpty()&& nums[i]>=nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
            i++;
        }
        int inx = 0;
        while(i<n){
            ans[inx] = nums[q.getFirst()];
            inx++;
            while(!q.isEmpty() && q.getFirst()<=(i-k)){
                q.removeFirst();
            }

            while(!q.isEmpty() && nums[i]>=nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
            i++;
        }
        ans[inx] = nums[q.getFirst()];
        return ans;
    }
}

