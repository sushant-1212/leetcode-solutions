class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int ans = 0;
        int n = arrays.size();
        for(int i = 1; i<n; i++){
            List<Integer> curr = arrays.get(i);
            int currmin = curr.get(0);
            int currmax = curr.get(curr.size()-1);
            ans = Math.max(ans,Math.abs(currmax-min));
            ans = Math.max(ans,Math.abs(max-currmin));
            max = Math.max(max,currmax);
            min = Math.min(min,currmin);

        }
        return ans;
        
    }
}
