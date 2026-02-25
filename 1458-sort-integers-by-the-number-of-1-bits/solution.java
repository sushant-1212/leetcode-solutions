class Solution {
    public int countBits(int num){
        int count = 0;
        while(num>0){
            num = num & (num-1);
            count++;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        Integer[] ans = new Integer[arr.length];
        for(int i = 0; i<arr.length; i++){
            ans[i] = arr[i];
        }
        Arrays.sort( ans , (a,b) -> {
            int ca = countBits(a);
            int cb = countBits(b);
            if(ca == cb){
                return a - b;
            }
            return ca-cb;
        });
        for(int i = 0; i<ans.length; i++){
            arr[i] = ans[i];
        }
        return arr;
        
    }
}
