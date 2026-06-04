class Solution {

    private int getWaviness(int num) {

        int[] digit = new int[20];
        int len = 0;

        while (num > 0) {
            digit[len++] = num % 10;
            num /= 10;
        }

        int wave = 0;

        for (int i = 1; i < len - 1; i++) {

            if ((digit[i] > digit[i - 1] && digit[i] > digit[i + 1]) ||
                (digit[i] < digit[i - 1] && digit[i] < digit[i + 1])) {
                wave++;
            }
        }

        return wave;
    }

    public int totalWaviness(int num1, int num2) {

        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            ans += getWaviness(num);
        }

        return ans;
    }
}

