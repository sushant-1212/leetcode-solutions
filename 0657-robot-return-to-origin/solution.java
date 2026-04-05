class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        for(int i = 0; i<moves.length(); i++){
            char c = moves.charAt(i);
            if(c=='U'){
                up++;
            } else if(c=='D'){
                down++;
            } else if(c=='L'){
                left++;
            } else{
                right++;
            }
        }
        return (left==right) && (up == down);
    }
}
