class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> m = new HashMap<>();
        int n = arr.length;
        for(int i : arr){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int x: m.values()){
            if(count.containsKey(x)){
                return false;
            }
            count.put(x,1);
        }
        return true;
        
        
    }
}
