class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long sum = 0;
        int select = 0;
        Arrays.sort(happiness);
        for(int i = n-1; i>=0 && select<k; i--){
            int curr = happiness[i]-select;
            if(curr<=0){
                break;
            }
            sum+=curr;
            select++;
        }
        return sum;
    }
}
