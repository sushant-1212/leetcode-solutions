class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int minDel = 0;
        for( char ch : s.toCharArray()){
            if(ch=='b'){
                countB++;
            } else{
                minDel = Math.min(minDel+1,countB);
            }
        }
        return minDel;
        
    }
}
