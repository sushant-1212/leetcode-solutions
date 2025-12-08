class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> m = new HashMap<>();
        for(char x: jewels.toCharArray()){
            m.put(x,1);
        }
        int count = 0;
        for(char y: stones.toCharArray()){
            if(m.containsKey(y)){
                count++;
            }
        }
        return count;
    }
}
