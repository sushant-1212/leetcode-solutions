class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Queue<Character> q = new LinkedList<>();
        int fre[] = new int[256];
        for(int i = 0; i<s.length(); i++){
            int value = (int)s.charAt(i);
            fre[value]++;
            q.add(s.charAt(i));
            while(q.size() > 0 && fre[value]>1){
            int v = (int)q.peek();
            fre[v]--;
            q.remove();
        }
        ans = Math.max(ans,(int)q.size());
        }
        
       return ans;
    }
}
        
