class Solution{
    public int countPrimes(int n){
        boolean isPrime[] = new boolean[n];
        int count = 0;
        for(int i =2; i<n; i++){
            isPrime[i] = true;
        }
        for(int i = 1; i*i<n; i++){
            if(isPrime[i]==true){
                for(int j = i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(isPrime[i]==true){
                count++;
            }
        }
        return count;
    }
}
       
        

