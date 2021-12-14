package JianZhi;

public class T10_I {
    public static int fib(int n) {
    	int arr[] = new int[n+1];
    	return recurs(n, arr);
    }

    public static int recurs(int n, int arr[]) {
        if(n < 2){
            return n;
        }
        if(arr[n]==0) {
            arr[n] = (recurs(n-1, arr) + recurs(n-2, arr))%1000000007;
        }
        return arr[n];
    }
    
    
    
    public static void main(String[] args) {
		int re = fib(44);
		System.out.println(re);
	}
}
