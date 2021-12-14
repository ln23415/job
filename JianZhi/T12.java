package JianZhi;

public class T12 {
    public boolean exist(char[][] board, String word) {
    	char words[] = word.toCharArray();
    	for(int i=0; i<board.length; i++) {
    		for(int j=0; j<board[0].length; j++) {
    			if(dfs(board, words, i, j, 0)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public static boolean dfs(char[][] board, char[] words, int i, int j, int idx) {
    	if(i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]!=words[idx]) {
    		return false;
    	}
    	board[i][j] = '\0';
    	boolean res = (idx == words.length - 1) || 
    			dfs(board, words, i-1, j, idx+1) || dfs(board, words, i+1, j, idx+1) ||
    			dfs(board, words, i, j-1, idx+1) || dfs(board, words, i, j+1, idx+1);
    	board[i][j] = words[idx];
    	return res;
    }
}
