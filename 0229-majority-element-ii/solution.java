class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=0;
        int candidate2 = 0;
        int count1=0;
        int count2=0;
        for(int x: nums){
            if(x==candidate1){
                count1++;
            }
            else if(x==candidate2){
                count2++;
            }
            else if(count1==0){
                candidate1 = x;
                count1=1;
            }
            else if(count2==0){
                candidate2=x;
                count2=1;
            } else{
                count1--;
                count2--;
            }
        }
         count1=0;
         count2=0;
        for(int x : nums){
            if(x==candidate1){
                count1++;
            } else if(x==candidate2){
                count2++;
            }
        }
        List<Integer>ans = new ArrayList<>();
        int n = nums.length;
        if(count1>n/3){
            ans.add(candidate1);
        }
        if( candidate2 != candidate1 && count2>n/3){
            ans.add(candidate2);
        }
        return ans;
        
    }
}
