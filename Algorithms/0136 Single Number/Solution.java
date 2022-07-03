class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        int l = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < l - 1; i += 2) {
            res = res + nums[i];
            res = res - nums[i + 1];
        }
        if (l % 2 == 1) {
            res = res + nums[l - 1];
        }
        return res;
    }
}