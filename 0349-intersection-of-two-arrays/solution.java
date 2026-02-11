class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int x : nums1){
            first.add(x);
        }
        for(int x : nums2){
            if(first.contains(x)){
                res.add(x);
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for(int a : res){
            ans[i++] = a;
        }
          return ans;
    }
}


