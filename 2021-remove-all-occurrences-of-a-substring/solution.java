class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int len = part.length();
        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            if(sb.length()>=len){
                String end = sb.substring(sb.length()-len);
                if(end.equals(part)){
                    sb.delete(sb.length()-len,sb.length());
                }
            }
        }
        return sb.toString();
    }
}
