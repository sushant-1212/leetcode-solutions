class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<=s.length()-k; i++){
            String sub = s.substring(i,i+k);
            set.add(sub);
        }
        if(set.size()==Math.pow(2,k)){
            return true;
        }
        return false;
    }
}
