class Solution {
    public void swap(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

    }
    public void reverseString(char[] s) {
        swap(s,0,s.length-1);
        
    }
}
