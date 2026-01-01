class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int totalcost = 0;
        int maxtime = 0;
        for(int i = 0; i<colors.length(); i++){
            if(i==0 || colors.charAt(i)!=colors.charAt(i-1)){
                maxtime = neededTime[i];
            } else{
                totalcost += Math.min(maxtime,neededTime[i]);
                maxtime = Math.max(maxtime,neededTime[i]);
            }
        }
        return totalcost;
    }
}
