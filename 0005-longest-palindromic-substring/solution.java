class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 1; i<=(n-2); i++){
            int j = i-1;
            int k = i+1;
            int length = 1;
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
                length+=2;
                j--;
                k++;
            }
            if(length>maxLength){
                maxLength = length;
                startIndex = j+1;
                endIndex = k-1;
            }
        }
         for(int i = 0; i<n; i++){
            int j = i;
            int k = i+1;
            int length = 0;
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
                length+=2;
                j--;
                k++;
            }
            if(length>maxLength){
                maxLength = length;
                startIndex = j+1;
                endIndex = k-1;
            }
        }
        return s.substring(startIndex,endIndex+1);
        
    }
}
