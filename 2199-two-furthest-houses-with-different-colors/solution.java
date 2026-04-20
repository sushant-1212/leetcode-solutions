class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxdist = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(colors[j]!=colors[i]){
                    int dist = Math.abs(j-i);
                    maxdist = Math.max(dist,maxdist);
                }
            }
        }
        return maxdist;
    }
}
