class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            int count = 0;
            for(int i=0; i<n; i++){
                if(citations[i]>=mid){
                    count++;
                }
            }
            if(count>=mid){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return high;
        
    }
}
