class Solution {
    public int binaryGap(int n) {
        int prev = -1;
        int curr = 0;
        int ans = 0;
        while(n>0){
            if((n&1)==1){
                if(prev!=-1){
                    ans = Math.max(ans,curr-prev);
                }
                prev = curr;
            }
            n = n>>1;
            curr++;
        }
        return ans;
    }
}
