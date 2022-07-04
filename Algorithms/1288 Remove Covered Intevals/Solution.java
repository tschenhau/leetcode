class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        int length = intervals.length;
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][1] > end) {
                count++;
                end = Math.max(end, intervals[i][1]);
            }
        }
        return count;
    }
}
