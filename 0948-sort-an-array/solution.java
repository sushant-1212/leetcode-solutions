
class Solution {
    public void merge(int start , int mid , int end , int[] nums){
        int i = start;
        int  j = mid + 1;
        List <Integer> ans = new ArrayList<>();
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                ans.add(nums[i]);
                i++;
            } else{
                ans.add(nums[j]);
                j++;
            }
        }
        while(j<=end){
            ans.add(nums[j]);
            j++;
        }
        while(i<=mid){
            ans.add(nums[i]);
            i++;
        }
        for(int k = 0; k<ans.size(); k++){
            nums[start + k] = ans.get(k);
        }
    }
    public void mergesort(int start , int end , int[]nums){
        if(start>=end){
            return;
        }
        int mid = (start + end)/2;
        mergesort(start,mid,nums);
        mergesort(mid+1,end,nums);
        merge(start, mid, end, nums);

    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        mergesort(start,end,nums);
        return nums;
        
    }
}
