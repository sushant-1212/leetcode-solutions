class Solution {
    public int digitSum(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
    public int sqSum(int n){
        int squareSum = 0;
        while(n>0){
            int digit=n%10;
            squareSum += digit*digit;
            n=n/10;

        }
        return squareSum;
    }
    public boolean checkGoodInteger(int n) {
        
        int sum1 = digitSum(n);
        int sum2 = sqSum(n);
        return sum2-sum1>=50;
        
    }
}
