class Solution {
    public int sum(int n) {
        int ans = 0;

        while (n > 0) {
            int digit = n % 10;
            ans += digit;
            n /= 10;
        }

        return ans;
    }

    public int pro(int n) {
        int prod = 1;

        while (n > 0) {
            int digit = n % 10;
            prod *= digit;
            n /= 10;
        }

        return prod;
    }

    public boolean checkDivisibility(int n) {
        int finalSum = sum(n);
        int finalProd = pro(n);

        return n % (finalSum + finalProd) == 0;
    }
}
