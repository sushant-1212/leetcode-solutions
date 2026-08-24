class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> free =
            new PriorityQueue<>();

        PriorityQueue<long[]> busy =
            new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0])
                    return Long.compare(a[1], b[1]);
                return Long.compare(a[0], b[0]);
            });

        for (int i = 0; i < n; i++) {
            free.add(i);
        }

        int[] count = new int[n];

        for (int i = 0; i < meetings.length; i++) {

            long start = meetings[i][0];
            long end = meetings[i][1];
            long duration = end - start;

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add((int) busy.poll()[1]);
            }

            if (!free.isEmpty()) {

                int room = free.poll();

                busy.add(new long[]{end, room});
                count[room]++;

            } else {

                long[] roomInfo = busy.poll();

                long newEnd = roomInfo[0] + duration;
                int room = (int) roomInfo[1];

                busy.add(new long[]{newEnd, room});
                count[room]++;
            }
        }

        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
