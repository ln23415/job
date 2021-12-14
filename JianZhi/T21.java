package JianZhi;

import java.util.Arrays;

public class T21 {
    public static int[] exchange(int[] nums) {
    	int left = -1;
    	int right  = nums.length;
    	while(nums.length!=0) {
    		while(nums[++left]%2!=0 && left<nums.length-1 ) {
    			System.out.println(left);
    		}
    		while(nums[--right]%2==0 && right>0);
    		if(left>=right) break;
    		int temp = nums[left];
    		nums[left] = nums[right];
    		nums[right] = temp;
    	}
    	return nums;
    }
    public static void main(String[] args) {
		int a[] = {1,3,5,7};
		System.out.println(Arrays.toString(exchange(a)));
	}
}
