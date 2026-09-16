class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        int left = 0;
        for(int right = 0; right<s.length(); right++){
            char now = s.charAt(right);
            map2.put(now,map2.getOrDefault(now,0)+1);
            if(right-left+1>p.length()){
                char removeLeft = s.charAt(left);
                map2.put(removeLeft,map2.get(removeLeft)-1);
                if(map2.get(removeLeft)==0){
                    map2.remove(removeLeft);
                }
                left++;
            }
            if(right-left+1 == p.length()){
                if(map2.equals(map1)){
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
