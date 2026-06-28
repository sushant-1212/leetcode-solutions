class Solution {
    public int subarrayBitwiseORs(int[] arr) {

        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();

        for (int num : arr) {

            HashSet<Integer> curr = new HashSet<>();

            curr.add(num);

            for (int x : prev) {
                curr.add(x | num);
            }

            ans.addAll(curr);

            prev = curr;
        }

        return ans.size();
    }
}
