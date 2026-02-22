class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left; i<=right; i++){
            int count = 0;
            int n = i;
            while(n>0){
                 n = n&(n-1);
                count++;
            }
            if(isPrime(count)){
                ans++;
            }
        }
        return ans;
    }
    private boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i = 2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
