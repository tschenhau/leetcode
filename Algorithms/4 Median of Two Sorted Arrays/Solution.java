//leetcode discussion solution
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    public double getkth(int[] nums1, int n1Start, int[] nums2, int n2Start, int k) {
        if (n1Start > nums1.length - 1)
            return nums2[n2Start + k - 1];
        if (n2Start > nums2.length - 1)
            return nums1[n1Start + k - 1];
        if (k == 1)
            return Math.min(nums1[n1Start], nums2[n2Start]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (n1Start + k / 2 - 1 < nums1.length)
            aMid = nums1[n1Start + k / 2 - 1];
        if (n2Start + k / 2 - 1 < nums2.length)
            bMid = nums2[n2Start + k / 2 - 1];

        if (aMid < bMid)
            return getkth(nums1, n1Start + k / 2, nums2, n2Start, k - k / 2);// Check: aRight + bLeft
        else
            return getkth(nums1, n1Start, nums2, n2Start + k / 2, k - k / 2);// Check: bRight + aLeft
    }
}
