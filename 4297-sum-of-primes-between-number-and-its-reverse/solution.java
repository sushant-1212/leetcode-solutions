class Solution {
    public boolean isPrime(int x){
        if(x<=1){
            return false;
        }
        for(int i=2; i*i<=x; i++){
            if(x%i==0){
                return false;
            }
        }
         return true;
    }
    public int sumOfPrimesInRange(int n) {

        int rev = 0;
        int temp = n;
        int sum=0;
        while(temp>0){
            int d = temp%10;
            rev=rev*10+d;
            temp=temp/10;
        }
        int start = Math.min(rev,n);
        int end = Math.max(rev,n);
        for(int i=start; i<=end; i++){
            if(isPrime(i)){
                sum+=i;
            }
        }
        return sum;
    }
}
