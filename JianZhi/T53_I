package JianZhi;

public class T53_I {
    public static int search(int[] nums, int target) {
    	int begin=-1;
        for(int i=0; i<nums.length; i++) {
        	if(begin==-1 && nums[i]==target) {
        		begin = i;
        	}
        	if((begin!=-1 && i==(nums.length-1)) || (begin!=-1 && nums[i+1]>target)){
				return i - begin + 1;
			}
        }
        return 0;
    }
    
    public static void main(String[] args) {
		int arr[] = {3,1,1,6};
		System.out.println(search(arr, 1));
	}
}
