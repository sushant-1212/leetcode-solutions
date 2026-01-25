class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalsum = 0;
        int n = cardPoints.length;
        for(int x:cardPoints){
            totalsum+=x;
        } 
        int windowSize =  n-k;
        int windowsum = 0;
        for(int i = 0; i<windowSize; i++){
            windowsum+=cardPoints[i];
        }
        int minwindowSum = windowsum;
        for(int i = windowSize; i<n; i++){
            windowsum+=cardPoints[i];
            windowsum-=cardPoints[i-windowSize];
            minwindowSum = Math.min(minwindowSum,windowsum);
        
        }
        return totalsum-minwindowSum;      
    }
}
