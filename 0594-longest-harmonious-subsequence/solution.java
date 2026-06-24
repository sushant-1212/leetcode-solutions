class Solution {
    public int findLHS(int[] nums) {

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {

            int x = nums[i];

            int countX = 0;
            int countXPlus1 = 0;

            for(int j = 0; j < nums.length; j++) {

                if(nums[j] == x)
                    countX++;

                else if(nums[j] == x + 1)
                    countXPlus1++;
            }

            if(countX > 0 && countXPlus1 > 0) {
                ans = Math.max(ans, countX + countXPlus1);
            }
        }

        return ans;
    }
}
