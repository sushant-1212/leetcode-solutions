#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> solveQueries(vector<int>& nums, vector<int>& queries) {
        int n = nums.size();

       
        unordered_map<int, vector<int>> mp;

        for (int i = 0; i < n; i++) {
            mp[nums[i]].push_back(i);
        }

        vector<int> ans;

        for (int q : queries) {
            vector<int>& list = mp[nums[q]];

            // if only one occurrence
            if (list.size() == 1) {
                ans.push_back(-1);
                continue;
            }

            int pos = lower_bound(list.begin(), list.end(), q) - list.begin();

            int size = list.size();

            int leftIdx = list[(pos - 1 + size) % size];
            int rightIdx = list[(pos + 1) % size];

            int d1 = abs(q - leftIdx);
            int d2 = abs(q - rightIdx);

            int dist1 = min(d1, n - d1);
            int dist2 = min(d2, n - d2);

            ans.push_back(min(dist1, dist2));
        }

        return ans;
    }
};
