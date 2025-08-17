class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; 
        int j = 0;
        int pos = 0;
        int n = nums.length;
        while(i<n){
            nums[pos] = nums[i];
            pos++;
            while(j<n && nums[i]==nums[j]){
                j++;

            }
            i=j;
        }
        return pos;
    }
}
   
