class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = 100000 + 1;
        int countDivisors[] = new int[n];
        int sumDivisors[] = new int[n];
        for(int i = 1; i<n; i++){
            for(int j = i; j<n; j+=i){
                countDivisors[j]++;
                sumDivisors[j]+=i;
            }
        }
        int count = 0;
        int N = nums.length;
        for(int i = 0; i<N; i++){
            if(countDivisors[nums[i]]==4){
                count+=sumDivisors[nums[i]];
            }
        }
        return count;
    }
}
        
        
        
