class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int[] best = new int[arr.length];
        int INF = Integer.MAX_VALUE;
        int minLen = INF;
        for(int i=0; i<best.length; i++){
            best[i] = INF;
        }
        for(int right=0; right<arr.length; right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum == target){
                int len = right-left+1;
                if(left>0 && best[left-1]!=INF){
                    ans = Math.min(ans,len+best[left-1]);
                }
                minLen = Math.min(minLen,len);
            }
            best[right] = minLen;
        }
        if(ans==INF){
            return -1;
        }
        return ans;

    }
}
