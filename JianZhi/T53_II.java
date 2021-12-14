package JianZhi;

public class T53_II {
    public static int missingNumber(int[] nums) {
    	int left = 0;
    	int right = nums.length-1;
    	while(left<right) {
        	int mid = (right + left)/2;
        	if(mid == nums[mid]) {
        		left = mid + 1;
        		if(left!=nums[left]) 
        			return left;
        	}else {
        		right = mid;
    		}
    	}
    	return left;
    }

    public static void main(String[] args) {
		int arr[] = {0};
		System.out.println(missingNumber(arr));
	}
}
