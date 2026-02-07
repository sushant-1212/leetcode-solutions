class Solution {
    public int secondHighest(String s) {
        int n = s.length();
        int largest = -1;
        int second = -1;
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int d = ch-'0';
                if(d>largest){
                    second = largest;
                    largest = d;
                } else if(d<largest && d>second){
                    second = d;
                }
            }
        }
        return second;        
    }
}
