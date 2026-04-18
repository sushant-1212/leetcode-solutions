class Solution {
    private int rev(int x){
        int rev = 0;
        while(x>0){
            int digit = x%10;
            rev=(rev*10)+digit;
            x=x/10;
        }
        return rev;
    }
    public int mirrorDistance(int n) {
        int res = rev(n);
        int dist = Math.abs(res-n);
        return dist;
        
    }
}
