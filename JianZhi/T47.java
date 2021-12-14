package JianZhi;

import java.util.Iterator;

public class T47 {
	public static int maxValue(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(i==0 && j==0) {
					continue;
				}
				if (i==0) {
					grid[i][j] = grid[i][j] + grid[i][j-1];
				}
				else if (j==0) {
					grid[i][j] = grid[i][j] + grid[i-1][j];
				}
				else {
					int from_up = grid[i][j] + grid[i-1][j];
					int from_left = grid[i][j] + grid[i][j-1];
					grid[i][j] = from_left>from_up?from_left:from_up;
				}
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
	public static void main(String[] args) {
		int a[][] = {
	              {1,3,1},
	              {1,5,1},
	    };
		System.out.println(maxValue(a));
	}
}
