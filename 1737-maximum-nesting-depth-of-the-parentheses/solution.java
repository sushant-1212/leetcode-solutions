class Solution {
    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                currentDepth++;
                maxDepth = Math.max(currentDepth,maxDepth);
            } else if(s.charAt(i)==')'){
                currentDepth--;
            }
        }
        return maxDepth;
        
    }
}
