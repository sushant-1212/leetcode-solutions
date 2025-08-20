class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int  answer = -1;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(count==0){
                answer = nums[i];
                count = 1;
            } else if(nums[i]==answer){
                count++;
            } else{
                count--;
            }
        }
        return answer;
    }
}
        
 
