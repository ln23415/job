package JianZhi;

public class T45 {
    public static String minNumber(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int minimum_idx = i;
            for(int j=i+1; j<nums.length; j++) {
                if(is_less(nums[j], nums[minimum_idx])) {
                    minimum_idx = j;
                }
            }
            nums = swap(nums, i, minimum_idx);
        }
        StringBuilder str = new StringBuilder();
        for(int num: nums) {
        	str.append(num);
        }
        return str.toString();
    }
    public static int[] swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    public static boolean is_less(int num1, int num2) {
    	String number1 = String.valueOf(num1);
    	String number2 = String.valueOf(num2);
    	if((number1+number2).compareTo(number2+number1)<0) {
    		return true;
    	}else {
			return false;
		}
    }
    
    // 为什么用sum函数不行：因为这个函数只适用于计算0~100的十位数。
	public static int sum(String num) {
		int number = Integer.parseInt(num);
		int re = 0;
		while(number!=0) {
			re = re + number%10;
			number = number / 10;
		}
		return re;
	}
	public static void main(String[] args) {
		String num1 = "10";
		String num2 = "20";
//		System.out.println(num1.substring(0, 1).compareTo(num2.substring(0, 1))<0);
//		System.out.println(minNumber(new int[] {3,30,34,5,9}));
		System.out.println(is_less(10, 2));
	}
}
