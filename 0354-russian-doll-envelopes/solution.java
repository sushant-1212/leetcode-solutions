import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

      
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];   
            else
                return a[0] - b[0];   
        });

        
        int[] lis = new int[envelopes.length];
        int size = 0;

        for(int[] env : envelopes){

            int h = env[1];

            int left = 0;
            int right = size;

            while(left < right){
                int mid = (left + right) / 2;

                if(lis[mid] < h)
                    left = mid + 1;
                else
                    right = mid;
            }

            lis[left] = h;

            if(left == size)
                size++;
        }

        return size;
    }
}
