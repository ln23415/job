package JianZhi;

public class T64 {
	static int res = 0;
    public static int sumNums(int n) {
    	res = res + n;
    	boolean tmp = (n > 1) && sumNums(n - 1) > 0;
    	return res;
    }
	public static void main(String[] args) {
		System.out.println(sumNums(2));
		
	}
}
