class Solution {
    public String reverseWords(String s) {

        s = s.trim();

        String[] arr = s.split("\\s+");

        // 3. Reverse array in place
        int i = 0, j = arr.length - 1;
        while (i < j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

       
        return String.join(" ", arr);
    }
}


