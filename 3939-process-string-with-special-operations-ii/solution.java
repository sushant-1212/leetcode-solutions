class Solution {
    public char processStr(String s, long k) {

        int n = s.length();
        long[] len = new long[n + 1];

        for(int i=0; i<n; i++){

            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                len[i + 1] = len[i] + 1;
            }
            else if(ch == '*'){
                len[i + 1] = Math.max(0, len[i] - 1);
            }
            else if(ch == '#'){
                len[i + 1] = Math.min((long)1e15 + 1, len[i] * 2);
            }
            else{ 
                len[i + 1] = len[i];
            }
        }

        if(k >= len[n]){
            return '.';
        }

        for(int i=n-1; i>=0; i--){

            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){

                if(k == len[i + 1] - 1){
                    return ch;
                }
            }

            else if(ch == '#'){

                long oldLen = len[i];

                if(k >= oldLen){
                    k -= oldLen;
                }
            }

            else if(ch == '%'){

                long oldLen = len[i];

                k = oldLen - 1 - k;
            }

            else{
               
            }
        }

        return '.';
    }
}
