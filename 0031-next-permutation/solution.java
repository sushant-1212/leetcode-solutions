class Solution {
    public void nextPermutation(int[] nums) {

        int pivot = -1;

       
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        
        if(pivot != -1) {
            for(int i = nums.length - 1; i > pivot; i--) {
                if(nums[i] > nums[pivot]) {
                    swap(nums, i, pivot);
                    break;
                }
            }
        }

     
        reverse(nums, pivot + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
