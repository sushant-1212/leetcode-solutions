class Solution {
    public String longestPalindrome(String s) {
        int strt = 0;
        int end = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            int left = i;
            int right = i;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                if(right-left-1 > end-strt){
                    strt = left+1;
                    end = right-1;
                }
            }
            left = i;
            right = i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                if(right-left-1 > end-strt){
                    strt = left+1;
                    end = right-1;
                }
            }
        }
        return s.substring(strt,end+1);
        
    }
}
