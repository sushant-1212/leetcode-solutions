class Solution {
    public boolean isPalindrome(String s) {
        
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            char left = Character.toLowerCase(s.charAt(l));
            char right = Character.toLowerCase(s.charAt(r));
            if(!Character.isLetterOrDigit(left)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(right)){
                r--;
                continue;
            }
            if(left!=right){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
