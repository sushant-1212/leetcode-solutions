class Solution {
    public int divisibleGame(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;

       
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        int limit = Math.max(2, maxVal);

        
        boolean[] isComposite = new boolean[limit + 1];

        long bestScore = Long.MIN_VALUE;
        int bestK = -1;

        
        for (int k = 2; k <= limit; k++) {

            if (isComposite[k]) {
                continue; 
            }

         
            for (long multiple = (long) k * k; multiple <= limit; multiple += k) {
                isComposite[(int) multiple] = true;
            }

          
            long currentSum = 0;
            long bestSumForThisK = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                long value;
                if (nums[i] % k == 0) {
                    value = nums[i];   
                } else {
                    value = -nums[i];   
                }

                
                currentSum = Math.max(value, currentSum + value);
                bestSumForThisK = Math.max(bestSumForThisK, currentSum);
            }

          
            if (bestSumForThisK > bestScore) {
                bestScore = bestSumForThisK;
                bestK = k;
            }
        }

       
        long scoreMod = ((bestScore % MOD) + MOD) % MOD;
        long answer = (scoreMod * bestK) % MOD;

        return (int) answer;
    }
}
