class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String dob = s+s;
        return dob.contains(goal);
    }
}
