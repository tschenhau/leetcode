class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums = [*nums1, *nums2]
        nums.sort()
        return median(nums)