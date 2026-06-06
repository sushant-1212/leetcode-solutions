class Solution {
    public int[] leftRightDifference(int[] nums) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            left.add(sum);
            sum+=nums[i];
        }
        sum = 0;
        for(int i=0; i<nums.length; i++){
            right.add(0);
        }
        for(int i=nums.length-1; i>=0; i--){
            right.set(i,sum);
            sum+=nums[i];
        }
        int[]ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i]=Math.abs(left.get(i)-right.get(i));
        }
        return ans;
    }
}
