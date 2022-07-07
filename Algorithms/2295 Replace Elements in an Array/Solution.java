import java.util.HashMap;

import javax.management.OperationsException;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int j=0; j<operations.length; j++){
            int index = map.get(operations[j][0]);
            nums[index] = operations[j][1];

            map.remove(operations[j][0]);
            map.put(nums[index], index);
        }
        return nums;
    }
}


//[1,2,4,6]
//[[1,3],[4,7],[6,1]]