class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = 0;
        arr[0]=1;
        max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]+1){
                arr[i] = arr[i-1]+1;
            }
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
