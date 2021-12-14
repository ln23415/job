package JianZhi;

import java.util.HashSet;
import java.util.Set;

public class T61 {
    public boolean isStraight(int[] nums) {
    	Set<Integer> set = new HashSet<Integer>();
    	int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    	for(int num : nums) {
    		if (num == 0) {
				continue;
			}
    		if (set.contains(num)) {
				return false;
			}
    		set.add(num);
    		min = Math.min(min, num);
    		max = Math.max(max, num);
    	}
    	return (max - min) < 5;
    }
}
