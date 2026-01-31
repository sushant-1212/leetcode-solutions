class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> m = new HashMap<>();;
        for(String x : words){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>( (a,b) -> {
            if(m.get(a).equals(m.get(b))){
                return b.compareTo(a);
            }
            return m.get(a)-m.get(b);
        }
        );
        for(String x : m.keySet()){
            pq.add(x);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
