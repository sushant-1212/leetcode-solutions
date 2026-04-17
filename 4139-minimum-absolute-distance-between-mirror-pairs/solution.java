class Solution {
    private int revs(int x){
        int rev = 0;
        while(x > 0){
            int digit = x % 10;
            rev = (rev * 10) + digit;
            x = x / 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int rev = revs(nums[i]);

            if(map.containsKey(nums[i])){
                int dist = i - map.get(nums[i]);
                if(dist < minDist){
                    minDist = dist;
                }
            }

            map.put(rev, i);
        }

        if(minDist == Integer.MAX_VALUE){
            return -1;
        }

        return minDist;
    }
}
