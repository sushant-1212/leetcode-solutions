class Solution {
    public int[] rotateElements(int[] nums, int k) {

       
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : nums) {
            if (x >= 0) {
                list.add(x);
            }
        }

        int size = list.size();
        if (size == 0) return nums;   

        k = k % size;

  
        ArrayList<Integer> rotated = new ArrayList<>();
        for (int i = k; i < size; i++) {
            rotated.add(list.get(i));
        }
        for (int i = 0; i < k; i++) {
            rotated.add(list.get(i));
        }

        
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = rotated.get(idx++);
            }
        }

        return nums;
    }
}

