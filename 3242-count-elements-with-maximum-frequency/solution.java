class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int x:nums){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        int maxfreq = 0;
        for(int fre: m.values()){
            maxfreq = Math.max(maxfreq,fre);
        }
        int cnt = 0;
        for(int i: m.values()){
            if(i==maxfreq){
                cnt+=maxfreq;
            }
        }
        return cnt;
        
    }
}
