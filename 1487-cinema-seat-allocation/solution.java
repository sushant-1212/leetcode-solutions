class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }

            map.get(row).add(seat);
        }

        long ans = (long)n * 2;

        for (int row : map.keySet()) {

            HashSet<Integer> set = map.get(row);

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int seat = 2; seat <= 5; seat++) {
                if (set.contains(seat)) {
                    left = false;
                }
            }

            for (int seat = 4; seat <= 7; seat++) {
                if (set.contains(seat)) {
                    middle = false;
                }
            }

            for (int seat = 6; seat <= 9; seat++) {
                if (set.contains(seat)) {
                    right = false;
                }
            }

            if (left && right) {
    
            } 
            else if (left || middle || right) {
                ans--;
            } 
            else {
                ans -= 2;
            }
        }

        return (int)ans;
    }
}
