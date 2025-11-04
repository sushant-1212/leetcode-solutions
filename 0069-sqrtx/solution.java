class Solution {
    public int mySqrt(int x) {
        long st = 0;
        long end = x;
        long ans = x;
        while(st<=end){
            long mid = (st+end)/2;
            if(mid*mid<=x){
                ans = mid;
                st = mid+1;
            } else{
                end = mid-1;
            }
        }
        return (int) ans;
        
    }
}
