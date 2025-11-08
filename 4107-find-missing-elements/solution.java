import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;

        // Step 1: Find min and max
        int min = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Step 2: Sort the array
        Arrays.sort(nums);

        // Step 3: Binary search for each number between min and max
        List<Integer> missing = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!binarySearch(nums, i)) {
                missing.add(i);
            }
        }

        return missing;
    }

    // Custom binary search (returns true if target exists)
    private boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
