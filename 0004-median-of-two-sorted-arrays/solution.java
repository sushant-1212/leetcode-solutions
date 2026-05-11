class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m+n];
        int i=0;
        int j=0;
        int pos=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                merge[pos]=nums1[i];
                i++;
            } else{
                merge[pos]=nums2[j];
                j++;
            }
            pos++;
        }
        while(i<m){
            merge[pos]=nums1[i];
            i++;
            pos++;
        }
        while(j<n){
            merge[pos]=nums2[j];
            j++;
            pos++;
        }
        int len = merge.length;
        if(len%2!=0){
            return(merge[len/2]);
        } else{
            int mid1 = merge[len/2];
            int mid2 = merge[(len/2)-1];
            return (mid1 + mid2) / 2.0;
        }
        
    }
}
