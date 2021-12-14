package JianZhi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T03 {
    public static int findRepeatNumber(int[] nums) {
    	

    	for(int i=0; i<nums.length; ) {
    		if(nums[i] == i) {
    			i++;
    			continue;
    		}
    		int idx = nums[i];
    		if(nums[idx] == nums[i]) {
    			return nums[idx];
    		}
    		int temp = nums[idx];
    		nums[idx] = nums[i];
    		nums[i] = temp;
    	}
    	return -1;
//    	Set<Integer> set = new HashSet<Integer>();
//    	for (int k : nums) {
//    		if(set.contains(k))
//    			return k;
//    		else {
//				set.add(k);
//			}
//    	}
//    	return -1;
    }
    public static void main(String[] args) {
    	int[] nums = {3, 4, 2, 2, 0, 1};
		System.out.println(findRepeatNumber(nums));
	}
}
