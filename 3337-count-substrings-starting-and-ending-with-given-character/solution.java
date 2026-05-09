class Solution {
    public long countSubstrings(String s, char c) {
        long countSubs = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                countSubs++;
            }
        }
        return countSubs*(countSubs+1)/2;
        
    }
}
