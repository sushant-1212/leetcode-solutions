class Solution {
public:
vector<vector<int>> answer = {};
vector<int> currentSeq ={};
void recur(int index , vector<int>& nums){
    if(index == nums.size()){
        answer.push_back(currentSeq);
        return;
    }
    currentSeq.push_back(nums[index]);
    recur(index + 1 , nums);
    currentSeq.pop_back();
    recur(index + 1 , nums);
}
    vector<vector<int>> subsets(vector<int>& nums) {
        recur(0,nums);
        return answer;
        
    }
};
