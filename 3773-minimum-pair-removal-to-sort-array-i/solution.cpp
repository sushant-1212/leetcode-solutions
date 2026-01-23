class Solution {
public:
    int minimumPairRemoval(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans;

        // copy nums into ans
        for (int i = 0; i < nums.size(); i++) {
            ans.push_back(nums[i]);
        }

        int ops = 0;

        while (!isSorted(ans)) {
            int minSum = INT_MAX;
            int index = -1;

            // find adjacent pair with minimum sum
            for (int i = 0; i < ans.size() - 1; i++) {
                int sum = ans[i] + ans[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // merge the pair
            int mergevalue = ans[index] + ans[index + 1];
            ans[index] = mergevalue;
            ans.erase(ans.begin() + index + 1);
            ops++;
        }

        return ops;
    }

private:
    bool isSorted(vector<int>& ans) {
        for (int i = 1; i < ans.size(); i++) {
            if (ans[i] < ans[i - 1]) {
                return false;
            }
        }
        return true;
    }
};

