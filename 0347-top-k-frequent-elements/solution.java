class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int x : nums){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> m.get(a)-m.get(b));
        for(int x : m.keySet()){
            pq.add(x);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = k-1; i>=0; i--){
            ans[i] = pq.poll();
        }
        return ans;

    }
}
