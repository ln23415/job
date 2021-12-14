package JianZhi;

import java.util.LinkedList;
import java.util.Queue;

public class T13_BFS {

	
	public int movingCount(int m, int n, int k) {
		int visited[][] = new int[m][n];
		Queue<int[]> queue = new LinkedList<int []>();
		queue.add(new int[]{0, 0});
		int re = 0;
		while(!queue.isEmpty()) {
			int q[] = queue.poll();
			if(q[0]>=m || q[1]>=n || visited[q[0]][q[1]]==1 || (sum(q[0])+sum(q[1]))>k) {
				continue;
			}
			visited[q[0]][q[1]] = 0;
			queue.add(new int[] {q[0]+1, q[1]});
			queue.add(new int[] {q[0], q[1]+1});
			re++;
		}
		return re;
	}
	
	public static int sum(int number) {
		int re =  0;
		while(number!=0) {
			re = re + number%10;
			number = number / 10;
		}
		return re;
	}
}
