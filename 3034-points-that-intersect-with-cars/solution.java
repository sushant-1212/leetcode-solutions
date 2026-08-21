class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] covered = new boolean[101];
        for(int i=0; i<nums.size(); i++){
            int st = nums.get(i).get(0);
            int end = nums.get(i).get(1);
            for(int j = st; j<=end; j++){
                covered[j] = true;
            }
        }
        int count = 0;
        for(int k = 0; k<=100; k++){
            if(covered[k]){
                count++;
            }
        }
        return count;
    }
}
