class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        int length;
        for (int i = 0; i < nums.length; i++) {
            length = String.valueOf(nums[i]).length();
            if (length % 2 == 0)
                ans++;
        }
        return ans;
    }
}
