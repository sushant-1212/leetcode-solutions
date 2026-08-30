class Solution {
    public int minimumDeletions(int[] nums) {
        
        int minIndex = 0;
        int maxIndex = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i]<nums[minIndex])  minIndex = i;
            if(nums[i]>nums[maxIndex]) maxIndex = i;
        }

        int low = Math.min(minIndex,maxIndex);
        int high = Math.max(minIndex,maxIndex);

        int frontOnly = high + 1;

        int backOnly = n - low;

        int appropriate = (low + 1) + (n-high);

        return Math.min(frontOnly , Math.min(backOnly,appropriate));
    }
}
