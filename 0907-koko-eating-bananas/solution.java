class Solution {
    public boolean isPossible(int mid , int[]arr,int h){
        long hours = 0;
         for (int i = 0; i < arr.length; i++) {
            hours += (arr[i] + (long)mid - 1) / mid;
         }
         return hours<=h;
    } 
        
    private int getMax(int[]piles){
        int max = piles[0];
        for(int i = 1; i<piles.length; i++){
            if(piles[i]>max){
                max = piles[i];
            }
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int n = piles.length;
        int ans = right;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isPossible(mid,piles,h)){
                ans = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return ans;
    }
}
