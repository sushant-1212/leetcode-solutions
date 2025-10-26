class Solution {
public:
    void merge(int start , int mid , int end , vector<int>& nums){
        int i = start;
        int j = mid + 1;
        vector<int> ans;
        
        while(i <= mid && j <= end){
            if(nums[i] <= nums[j]){
                ans.push_back(nums[i]);
                i++;
            } else {
                ans.push_back(nums[j]);
                j++;
            }
        }
        while(i <= mid){
            ans.push_back(nums[i]);
            i++;
        }
        while(j <= end){
            ans.push_back(nums[j]);
            j++;
        }
        for(int k = 0; k < ans.size(); k++){
            nums[start + k] = ans[k];
        }
    }

    void mergesort(int start , int end , vector<int>& nums ){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(start, mid, nums);
        mergesort(mid + 1, end, nums);
        merge(start, mid, end, nums); 
    }

    vector<int> sortArray(vector<int>& nums) {
        int n = nums.size();
        mergesort(0, n - 1, nums);
        return nums;
    }
};

