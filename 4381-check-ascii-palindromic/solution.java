class Solution {
    public boolean isPalindromic(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {

            int a = s.charAt(left);
            int b = s.charAt(right);

            for (int bit = 0; bit < 8; bit++) {

                int bitA = (a >> bit) & 1;
                int bitB = (b >> (7 - bit)) & 1;

                if (bitA != bitB) {
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }
}
