class Solution {
    public double average(int[] salary) {
        int min, max, total;
        min = max = total = salary[0];
        for (int i = 1; i < salary.length; i++) {
            total += salary[i];
            max = Math.max(salary[i], max);
            min = Math.min(salary[i], min);
        }
        return (total - max - min) / (salary.length - 2);
    }
}
