class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<landStartTime.length; i++){
            for(int j=0; j<waterStartTime.length; j++){


                int landfinish = landStartTime[i]+landDuration[i];

                int finish1 = Math.max(landfinish,waterStartTime[j])+waterDuration[j];

                ans = Math.min(ans,finish1);

                int waterfinish = waterStartTime[j]+waterDuration[j];

                int finish2 = Math.max(waterfinish,landStartTime[i])+landDuration[i];

                ans = Math.min(ans,finish2);

            }
        }


        return ans;

        
    }
}
