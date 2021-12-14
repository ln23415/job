package JianZhi;

public class T13_DFS {
	int m, n, k;
	int visited[][];
    public int movingCount(int m, int n, int k) {
    	this.k = k;
    	this.m = m;
    	this.n = n;
    	this.visited = new int[m][n];
    	return dfs(0, 0);
    }
    public int dfs(int i, int j) {
    	if(i>=this.m || j>=this.n || sum(i)+sum(j)>k || visited[i][j]==1) {
    		return 0;
    	}
    	visited[i][j] = 1;
    	return 1 + dfs(i+1, j) + dfs(i, j+1);
    }
	public static int sum(int number) {
		int re = 0;
		while(number!=0) {
			re = re + number%10;
			number = number / 10;
		}
		return re;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(88));
	}
}	
