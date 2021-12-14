package JianZhi;

public class T11 {
    public static int minArray(int[] numbers) {
    	int left  = 0;
    	int right = numbers.length-1;
    	while(left<right) {
    		int mid = (left + right) / 2;
    		if(numbers[mid] >= numbers[left]) {
    			if(numbers[mid]<numbers[mid-1]) return numbers[mid];
    			left = mid + 1;
    		}else {
    			right = mid;
    		}
    	}
    	return numbers[left];
    }
    public static void main(String[] args) {
    	int arr[] = {2,3,4,5,1};
		System.out.println(minArray(arr));
	}
}
