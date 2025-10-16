class Solution {
    public boolean isPalindrome(int x) {
        int ans=0;
        int rev = 0;
        int s = x;
        if(x<0){
            return false;
        }
        while(s>0){
            int lastdigit = s%10;
            rev = rev*10 + lastdigit;
            s = s/10;
            
            }
            return x ==rev;
        }
        
    }

