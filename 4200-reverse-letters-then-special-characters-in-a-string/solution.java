class Solution {
    public String reverseByType(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(c>='a' && c<='z'){
                letters.add(c);
            } else{
                chars.add(c);
            }
        }
        Collections.reverse(letters);
        Collections.reverse(chars);
        StringBuilder b = new StringBuilder();
        int i = 0;
        int j = 0;
        for(char c : s.toCharArray()){
            if(c>='a' && c<='z'){
                b.append(letters.get(i++));
            } else{
                b.append(chars.get(j++));
            }
        }
        return b.toString();
        
    }
}
