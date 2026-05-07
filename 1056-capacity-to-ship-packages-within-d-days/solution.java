class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        
        for(int i = 0; i < weights.length; i++) {

            low = Math.max(low, weights[i]);

            high += weights[i];
        }

        
        while(low < high) {

            int mid = low + (high - low) / 2;

            if(canShip(weights, days, mid)) {

                high = mid;
            }
            else {

                low = mid + 1;
            }
        }

        return low;
    }


    private boolean canShip(int[] weights,
                            int days,
                            int capacity) {

        int usedDays = 1;

        int load = 0;

        for(int i = 0; i < weights.length; i++) {

         
            if(load + weights[i] > capacity) {

                usedDays++;

                load = 0;
            }

            load += weights[i];
        }

        return usedDays <= days;
    }
}
