package JianZhi;

import java.util.Arrays;

public class T04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i<=matrix.length-1 && j>=0) {
        	if(matrix[i][j] == target) {
        		return true;
        	}
        	else if(matrix[i][j] > target) {
				j--;
			}else {
				i++;
			}
        }
        return false;
    }
    public static void main(String[] args) {
//		int a[][] = {{1,4,5,7},{2,5,6,9},{4,8,10,12},{7,10,13,20}}; 
    	int a[][] =  {};
//		System.out.println(Arrays.toString(a[0]));
		System.out.println(a.length);
	}
}
