class Solution {
    boolean isPossible(String a , String b){
        int diff = 0;
        for(int k = 0; k<a.length(); k++){
            if(a.charAt(k)!=b.charAt(k)){
                diff++;
            }
            if(diff>2) return false;
        }
        return true;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i<queries.length; i++){
            String q = queries[i];
            for(int j = 0; j<dictionary.length; j++){
                String d = dictionary[j];
                if(isPossible(q,d)){
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
}
