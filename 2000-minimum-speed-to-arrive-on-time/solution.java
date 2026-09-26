class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;
        if(hour<=dist.length-1){
            return -1;
        }
        while(low<high){
            int mid = low+(high-low)/2;
              double h = 0;
            for(int i=0; i<dist.length; i++){
                if(i==dist.length-1){
                    h+=(double) dist[i]/mid;
                } else{
                    h+=(dist[i]+mid-1)/mid;
                }
            }
            if(h<=hour){
                high = mid;
            } else{
                low = mid+1;
            }
            
        }
        return low; 
        
    }
}
