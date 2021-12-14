package JianZhi;

public class T42 {
    public int maxSubArray(int[] nums) {
    	int pre = 0;
    	int max_value = Integer.MIN_VALUE;
    	for(int num: nums) {
    		pre = Math.max(pre+num, num);
    		max_value = Math.max(max_value, pre);
    	}
    	return max_value;
    }
}
