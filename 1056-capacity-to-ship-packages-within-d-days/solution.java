class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
         for(int i=0; i<weights.length; i++){
            low = Math.max(low,weights[i]);
            high+=weights[i];
         }
         while(low<high){
            int mid = low+(high-low)/2;
            int day = 1;
            int currWeight = 0;
            for(int i=0; i<weights.length; i++){
                if(currWeight+weights[i]>mid){
                    day++;
                    currWeight = 0;
                }
                currWeight+=weights[i];
            }
            if(day<=days){
                high = mid;
            } else{
                low = mid+1;
            }
         }
         return low;
    }
}
