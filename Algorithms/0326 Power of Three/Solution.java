class Solution {
    public boolean isPowerOfThree(int n) {
        double num = n;
        while (num > 1) {
            num = num / 3;
        }
        if (num == 1)
            return true;
        else
            return false;
    }
}
