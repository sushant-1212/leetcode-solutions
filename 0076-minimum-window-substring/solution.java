class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            if(map1.containsKey(c)){
                map2.put(c,map2.getOrDefault(c,0)+1);
                if(map2.get(c) <= map1.get(c)){
                    count++;
                }
            }
            while(count == t.length()){
                if(minLen>right-left+1){
                    minLen = right-left+1;
                    start = left;
                }
            char ch = s.charAt(left);
            if(map1.containsKey(ch)){
                if(map2.get(ch) <= map1.get(ch)){
                    count--;
                }
                map2.put(ch,map2.get(ch)-1);
            }
            left++;
            }

        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(start,start+minLen);
        
    }
}
