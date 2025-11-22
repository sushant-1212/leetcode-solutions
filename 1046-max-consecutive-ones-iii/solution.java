class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int zero = 0;
        int ans = 0;
        Deque<Integer> q = new LinkedList<>();
        while(i<n){
            q.addLast(nums[i]);
            if(nums[i]==0){
                zero++;
            }
            while(q.size()>0 && zero>k){
                if(q.peek()==0){
                    zero--;
                }
                q.remove();
            }
             ans = Math.max(ans,(int)q.size());
             i++;
        }

        return ans;
    }
}
