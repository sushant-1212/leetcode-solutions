class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalapp = 0;
        for(int x: apple){
            totalapp+=x;
        }
        int use = 0;
        int minSum = 0;
        Arrays.sort(capacity);
        for(int i = capacity.length-1; i>=0; i--){
            minSum+=capacity[i];
            use++;
            if(minSum>=totalapp){
                return use;
            }
        }
        return use;
    }
}
