class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        if(s1.length() > s2.length()){
            return false;
        }
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int left = 0;
        for(int right = 0; right<s2.length(); right++){
            char c2 = s2.charAt(right);
            map2.put(c2,map2.getOrDefault(c2,0)+1);
            if(right-left+1>s1.length()){
                char rem = s2.charAt(left);
                map2.put(rem,map2.get(rem)-1);
                if(map2.get(rem)==0){
                    map2.remove(rem);
                }
                left++;
            }
            if(map1.equals(map2)){
                return true;
            }
        }
        return false;
    }
}
